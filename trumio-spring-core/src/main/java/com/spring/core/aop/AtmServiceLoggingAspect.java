package com.spring.core.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AtmServiceLoggingAspect {

    // 1. THE NAMED POINTCUT
    // We define this once so we can use it for both Success and Failure
    @Pointcut("execution(* com.spring.core.aop.AtmService.withdraw(..))")
    public void atmOperations() {
    }


    // 2.1 BEFORE ADVICE: Security Check
    @Before("atmOperations()")
    public void verifyAccountStatus(JoinPoint joinPoint) {
        // Accessing the arguments passed to the method (accountId and amount)
        Object[] args = joinPoint.getArgs();
        int accId = (int) args[0];

        System.out.println("[1. PRECHECK] Checking status for Account #" + accId + "...");
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
        System.out.println();
    }

    // 4 The @Around advice is the "God Mode" of AOP. It is the only advice that can control the entire lifecycle of a method execution.
    @Around("atmOperations()")
    public Object applyGoldMemberLogic(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("[AROUND] triggered");

        // 1. Extract arguments from the call
        Object[] args = pjp.getArgs();
        int accountId = (int) args[0];
        double amount = (Double) args[1];

        // 2. Logic to determine the overpowering rule
        boolean usingGoldMemberPower = (accountId < 100) && (amount > 1000);

        if (usingGoldMemberPower) {
            System.out.println("[AROUND] Gold Member detected! Bypassing standard limits...");

            // POWER MOVE:
            // If we know the Service class will throw an exception for > 1000,
            // and we want to ALLOW it for Gold Members without changing the Service,
            // we can actually perform the logic HERE and NOT call pjp.proceed().

            if (amount <= 5000) {
                System.out.println("[AROUND bypassing the fn withdraw limit] Gold Member withdrawal of $" + amount + " authorized by Aspect.");
                return amount; // We return the value directly, SKIPPING the Service's throw logic!
            }
        }

        // 3. For Regular users (or Gold > 5000), let the Service run as usual.
        // This will trigger the "DAILY_LIMIT_EXCEEDED" exception inside the Service for > 1000.
        System.out.println("[AROUND] proceeds");
        return pjp.proceed();
    }


    //    @Around("atmOperations()")
    public Object measurePerformance(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();

        // 1. Accessing arguments (accountId and amount)
        Object[] args = pjp.getArgs();
        double requestedAmount = (Double) args[1];

        System.out.println("[AROUND] Intercepted request for $" + requestedAmount);

        Object result;
        try {
            // 2. Triggering the real withdraw() method
            result = pjp.proceed();
        } catch (Exception ex) {
            // 3. This catches the "DAILY_LIMIT_EXCEEDED" from AtmService
            System.out.println("[AROUND] Logging failure: " + ex.getMessage());
            throw ex; // Re-throwing so @AfterThrowing can also see it
        }

        long executionTime = System.currentTimeMillis() - start;
        System.out.println("[AROUND] Transaction took " + executionTime + "ms");

        return result;
    }


    /*
1. JoinPoint (The Observer)
- JoinPoint is the parent interface. It is used in "simple" advices like @Before, @After, and @AfterThrowing. It gives you a read-only snapshot of what is happening.
- Capabilities: You can see the method name, the arguments being passed, and the target object.
- Limitation: You are just a passenger. You cannot stop the method from running, and you cannot change the return value.

2. ProceedingJoinPoint (The Controller)
- ProceedingJoinPoint is a sub-interface that only works with @Around advice. It is the most powerful object in Spring AOP because it holds the "Play" button for the target method.
- Capabilities: It has the proceed() method.
- Power: If you don't call proceed(), the actual business method never runs. If you call proceed(args), you can actually change the inputs before the method sees them.*/
}