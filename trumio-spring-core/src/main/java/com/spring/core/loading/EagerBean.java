package com.spring.core.loading;

import org.springframework.stereotype.Component;

@Component
// No annotation needed, The scope is Singelton and its EAGER by default
public class EagerBean {
    public EagerBean() {
        System.out.println(">> EagerBean initialized at Startup!");
    }
}