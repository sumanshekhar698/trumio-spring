package org.trumio.java.language.multithreading;

public class SequenceTo100 {
	private int counter = 1;
	private final int MAX = 100;
	private final int NUMBER_OF_THREADS = 3;

	public static void main(String[] args) {
		SequenceTo100 sequenceTo100Printer = new SequenceTo100();

		// Create 3 threads with IDs 1, 2, and 0 (remainder of counter % 3)
		Thread t1 = new Thread(new Task(sequenceTo100Printer, 1), "Thread-1");//
		Thread t2 = new Thread(new Task(sequenceTo100Printer, 2), "Thread-2");
		Thread t3 = new Thread(new Task(sequenceTo100Printer, 0), "Thread-3");

		t1.start();
		t2.start();
		t3.start();
	}

	static class Task implements Runnable {
		private final SequenceTo100 sequenceTo100Printer;
		private final int threadId;

		Task(SequenceTo100 sequenceTo100Printer, int threadId) {
			this.sequenceTo100Printer = sequenceTo100Printer;
			this.threadId = threadId;
		}

		@Override
		public void run() {
			while (sequenceTo100Printer.counter <= sequenceTo100Printer.MAX) {
				synchronized (sequenceTo100Printer) {
					// Check if it's this thread's turn using modulo
					// Thread 1 prints when counter % 3 == 1
					// Thread 2 prints when counter % 3 == 2
					// Thread 3 prints when counter % 3 == 0
					while (sequenceTo100Printer.counter <= sequenceTo100Printer.MAX
							&& sequenceTo100Printer.counter % sequenceTo100Printer.NUMBER_OF_THREADS != threadId) {
						try {
							sequenceTo100Printer.wait();
						} catch (InterruptedException e) {
							Thread.currentThread().interrupt();
						}
					}

					// Double-check counter before printing
					if (sequenceTo100Printer.counter <= sequenceTo100Printer.MAX) {
						System.out.println(Thread.currentThread().getName() + ": " + sequenceTo100Printer.counter);
						sequenceTo100Printer.counter++;
					}

					// Notify all threads to check the condition again
					sequenceTo100Printer.notifyAll();
				}
			}
		}
	}
}