package org.trumio.java.language.multithreading;
public class AllTheThreadState {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        // 1. NEW
        Thread worker = new Thread(() -> {
            synchronized (lock) {
                try {
                    // 5. TIMED_WAITING (triggered by sleep)
                    Thread.sleep(500);
                    // 4. WAITING (triggered by wait)
                    lock.wait(); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println("State after creation: " + worker.getState()); // NEW

        // 2. RUNNABLE
        worker.start();
        System.out.println("State after start(): " + worker.getState());

        // 3. BLOCKED
        synchronized (lock) {
            // Main thread holds the lock, so worker will be BLOCKED 
            // when it tries to enter the synchronized block.
            Thread.sleep(100); 
            System.out.println("State while main holds lock: " + worker.getState());
        }

        // 5. TIMED_WAITING
        Thread.sleep(200); // Give worker time to enter sleep()
        System.out.println("State while sleeping: " + worker.getState());

        // 4. WAITING
        Thread.sleep(500); // Give worker time to hit wait()
        System.out.println("State while waiting: " + worker.getState());

        // Cleanup to reach TERMINATED
        synchronized (lock) {
            lock.notify();
        }
        worker.join();
        
        // 6. TERMINATED
        System.out.println("State after completion: " + worker.getState());
    }
}