package com.spring.core.aop;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
//@Component
public class EmployeeService {
    // Do some stuff Before Trigger addEmployee
    public void addEmployee(String name) {
        System.out.println("Adding employee: " + name);
        // Logic to save to a database...
    }
    // Do some stuff After Trigger addEmployee
}