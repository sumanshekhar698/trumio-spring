package com.spring.core.events;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ReceiptListener {

//    @Async ("taskExecutor")// Runs this in a background thread
    @Async//AutoWired TaskExecutor
    @EventListener
    public void handleWithdrawal(WithdrawalEvent event) {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] EVENT RECEIVED: Generating receipt for $" + event.getAmount());

        try {
            Thread.sleep(2000); // Simulate slow processing
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("[" + threadName + "] EVENT PROCESSED: Receipt sent to Account #" + event.getAccountId());
    }
}