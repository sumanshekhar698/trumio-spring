package com.spring.core.validation_and_binding;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;

public class WithdrawalRequest {

    @Min(value = 1, message = "Account ID must be at least 1")
    private final int accountId;

    @Positive(message = "Withdrawal amount must be greater than zero")
    @Max(value = 10000, message = "Cannot withdraw more than $10,000")
    private final double amount;

    public WithdrawalRequest(int accountId, double amount) {
        System.out.println("WithdrawalRequest constructor called");
        this.accountId = accountId;
        this.amount = amount;
    }

    // The Validator requires getters and Setters
    public int getAccountId() { return accountId; }
    public double getAmount() { return amount; }
}