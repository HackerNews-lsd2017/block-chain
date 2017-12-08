package datastructures;

public class Tester {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Transaction t = new Transaction("Adam", 30, "YourMom");
		Transaction t2 = new Transaction("Adam", 30, "He'sMom");
		Block b = new Block();
		b.addTransaction(t);
		b.addTransaction(t2);
		
		

	}

}
