package com.spring.core.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// --- 1. THE CONFIGURATION ---
@Configuration
@ComponentScan(basePackages = "com.spring.core.aop") // Tells Spring where to find your classes
@EnableAspectJAutoProxy                      // CRITICAL: This replaces the Boot auto-config
class AppConfig {
}

// --- 2. THE ASPECT ---
@Aspect
@Component
class LoggingAspect {
    @Around("execution(* com.spring.core.aop.MyService.doWork(..))")
    public Object logTime(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("AOP: Method starting...");
        Object result = joinPoint.proceed();
        System.out.println("AOP: Method finished.");
        return result;
    }
}

// --- 3. THE SERVICE ---
@Service
class MyService {
    public void doWork() {
        System.out.println("Core Logic: Doing some work...");
    }
}

// --- 4. THE MAIN CLASS ---
public class MainApp {
    public static void main(String[] args) {
        // Initialize the Spring Context manually
        AnnotationConfigApplicationContext context = 
                new AnnotationConfigApplicationContext(AppConfig.class);

        // Get the Bean from the context
        MyService service = context.getBean(MyService.class);

        // Call the method - Spring will automatically wrap this in a proxy
        service.doWork();

        context.close();
    }
}