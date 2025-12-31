package org.trumio.java.language.multithreading;

public class SecondThread {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Work());
		t1.start();
//		t1.start();
		
		Thread t2 = new Thread(()->{
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(500);// 500 ms
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(i + " --> " + Thread.currentThread());
				// Thread[#3,main,5,main] ::
				// Thread[#3, current thread name, priority, parent thread name]
			}
		});
		t2.start();

	}

}

class Work implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500);// 500 ms
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i + " --> " + Thread.currentThread());
			// Thread[#3,main,5,main] ::
			// Thread[#3, current thread name, priority, parent thread name]
		}

		return;

	}

}
