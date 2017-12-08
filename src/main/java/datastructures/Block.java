package datastructures;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

public class Block {

	private int nonce = 0;
	// String is temporary. We will have transaction class with whatever transaction
	// has to have.
	private List<Transaction> transactions = new ArrayList<>();
	private String thisHash=null;
	private String previousHash=null;

	public Block() {
		// if (id==null || transaction==null) throw new Exception();
		// addTransaction(transaction);
	}

	public int mine(String previousHash) {
		nonce = 0;
		String sha256hex = createHash();
		this.previousHash = previousHash;
		while (!sha256hex.startsWith("0000")) {
			nonce++;
			sha256hex = createHash();
		}
		this.thisHash = sha256hex;

		System.out.println(sha256hex);
		return nonce;
	}

	public String createHash() {
		return DigestUtils.sha256Hex(nonce + transactionsToString(transactions) + previousHash);
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public String getThisHash() {
		return thisHash;
	}

	public void setThisHash(String thisHash) {
		this.thisHash = thisHash;
	}

	public String getPreviousHash() {
		return previousHash;
	}

	public void setNonce(int nonce) {
		this.nonce = nonce;
	}

	public void addTransaction(Transaction transaction) throws Exception {
		if (transaction == null)
			throw new Exception();
		this.transactions.add(transaction);
	}

	public int getNonce() {
		return nonce;
	}

	public String transactionsToString(List<Transaction> transactions) {
		String s = "";
		for (Transaction transaction : transactions) {
			s += (transaction + ",");
		}
		return s;
	}

}
