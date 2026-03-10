package com.spring.core.validation_and_binding;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@Configuration
@ComponentScan("com.spring.core.validation_and_binding")
public class JavaConfig {

    @Bean
    static public MethodValidationPostProcessor methodValidationPostProcessor() {
        // This is the "Engine" that searches for @Valid and triggers Hibernate Validator
        return new MethodValidationPostProcessor();
    }


    @Bean
    public ConversionService conversionService() {
        DefaultConversionService service = new DefaultConversionService();
        service.addConverter(new StringToWithdrawalConverter());
        return service;
    }
}