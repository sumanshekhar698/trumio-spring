package com.spring.core.loading;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy 
// Scope is Singelton, but here the the Loading is Lazy
// This tells Spring: "Wait until I actually need this"
public class LazyBean {
    public LazyBean() {
        System.out.println(">> LazyBean initialized only when CALLED!");
    }
}