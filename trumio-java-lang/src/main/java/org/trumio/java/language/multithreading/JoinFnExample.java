package org.trumio.java.language.multithreading;

public class JoinFnExample {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("START");
		System.out.println(Thread.currentThread());

		Thread t1 = new Thread(() -> {
			for (int i = 1; i <= 9; i++) {
				try {
					Thread.sleep(250);// ms
					System.out.println(i + " " + Thread.currentThread());

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		System.out.println(t1.getState());
		t1.start();
		System.out.println(t1.getState());
		t1.join();

		System.out.println("END");
		System.out.println(t1.getState());

	}

}