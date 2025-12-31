package org.trumio.java.language.multithreading;
import java.util.concurrent.*;
import java.math.BigInteger;

public class CallableExample {
    public static void main(String[] args) throws Exception {
        // Create a pool to handle the work
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // 1. Defining a task with actual mathematical work 🧮
        Callable<Double> heavyTask = () -> {
            double sum = 0;
            System.out.println("Computation started in background...");
            
            // Performing 10 million square root calculations
            for (int i = 0; i < 10_000_000; i++) {
                sum += Math.sqrt(i);
            }
            Thread.sleep(1000);
            return sum;
        };

        // 2. Submit the task
        Future<Double> future = executor.submit(heavyTask);

        // While the thread works, the main thread is free to do other things
        System.out.println("Main thread: I'm not blocked! I can print this immediately.");

        // 3. Get the result
        // Note: This will wait (block) until the 10 million loops are done
        Double total = future.get(); 

        System.out.println("Computation Complete! Total sum: " + total);

        executor.shutdown();
        System.out.println("END");
    }
}