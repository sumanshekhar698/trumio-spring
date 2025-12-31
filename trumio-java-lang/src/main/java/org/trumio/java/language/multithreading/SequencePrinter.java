package org.trumio.java.language.multithreading;
public class SequencePrinter {
    private int status = 1; // 1 for Thread 1, 2 for Thread 2, etc.

    public static void main(String[] args) {
        SequencePrinter sp = new SequencePrinter();

        Thread t1 = new Thread(() -> sp.printNumber(1));//Thread 1  -- 1
        Thread t2 = new Thread(() -> sp.printNumber(2));
        Thread t3 = new Thread(() -> sp.printNumber(3));

        t1.start();
        t2.start();
        t3.start();
    }

    public void printNumber(int threadNum) {
        synchronized (this) {// Only 1 thread can be ACTIVE
            try {
                // Wait while it's not this thread's turn
                while (status != threadNum) {
                    this.wait();
                }

                // Print the number
                System.out.println("Thread " + threadNum + " prints: " + threadNum);

                // Update status and notify others
                status++;
                this.notifyAll();//VVI
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}