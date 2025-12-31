package org.trumio.java.language.multithreading;
class BankAccount {
    private int balance = 1000;
    // We can also create a dedicated object to act as a lock
    private final Object lock = new Object();

    public void deposit(int amount) {
        // NON-CRITICAL: Multiple threads can print at the same time
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " is preparing to deposit $" + amount);

        // CRITICAL SECTION: Only one thread can enter this block at a time
        synchronized (lock) { 
            System.out.println(threadName + " ACQUIRED lock. Current balance: " + balance);
            int newBalance = balance + amount;
            
            // Simulating some processing time
            try { Thread.sleep(100); } catch (InterruptedException e) {}
            
            balance = newBalance;
            System.out.println(threadName + " RELEASED lock. New balance: " + balance);
        }
    }

    public int getBalance() {
        return balance;
    }
}

public class SyncBlockExample {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();

        Runnable task = () -> account.deposit(100);

        Thread t1 = new Thread(task, "Person-1");
        Thread t2 = new Thread(task, "Person-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Bank Balance: $" + account.getBalance());
    }
}