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

		blockToBeChained.mine(blockchain.getLatestBlock().getBlockHash());
		//Chain block
		boolean chainingResult = blockchain.chainBlock(blockToBeChained);
		System.out.println(chainingResult);
		
		assertTrue(chainingResult);
	}
	
	@Test
	public void getHashOfLatestBlock_NoBlocks_00000hash() {
		Blockchain blockchain = new Blockchain();
		String GENESIS_HASH = new String(new char[63]).replace('\0', '0');

		assertEquals(blockchain.getLatestBlock().getPreviousHash(), GENESIS_HASH);
	}
	
	@Test
	public void getHashOfLatestBlock_OneBlock_True() {
		Block blockToBeChained = util.getValidNotMinedBlock();
		Blockchain blockchain = new Blockchain();

		blockToBeChained.mine(blockchain.getLatestBlock().getBlockHash());
		System.out.println(blockchain.chainBlock(blockToBeChained));
		
		String hashOfLastBlock = blockchain.getLatestBlock().getBlockHash();
		
		assertEquals(hashOfLastBlock,"00009fd2f24a14b64f244b672aa2b9130d33cbc6185f9ec5f34714a545d2ecdf");
	}
	
	@Test
	public void getHashOfLatestBlock_TwoBlocks_True() {
		Block blockToBeChained1 = util.getValidNotMinedBlock();
		Block blockToBeChained2 = util.getValidNotMinedBlock();
		Blockchain blockchain = new Blockchain();

		blockToBeChained1.mine(blockchain.getLatestBlock().getBlockHash());
		System.out.println(blockchain.chainBlock(blockToBeChained1));

		blockToBeChained2.mine(blockchain.getLatestBlock().getBlockHash());
		System.out.println(blockchain.chainBlock(blockToBeChained2));
		
		String hashOfLastBlock = blockchain.getLatestBlock().getBlockHash();
		
		assertEquals(hashOfLastBlock,"0000e0926f25014a12b0a7cb994868622073f21c80abd523d2689009b27b8374");
	}
	
//	@Test
//	public void validateBlockchain_ValidChain_True() {
//		Blockchain b = util.generateValidBlockchain(5);
//
//		boolean resultOfValidation = b.validateBlockchain();
//
//		assertTrue(resultOfValidation);
//	}
}
