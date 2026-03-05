package com.spring.core.aop;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    public void addEmployee(String name) {
        System.out.println("Adding employee: " + name);
        // Logic to save to database...
    }
}