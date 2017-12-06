package datastructures;

import org.apache.commons.codec.digest.DigestUtils;

public class Block {

	private Integer id;
	private int nonce;
	// String is temporary. We will have transaction class with whatever transaction has to have.
	private String transaction;
	
	public Block(Integer id, String transaction) throws Exception {
		//if (id==null || transaction==null) throw new Exception();
		setId(id);
		setTransaction(transaction);
	}
	
	public int mine() {
		String sha256hex = DigestUtils.sha256Hex(id+nonce+transaction);
		while (!sha256hex.startsWith("0000")) {
			nonce++;
			sha256hex = DigestUtils.sha256Hex(id+nonce+transaction);
		}
		System.out.println(sha256hex);
		return nonce;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) throws Exception {
		if (id==null) throw new Exception();
		this.id = id;
	}
	public String getTransaction() {
		return transaction;
	}
	public void setTransaction(String transaction) throws Exception {
		if (transaction==null) throw new Exception();
		this.transaction = transaction;
	}
	public int getNonce() {
		return nonce;
	}
	
	
	
}
