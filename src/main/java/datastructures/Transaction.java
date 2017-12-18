package datastructures;

public class Transaction {
	private String giver;
	private Integer amount;
	private String receiver;
	
	/**
	 * @param giver
	 * @param receiver
	 * @param amount
	 */
	//When you make a class that you want to broadcast always have an empty constructor!!!!!!1111
	public Transaction() {
		
	}
	
	public Transaction(String giver, Integer amount, String receiver ) {
		this.giver = giver;
		this.receiver = receiver;
		this.amount = amount;
	}

	public String getGiver() {
		return giver;
	}

	public String getReceiver() {
		return receiver;
	}

	public Integer getAmount() {
		return amount;
	}
	
	public void setGiver(String giver) {
		this.giver = giver;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	@Override
	public String toString() {
		return giver + "-" + amount + ">" + receiver;
	}
}
