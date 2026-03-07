package com.spring.core.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeLoggingAspects {

    /*The Core Concepts

    1. Aspect: The class containing the code you want to inject (e.g., a Logger).
    2. Advice: The specific action taken (e.g., "do this before the method runs").
    3. Pointcut: The "where"—a filter that tells Spring which methods should be targeted.
    */


//    In Spring AOP, these two methods are called Advices, and the string inside
//    the @Before and @AfterReturning annotations is called a Pointcut expression.
//    This Pointcut expression targets any method in the EmployeeService class
    @Before("execution(* com.spring.core.aop.EmployeeService.*(..))")
    public void logBeforeVitals(JoinPoint joinPoint) {
//        The JoinPoint Parameter: This is a special Spring object that contains
//        metadata about the method being called.
        System.out.println("==> AOP: Preparing to call method: " + joinPoint.getSignature().getName());
    }

    // This runs after the method successfully completes
    // If your EmployeeService method throws an Exception (crashes), this specific code will not run.
    @AfterReturning("execution(* com.spring.core.aop.EmployeeService.*(..))")
    // Note: If you want code to run even if there is an error, you would use @After instead.
    public void logAfterSuccess() {
        System.out.println("==> AOP: Method executed successfully!");
    }
}