package datastructures;

public class Transaction {
	private String giver;
	private Integer amount;
	
	/**
	 * @param giver
	 * @param amount
	 */
	//When you make a class that you want to broadcast always have an empty constructor!!!!!!1111
	public Transaction() {
		
	}
	
	public Transaction(String giver, Integer amount ) {
		this.giver = giver;
		this.amount = amount;
	}

	public String getGiver() {
		return giver;
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
}
