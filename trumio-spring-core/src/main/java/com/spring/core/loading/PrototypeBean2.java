package com.spring.core.loading;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")// All the prototype beans are Lazy by behavior
public class PrototypeBean2 {
    public PrototypeBean2() { System.out.println("PrototypeBean2 Created!"); }
}

