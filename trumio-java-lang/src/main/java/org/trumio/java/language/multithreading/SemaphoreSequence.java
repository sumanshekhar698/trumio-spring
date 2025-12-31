package org.trumio.java.language.multithreading;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SemaphoreSequence {
    private static final int MAX = 100;
    private static int counter = 1;

    public static void main(String[] args) {
        // Semaphores for each thread. Start T1 as 'available' (1 permit)
        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(0);
        Semaphore s3 = new Semaphore(0);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(() -> printSequence(s1, s2, 1)); // Thread 1
        executor.submit(() -> printSequence(s2, s3, 2)); // Thread 2
        executor.submit(() -> printSequence(s3, s1, 0)); // Thread 3 (0 for modulo)

        executor.shutdown();
    }

    private static void printSequence(Semaphore current, Semaphore next, int threadId) {
        while (counter <= MAX) {
            try {
                current.acquire(); // Wait for permit
                
                if (counter <= MAX) {
                    System.out.println(Thread.currentThread().getName() + " prints: " + counter);
                    counter++;
                }
                
                next.release(); // Pass the turn to the next thread
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}