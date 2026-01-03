package org.trumio.java.language.multithreading;
public class DeadlockExample {
    public static void main(String[] args) {
        final String resource1 = "Bowl";
        final String resource2 = "Spoon";

        // Thread 1: Tries to lock Bowl then Spoon
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

        // Thread 2: Tries to lock Spoon then Bowl
        Thread t2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: Locked " + resource2);
                try { Thread.sleep(100); } catch (Exception e) {}

                System.out.println("Thread 2: Waiting for " + resource1 + "...");
                synchronized (resource1) {
                    System.out.println("Thread 2: Locked both!");
                }
            }
        });

        t1.start();
        t2.start();
    }
}