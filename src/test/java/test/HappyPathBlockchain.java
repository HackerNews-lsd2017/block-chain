package test;

import datastructures.Block;
import datastructures.Blockchain;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HappyPathBlockchain {

	private BlockchainTestUtil util = new BlockchainTestUtil();
	
	@Test
	public void chainBlock_NoInitialBlock_True() {
		Block blockToBeChained = util.getValidNotMinedBlock();
		Blockchain blockchain = new Blockchain();
		//
		blockToBeChained.mine(blockchain.getLatestBlockHash());
		//Chain block
		boolean chainingResult=blockchain.chainBlock(blockToBeChained);
		System.out.println(chainingResult);
		
		assertTrue(chainingResult);
	}
	
	@Test
	public void getHashOfLatestBlock_NoBlocks_00000hash() {
		Blockchain blockchain = new Blockchain();
		
		assertEquals(blockchain.getLatestBlockHash(),"000000000000000000000000000000000000000000000000000000000000000");
	}
	
	@Test
	public void getHashOfLatestBlock_OneBlock_True() {
		Block blockToBeChained = util.getValidNotMinedBlock();
		Blockchain blockchain = new Blockchain();
		blockToBeChained.mine(blockchain.getLatestBlockHash());
		System.out.println(blockchain.chainBlock(blockToBeChained));
		
		String hashOfLastBlock=blockchain.getLatestBlockHash();
		
		assertEquals(hashOfLastBlock,"00007656832d9d79c028b535879c786ef2d604486046ea9e37fc7fe01b08aa05");
	}
	
	@Test
	public void getHashOfLatestBlock_TwoBlocks_True() {
		Block blockToBeChained1 = util.getValidNotMinedBlock();
		Block blockToBeChained2 = util.getValidNotMinedBlock();
		Blockchain blockchain = new Blockchain();
		blockToBeChained1.mine(blockchain.getLatestBlockHash());
		System.out.println(blockchain.chainBlock(blockToBeChained1));
		blockToBeChained2.mine(blockchain.getLatestBlockHash());
		System.out.println(blockchain.chainBlock(blockToBeChained2));
		
		String hashOfLastBlock=blockchain.getLatestBlockHash();
		
		assertEquals(hashOfLastBlock,"0000b39dc19f9098e23501914d941c123e6cae9b2122453ed5acb0c968b5cc9f");
	}
	
	@Test
	public void validateBlockchain_ValidChain_True() {
		Blockchain b = util.generateValidBlockchain(5);
		
		boolean resultOfValidation=b.validateBlockchain();
		
		assertTrue(resultOfValidation);
	}
	
	

}
