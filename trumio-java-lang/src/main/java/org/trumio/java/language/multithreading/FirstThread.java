package org.trumio.java.language.multithreading;

public class FirstThread {

	public static void main(String[] args) {// main thread

		System.out.println("START -> " + Thread.currentThread());
		
		Worker w1 = new Worker();
		w1.setName("t1");
		
		Worker w2 = new Worker();
		w2.setName("t2");
		w2.setPriority(8);
		
		w1.start();
		w2.start();

		System.out.println("END -> " + Thread.currentThread());
		System.out.println(Thread.MIN_PRIORITY);
		System.out.println(Thread.MAX_PRIORITY);
	}

}

class Worker extends Thread {

	@Override
	public void run() {// Work

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
