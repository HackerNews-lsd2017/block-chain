package test;

import static org.junit.Assert.*;

import org.junit.Test;

import datastructures.Block;
import datastructures.Blockchain;
import datastructures.Transaction;

public class HappyPathBlockchain {

	private BlockchainTestUtil util = new BlockchainTestUtil();
	
	@Test
	public void chainBlock_NoInitialBlock_True() {
		Block blockToBeChained = util.getValidNotMinedBlock();
		Blockchain blockchain = new Blockchain();
		//
		blockToBeChained.mine(blockchain.getHashOfLatestBlock());
		//Chain block
		boolean chainingResult=blockchain.chainBlock(blockToBeChained);
		System.out.println(chainingResult);
		
		assertTrue(chainingResult);
	}
	
	@Test
	public void getHashOfLatestBlock_NoBlocks_00000hash() {
		Blockchain blockchain = new Blockchain();
		
		assertEquals(blockchain.getHashOfLatestBlock(),"000000000000000000000000000000000000000000000000000000000000000");
	}
	
	@Test
	public void getHashOfLatestBlock_OneBlock_True() {
		Block blockToBeChained = util.getValidNotMinedBlock();
		Blockchain blockchain = new Blockchain();
		blockToBeChained.mine(blockchain.getHashOfLatestBlock());
		System.out.println(blockchain.chainBlock(blockToBeChained));
		
		String hashOfLastBlock=blockchain.getHashOfLatestBlock();
		
		assertEquals(hashOfLastBlock,"000046138e30470da61ec35667742eae67e5d0276c3226708f5109867bff36e0");
	}
	
	@Test
	public void getHashOfLatestBlock_TwoBlocks_True() {
		Block blockToBeChained1 = util.getValidNotMinedBlock();
		Block blockToBeChained2 = util.getValidNotMinedBlock();
		Blockchain blockchain = new Blockchain();
		blockToBeChained1.mine(blockchain.getHashOfLatestBlock());
		System.out.println(blockchain.chainBlock(blockToBeChained1));
		blockToBeChained2.mine(blockchain.getHashOfLatestBlock());
		System.out.println(blockchain.chainBlock(blockToBeChained2));
		
		String hashOfLastBlock=blockchain.getHashOfLatestBlock();
		
		assertEquals(hashOfLastBlock,"0000a02b4bd91d81c6c819c78a4581474dc326bc54f14cb86c9d4c789d6c73a2");
	}
	
	@Test
	public void validateBlockchain_ValidChain_True() {
		Blockchain b = util.generateValidBlockchain(5);
		
		boolean resultOfValidation=b.validateBlockchain();
		
		assertTrue(resultOfValidation);
	}
	
	

}
