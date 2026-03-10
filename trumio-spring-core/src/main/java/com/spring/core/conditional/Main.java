package com.spring.core.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        var context = new AnnotationConfigApplicationContext(JavaConfig.class);
        
        // Check if the conditional bean was actually created
        boolean hasSms = context.containsBean("smsListener");
        System.out.println("[MAIN] Is SMS Listener active? " + hasSms);

        // Publish the event
        context.publishEvent(new WithdrawalEvent(101, 500.0));
        
        System.out.println("[MAIN] Event published! Service is free to do other things.");
        
        Thread.sleep(2000); // Wait for Async thread to print
        context.close();
    }
}