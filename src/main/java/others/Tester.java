package others;

import datastructures.Block;
import datastructures.Blockchain;
import datastructures.Transaction;

public class Tester {

	public static void main(String[] args) throws Exception {
		Blockchain bc = new Blockchain();

		// create some test transactions
		Transaction t1 = new Transaction("Adam", 30, "YourMom");
		Transaction t2 = new Transaction("Adam", 30, "He'sMom");
        Transaction t3 = new Transaction("Lukasz", 50, "Adam");
        Transaction t4 = new Transaction("Spiderman", 70, "Lukasz");
        Transaction t5 = new Transaction("Spiderman", 70, "Batman");
        Transaction t6 = new Transaction("Batman", 70, "YourMom");

        // create blocks
        Block b1 = new Block();
        Block b2 = new Block();
        Block b3 = new Block();

        //  1. Add transactions to the block
        b1.addTransaction(t1);
        b1.addTransaction(t2);
        //  2. Mine block
        b1.mine(bc.getLatestBlockHash());
        //  3. And then chain it to the blockchain
        bc.chainBlock(b1);
        System.out.println("---");

        //  1. Add transactions to the block
        b2.addTransaction(t3);
        b2.addTransaction(t4);
        //  2. Mine block
        b2.mine(bc.getLatestBlockHash());
        //  3. And then chain it to the blockchain
        bc.chainBlock(b2);
        System.out.println("---");

        //  1. Add transaction to the block
        b3.addTransaction(t5);
        //  2. If I mine first
        b3.mine(bc.getLatestBlockHash());
        //  3. ... modify block and THEN try to chain it, it will not happened
        b3.addTransaction(t6);
        bc.chainBlock(b3);
        System.out.println("---");

        System.out.println("Latest block hash: " + bc.getLatestBlockHash());

	}

}
