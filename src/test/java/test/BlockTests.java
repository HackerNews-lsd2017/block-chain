package test;

import datastructures.Block;
import datastructures.Transaction;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BlockTests {

	private String validPrefix="0000";
	
	@Test
	public void block_Mine_0000() {
		String previousValidHash="0000275452071335546e7c5d1684c56ebc6fe0f2a993f7eaeb97dbcc26c75269";
		Transaction t1,t2,t3;
		t1 = new Transaction("Teo", 20, "Adam");
		t2 = new Transaction("Richard", 10, "Rob");
		t3 = new Transaction("Adam", 12, "Lol");
		Block b = new Block();
		try {
			b.addTransaction(t1);
			b.addTransaction(t2);
			b.addTransaction(t3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		b.mine(previousValidHash);
		String hashToValidate=b.getBlockHash();
		
		assertTrue(hashToValidate.startsWith(validPrefix));
	}

}
