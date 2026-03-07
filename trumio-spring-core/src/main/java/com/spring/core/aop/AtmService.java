package com.spring.core.aop;

import org.springframework.stereotype.Service;

@Service
public class AtmService {
    public Double withdraw(int accountId, double amount) throws Exception {
        if (amount > 1000) {
            throw new Exception("DAILY_LIMIT_EXCEEDED");
        }
        System.out.println(">> Processing $" + amount);
        return amount;
    }
}