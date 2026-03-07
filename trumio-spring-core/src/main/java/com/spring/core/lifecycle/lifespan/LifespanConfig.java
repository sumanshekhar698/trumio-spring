package com.spring.core.lifecycle.lifespan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.spring.core.lifecycle.lifespan")
@EnableAspectJAutoProxy // CRITICAL: This allows AOP Proxies to be created in the BPP phase
public class LifespanConfig {
    /* Since we are using @Component on our Service, BPP, and Aspect, 
       we don't need to define @Bean methods here unless we want 
       to define third-party beans.
    */
}