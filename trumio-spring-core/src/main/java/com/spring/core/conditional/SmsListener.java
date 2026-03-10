package com.spring.core.conditional;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

public class SmsListener {
    @Async
    @EventListener
    public void onWithdrawal(WithdrawalEvent event) {
        System.out.println("[" + Thread.currentThread().getName() +
                "] SMS SENT: Account " + event.getAccountId() + " withdrew $" + event.getAmount());
    }
}

// Simple Event POJO
class WithdrawalEvent {
    private final int accountId;
    private final double amount;
    public WithdrawalEvent(int id, double amt) { this.accountId = id; this.amount = amt; }
    public int getAccountId() { return accountId; }
    public double getAmount() { return amount; }
}