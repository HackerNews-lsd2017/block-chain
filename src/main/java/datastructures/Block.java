package datastructures;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.List;

public class Block {
	private int nonce = 0;
	private List<Transaction> transactions = new ArrayList<>();
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

	public List<Transaction> getTransactions() {
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

    @Override
    public String toString() {
        return "Block{" +
                "nonce=" + nonce +
                ", transactions=" + transactions +
                ", previousHash='" + previousHash + '\'' +
                ", blockHash='" + blockHash + '\'' +
                '}';
    }
}
