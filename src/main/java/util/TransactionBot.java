package util;

import java.util.concurrent.ThreadLocalRandom;

import datastructures.Transaction;

public class TransactionBot implements Runnable {

	private final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	private Broadcaster broadcaster = new Broadcaster();
	private Transaction t;
	private String giver;
	private int amount;
	private String receiver;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			
			amount = ThreadLocalRandom.current().nextInt(2, 10000 + 1);
			t = new Transaction(generateRandomName(),amount,generateRandomName());
			
			broadcaster.broadcastTransaction(t, 100);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private String generateRandomName() {
		StringBuilder name = new StringBuilder();
		int nameLength=ThreadLocalRandom.current().nextInt(4, 7 + 1);
		for (int i=0;i<nameLength;i++) {
			name.append(chars.charAt(ThreadLocalRandom.current().nextInt(0, chars.length())));
		}
		return name.toString();
	}

}
