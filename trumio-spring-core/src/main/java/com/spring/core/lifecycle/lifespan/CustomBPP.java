package com.spring.core.lifecycle.lifespan;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomBPP implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        if (beanName.equalsIgnoreCase("paymentService")) {
            System.out.println("[PHASE 2: BPP BEFORE] Intercepting before @PostConstruct");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if (beanName.equalsIgnoreCase("paymentService")) {
            System.out.println("[PHASE 3.5: BPP AFTER] Intercepting after @PostConstruct. (Proxy Created)");
        }
        return bean;
    }
}