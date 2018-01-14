package util;

public class MinerThread implements Runnable {

	@Override
	public void run() {
		do
		{
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
			Manager.generateNewBlock();

		} while (true);
		
	}

}
