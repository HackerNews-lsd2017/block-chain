package util;

import java.util.Stack;

import datastructures.Block;
import datastructures.Blockchain;
import datastructures.Transaction;

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
	
	public static void generateNewBlockchain() {
		
		if (transactionStack.isEmpty()) return;
		
		Block b = new Block();
		
		synchronized (transactionStack) {
			b.setStack(transactionStack);
			transactionStack = new Stack<Transaction>();
		}
		
		b.mine(bc.getLatestBlockHash());
		
		bc.chainBlock(b);
		// Do something more here to tell other peers that this is new blockchain
		
		System.out.println(bc.toString());
	}
	
//	public static boolean getNewBlockchain() {
//		
//	}
	
	
	
}
