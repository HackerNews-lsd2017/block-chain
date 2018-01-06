package util;

import datastructures.Block;
import datastructures.Blockchain;
import datastructures.Transaction;

import java.util.Stack;

public class Manager {

	private static Manager instance = new Manager();
	private static Blockchain bc = new Blockchain();
	private static Stack<Transaction> transactionStack = new Stack<Transaction>();
	
	private Manager() {
		
	}
	
	public static boolean chain(Block b) {
		return bc.chainBlock(b);
	}
	
	public static synchronized void addTransaction(Transaction t) {
		transactionStack.push(t);
	}
	
	public static void createBlock() {
		
		if (transactionStack.isEmpty()) return;
		
		Block b = new Block();
		
		synchronized (transactionStack) {
			b.setStack(transactionStack);
			transactionStack = new Stack<Transaction>();
		}
		
		b.mine(bc.getLatestBlock().getBlockHash());
		bc.chainBlock(b);
		// Do something more here to tell other peers that this is new blockchain
		System.out.println(bc.toString());
	}

	public void createNewBlock(Transaction trans) throws Exception {
		Block block = new Block();

		block.addTransaction(trans);

		block.mine(bc.getLatestBlock().getBlockHash());
		chain(block);
	}
	
//	public static boolean getNewBlockchain() {
//		
//	}
	
	
	
}
