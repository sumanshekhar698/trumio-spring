package com.spring.core.events;

public class WithdrawalEvent {//The Message
    private final int accountId;
    private final double amount;

    public WithdrawalEvent(int accountId, double amount) {
        this.accountId = accountId;
        this.amount = amount;
    }

    // Getters
    public int getAccountId() { return accountId; }
    public double getAmount() { return amount; }
}