package test;

import datastructures.Block;
import datastructures.Blockchain;
import datastructures.Transaction;

public class BlockchainTestUtil {

	
	public Block getValidNotMinedBlock() {
		Transaction t1,t2,t3;
		t1 = new Transaction("Teo", 20, "Adam");
		t2 = new Transaction("Richard", 10, "Rob");
		t3 = new Transaction("Adam", 12, "Lol");
		Block blockToBeChained = new Block();
		try {
			blockToBeChained.addTransaction(t1);
			blockToBeChained.addTransaction(t2);
			blockToBeChained.addTransaction(t3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return blockToBeChained;
	}
	
	public Block getValidMinedBlock(String previousHash) {
		Transaction t1,t2,t3;
		t1 = new Transaction("Teo", 20, "Adam");
		t2 = new Transaction("Richard", 10, "Rob");
		t3 = new Transaction("Adam", 12, "Lol");
		Block blockToBeChained = new Block();
		try {
			blockToBeChained.addTransaction(t1);
			blockToBeChained.addTransaction(t2);
			blockToBeChained.addTransaction(t3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		blockToBeChained.mine(previousHash);
		return blockToBeChained;
	}
	
	public Blockchain generateValidBlockchain(int numberOfBlocks) {
		Blockchain b = new Blockchain();
		for (int i=0;i<numberOfBlocks;i++) {
			b.chainBlock(getValidMinedBlock(b.getHashOfLatestBlock()));
		}
		return b;
	}
}
