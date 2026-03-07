package com.spring.core.lifecycle.lifespan;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
    @Before("execution(* com.spring.core.lifecycle.lifespan.PaymentService.processPayment(..))")
    public void beforeAdvice() {
        System.out.println("[AOP BEFORE] Security check: Is user authorized?");
    }

    @After("execution(* com.spring.core.lifecycle.lifespan.PaymentService.processPayment(..))")
    public void afterAdvice() {
        System.out.println("[AOP AFTER] Audit log: Payment attempt finished.");
    }
}