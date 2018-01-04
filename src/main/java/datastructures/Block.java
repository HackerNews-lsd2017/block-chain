package datastructures;

import java.util.Stack;

import org.apache.commons.codec.digest.DigestUtils;

public class Block {
	private int nonce = 0;
	private Stack<Transaction> transactions = new Stack<>();
	private String previousHash = null;

	private String blockHash = null;

	public Block() {
		// if (id==null || transaction==null) throw new Exception();
		// addTransaction(transaction);
	}

    // Find proof of work
	public int mine(String previousHash) {
		nonce = 0;
		String sha256hex = createHash();
		this.previousHash = previousHash;

        // Check if hash starts with 4 zeros, if it doesn't try the next nonce
		while (!sha256hex.startsWith("0000")) {
			nonce++;
			sha256hex = createHash();
		}
        this.blockHash = sha256hex;
        System.out.println("Blocked mined. Nonce (the proof of work): " + nonce);

		return nonce;
	}

	public String createHash() {
		return DigestUtils.sha256Hex(nonce + transactionsToString(transactions) + previousHash);
	}

	public Stack<Transaction> getTransactions() {
		return transactions;
	}

	public String getBlockHash() {
		return blockHash;
	}

	public String getPreviousHash() {
		return previousHash;
	}

	public void addTransaction(Transaction transaction) throws Exception {
		if (transaction == null)
			throw new Exception();
		this.transactions.push(transaction);
	}

	public int getNonce() {
		return nonce;
	}

	public String transactionsToString(Stack<Transaction> transactions) {
		String s = "";
		for (Transaction transaction : transactions) {
			s += (transaction + ",");
		}
		return s;
	}
	
	public Stack<Transaction> getStack() {
		return transactions;
	}
	
	public void setStack(Stack<Transaction> stack) {
		this.transactions=stack;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Block blockUnderComparison = (Block) obj;
		if (this.previousHash.equals(blockUnderComparison)) return true;
		return false;
	}

    @Override
    public String toString() {
        return "Block{" +
                "nonce=" + nonce +
                ", transactions=" + transactionsToString(transactions) +
                ", previousHash='" + previousHash + '\'' +
                ", blockHash='" + blockHash + '\'' +
                '}';
    }
}
