package datastructures;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Stack;

public class Block {
	private int nonce = 0;
	private Stack<Transaction> transactions = new Stack<>();
	private String previousHash = null;
	private String blockHash = null;

	public Block() {
	}

    // Find proof of work
	public void mine(String previousHash) {
		nonce = 0;
		String sha256hex = createHash_sha256();
		this.previousHash = previousHash;

        // Check if hash starts with 4 zeros, if it doesn't try the next nonce
		while (!sha256hex.startsWith("0000")) {
			
			nonce++;
			sha256hex = createHash_sha256();
		}
        this.blockHash = sha256hex;
        System.out.println("Block mined. Nonce (the proof of work): " + nonce);
	}

	public void mine2(String previousHash) {
		nonce = 0;
		String md5Hex = createHash_md5();
		this.previousHash = previousHash;

		// Check if hash starts with 3 zeros, if it doesn't try the next nonce
		while (!md5Hex.startsWith("000")) {

			nonce++;
			md5Hex = createHash_md5();
		}
		this.blockHash = md5Hex;
		System.out.println("Block mined. Nonce (the proof of work): " + nonce);
	}

	public String createHash_sha256() {
		return DigestUtils.sha256Hex(nonce + transactionsToString(transactions) + previousHash);
	}

	public String createHash_md5() {
		return DigestUtils.md5Hex(nonce + transactionsToString(transactions) + previousHash);
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
		Block blockUnderComparison = (Block) obj;
		if (this.previousHash.equals(blockUnderComparison)) return true;
		return false;
	}

	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
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
