package com.spring.core.loading;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")// All the prototype beans are Lazy by behaviour
public class PrototypeBean2 {
    public PrototypeBean2() { System.out.println("Prototype 2 Created!"); }
}

