package com.spring.core.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanProcessor implements BeanPostProcessor {


    /*postProcessBeforeInitialization: Called after the bean is created and its dependencies are injected
     (via setter/field), but before any custom init() or @PostConstruct methods run.*/
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BEFORE INIT: " + beanName + " of type " + bean.getClass().getName());
        return bean; // You must return the bean (or a wrapper)!
    }


    /*postProcessAfterInitialization: Called after the init() methods are finished.
     This is where Spring typically creates AOP Proxies.*/
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("AFTER INIT: " + beanName + " finished setup.");
        return bean;
    }
}