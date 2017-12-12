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
	
	@Override
	public String toString() {
		return giver + "-" + amount + ">" + receiver;
	}
}
