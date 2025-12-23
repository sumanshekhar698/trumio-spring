package com.spring.core.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy // This turns on AOP!
@ComponentScan(basePackages = "com.spring.core.aop")
public class JavaConfig { 

}