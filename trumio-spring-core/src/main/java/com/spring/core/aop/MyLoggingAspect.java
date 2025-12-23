//package com.spring.core.aop;
//
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//public class MyLoggingAspect {
//
//    // Pointcut expression: Execution of any method in the dao package
//    @Before("execution(* com.spring.jdbc.dao.StudentDAOImp1.*(..))")
//    public void logBefore() {
//        System.out.println(">> AOP LOG: Method is about to start...");
//    }
//
//    @After("execution(* com.spring.jdbc.dao.StudentDAOImp1.delete*(..))")
//    public void logAfterDelete() {
//        System.out.println(">> AOP LOG: A delete operation was attempted.");
//    }
//}