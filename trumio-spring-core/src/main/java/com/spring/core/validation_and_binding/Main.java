package com.spring.core.validation_and_binding;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        AtmService service = context.getBean(AtmService.class);

        try {
            WithdrawalRequest badRequest = new WithdrawalRequest(0, -50.0);
            service.process(badRequest);
        } catch (jakarta.validation.ConstraintViolationException ex) {
            System.err.println("--- VALIDATION FAILED ---");

            // An exception can contain multiple errors (e.g., both ID and Amount)
            ex.getConstraintViolations().forEach(violation -> {
                System.err.println("Field: " + violation.getPropertyPath());
                System.err.println("Invalid Value: " + violation.getInvalidValue());
                System.err.println("Error Message: " + violation.getMessage());
                System.err.println("-------------------------");
            });
        } catch (Exception ex) {
            System.err.println("General Error: " + ex.getMessage());
        }

        System.out.println("\n--- Next Attempt ---");

        try {
            // This will SUCCEED
            WithdrawalRequest goodRequest = new WithdrawalRequest(101, 500.0);
            service.process(goodRequest);
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        service.process(service.getDefaultRequest());

        System.out.println("--- END ---");
    }
}