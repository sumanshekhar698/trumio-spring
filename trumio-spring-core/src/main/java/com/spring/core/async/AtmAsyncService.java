package com.spring.core.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class AtmAsyncService {

    // 1. ASYNC: Runs in a separate thread
    @Async("taskExecutor")
    public void sendEmailReceipt(int accountId) {
        String threadName = Thread.currentThread().getName();
        System.out.println("[" + threadName + "] Starting email for Account #" + accountId);

        try {
            Thread.sleep(3000); // Simulate slow network
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("[" + threadName + "] Email SENT successfully.");
    }

    // 2. SCHEDULED: Runs every 2 seconds automatically
    @Scheduled(fixedRate = 2000)
    public void performSystemCheck() {
        System.out.println("[SCHEDULER] " + LocalTime.now() + " - System Integrity Check: OK");
    }
}