package sample;

import java.util.Random;

public class MyTask implements Runnable {

	private String message;
	private Random random = new Random();

	public MyTask(String message) {
		this.message = message;
	}

	public void run() {
		for (int i = 0; i < 2; i++) {
			try {
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ": "
					+ message);
		}
	}
}
