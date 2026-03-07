package com.spring.core.lifecycle_complete;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentService() {
        System.out.println("[PHASE 1: INSTANTIATION] PaymentService object created.");
    }

    public void processPayment(double amount) {
        System.out.println("[PHASE 4: EXECUTION] Logic: Processing payment of $" + amount);
    }


    @PostConstruct
    public void init() {
        System.out.println("[PHASE 3: INIT] @PostConstruct: Connecting to Payment Gateway...");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("[PHASE 5: DESTROY] @PreDestroy: Closing Payment Gateway connection.");
    }
}