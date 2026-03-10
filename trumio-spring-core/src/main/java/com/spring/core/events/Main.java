package com.spring.core.events;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = 
                new AnnotationConfigApplicationContext(JavaConfig.class);

        AtmService service = context.getBean(AtmService.class);

        System.out.println("[MAIN] Calling withdraw...");
        service.withdraw(999, 150.0);
        
        System.out.println("[MAIN] Withdraw call returned. App staying alive for event...");
        
        Thread.sleep(5000); // Wait to see the background event finish
        context.close();
    }
}