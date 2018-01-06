package util;

public class MinerThread implements Runnable {

	@Override
	public void run() {
		int i=0;
		do
		{
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
			Manager.createBlock();
			i+=5;
		} while (true);
		
		
	}

}
