package org.trumio.java.language.multithreading;

public class UnsequencedPrinter {
	private final Object lock = new Object();

	public static void main(String[] args) {
		UnsequencedPrinter sp = new UnsequencedPrinter();

		// Threads are created and started almost simultaneously 🚀
		Thread t1 = new Thread(() -> sp.printNumber(1), "Thread-1");
		Thread t2 = new Thread(() -> sp.printNumber(2), "Thread-2");
		Thread t3 = new Thread(() -> sp.printNumber(3), "Thread-3");

		t1.start();
		t2.start();
		t3.start();
	}

	public void printNumber(int threadNum) {
		System.out.println(Thread.currentThread().getName() + " prints: " + threadNum);
	}
}