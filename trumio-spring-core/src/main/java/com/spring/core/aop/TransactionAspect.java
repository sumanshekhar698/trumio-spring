package com.spring.core.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionAspect {

    // 1. THE NAMED POINTCUT
    // We define this once so we can use it for both Success and Failure
    @Pointcut("execution(* com.spring.core.aop.AtmService.withdraw(..))")
    public void atmOperations() {}


    // 2.1 BEFORE ADVICE: Security Check
    @Before("atmOperations()")
    public void verifyAccountStatus(JoinPoint joinPoint) {
        // Accessing the arguments passed to the method (accountId and amount)
        Object[] args = joinPoint.getArgs();
        int accId = (int) args[0];

        System.out.println("[1. PRECHECK] Checking status for Account #" + accId + "...");
        System.out.println("[1. PRECHECK] Access GRANTED.");
    }

    // 2.2 SUCCESS HANDLER
    @AfterReturning(pointcut = "atmOperations()", returning = "result")
    public void logSuccess(Object result) {
        System.out.println("[2. AUDIT] Transaction completed. Dispensed: $" + result);
    }

    // 3.1 FAILURE HANDLER (The New Part)
    // 'throwing' must match the parameter name 'ex'
    @AfterThrowing(pointcut = "atmOperations()", throwing = "ex")
    public void logError(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        
        System.err.println("[2. ALERT] Exception in method: " + methodName);
        System.err.println("[2. ALERT] Reason for failure: " + ex.getMessage());
        
        // Here you could send an SMS alert or trigger a rollback
    }

    // 3.2 AFTER (FINALLY) ADVICE
    @After("atmOperations()")
    public void releaseResources(JoinPoint joinPoint) {
        System.out.println("[3. AFTER (FINALLY)] Closing connection to the DB.");
        System.out.println("--------------------------------------------------");
    }
}