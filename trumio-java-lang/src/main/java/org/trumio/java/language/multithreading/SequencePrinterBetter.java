package org.trumio.java.language.multithreading;

public class SequencePrinterBetter {
    // Shared state to track whose turn it is
    private int status = 1; 
    
    // A private lock object - better practice than 'this' 🛡️
    private final Object lock = new Object();

    public static void main(String[] args) {
        SequencePrinter sp = new SequencePrinter();

        // Creating three threads
        Thread t1 = new Thread(() -> sp.printNumber(1), "Thread-1");
        Thread t2 = new Thread(() -> sp.printNumber(2), "Thread-2");
        Thread t3 = new Thread(() -> sp.printNumber(3), "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }

    public void printNumber(int threadNum) {
        // Synchronizing on our private lock object instead of 'this'
        synchronized (lock) {
            try {
                // The "Guarded Wait": Wait while it's not our turn 🛑
                while (status != threadNum) {
                    lock.wait();
                }

                System.out.println(Thread.currentThread().getName() + " prints: " + threadNum);

                // Update status and wake up everyone to check the turn again 📣
                status++;
                lock.notifyAll();
                
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}