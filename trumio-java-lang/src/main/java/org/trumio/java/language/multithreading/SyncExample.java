package org.trumio.java.language.multithreading;
class Counter {
    private int count = 0;

    // The synchronized keyword locks the "this" object
    public synchronized void increment() {
        count++; 
    }

    public int getCount() {
        return count;
    }
}

public class SyncExample {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        // Create a task that increments the counter 10,000 times
        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        // If synchronized is removed, this will likely be less than 20000
        System.out.println("Final Count: " + counter.getCount());
    }
}