package com.spring.core.loading;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")// Scope is prototype, the Loading is Lazy by default

public class PrototypeBean {
    public PrototypeBean() { System.out.println("Prototype  Created!"); }
}

