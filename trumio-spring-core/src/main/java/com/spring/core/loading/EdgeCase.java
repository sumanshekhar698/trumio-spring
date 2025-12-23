package com.spring.core.loading;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//The scope is Singelton and its EAGER by default, 
//but its dependency PrototypeBean which has a scope Prototype becomes EAGER here instead of LAZY

public class EdgeCase {
    @Autowired
    private PrototypeBean proto; 

    public EdgeCase() { System.out.println("Singleton Created!"); }
}