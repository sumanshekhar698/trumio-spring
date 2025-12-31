package org.trumio.java.language.multithreading;

public class VisibilityProblem {
	// Without volatile, the listener thread might run forever
	private static volatile boolean keepRunning = true;

	public static void main(String[] args) throws InterruptedException {
		// Thread 1
		new Thread(() -> {
			while (keepRunning) {
				System.out.println("Stop me if you can!!!");
			}

		}).start();

//		Thread.sleep(1000);

		// Thread 2
		new Thread(() -> {
			keepRunning = false;
			System.out.println("Thread 2 updating keepRunning to false...");
		}).start();

	}
}