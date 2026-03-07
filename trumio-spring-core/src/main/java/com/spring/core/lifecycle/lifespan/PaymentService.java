package com.spring.core.lifecycle.lifespan;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    public PaymentService() {
        System.out.println("[PHASE 1: INSTANTIATION] PaymentService object created.");
    }

    @PostConstruct
    public void init() {
        System.out.println("[PHASE 3: INIT] @PostConstruct: Connecting to Payment Gateway...");
    }

    public void processPayment(double amount) {
        System.out.println("[PHASE 4: EXECUTION] Logic: Processing payment of $" + amount);
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("[PHASE 5: DESTROY] @PreDestroy: Closing Payment Gateway connection.");
    }
}