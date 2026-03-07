package com.spring.core.lifecycle_complete;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(LifespanConfig.class);

        System.out.println("--- Container is Ready ---");
        
        PaymentService service = context.getBean(PaymentService.class);
        service.processPayment(100.0);

        System.out.println();
        service.processPayment(200.0);


        context.close();
    }
}