package org.trumio.java.language.multithreading;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        // 1. Create a pool with 3 fixed threads 
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // 2. Submit 5 tasks to the pool
        for (int i = 1; i <= 20; i++) {
            int taskId = i;
            executor.submit(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println("Task " + taskId + " is being executed by " + threadName);
                
                try {
                    Thread.sleep(500); // Simulate work 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // 3. Shut down the pool when finished
        executor.shutdown();
    }
}