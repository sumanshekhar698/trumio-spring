package org.trumio.java.language.multithreading;
public class DeadlockFixed {
    public static void main(String[] args) {
        final String resource1 = "Bowl";
        final String resource2 = "Spoon";

        // Thread 1: Always locks Bowl then Spoon
        Thread t1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: Locked " + resource1);
                try { Thread.sleep(100); } catch (Exception e) {}

                System.out.println("Thread 1: Waiting for " + resource2 + "...");
                synchronized (resource2) {
                    System.out.println("Thread 1: Locked both!");
                }
            }
        });

        // Thread 2: FIXED! Now also locks Bowl then Spoon
        Thread t2 = new Thread(() -> {
            synchronized (resource1) { // Order changed from resource2 to resource1
                System.out.println("Thread 2: Locked " + resource1);
                try { Thread.sleep(100); } catch (Exception e) {}

                System.out.println("Thread 2: Waiting for " + resource2 + "...");
                synchronized (resource2) {
                    System.out.println("Thread 2: Locked both!");
                }
            }
        });

        t1.start();
        t2.start();
    }
}