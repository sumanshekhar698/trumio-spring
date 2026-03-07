package com.spring.core.aop;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) throws Exception {


        ApplicationContext context = new AnnotationConfigApplicationContext(
                JavaConfig.class);
//        EmployeeService employeeService = context.getBean("employeeService", EmployeeService.class);
//        employeeService.addEmployee("Alice");
//        System.out.println();
//        employeeService.addEmployee("James");
//        System.out.println();
//        employeeService.addEmployee("Johny");

        AtmService atmService = context.getBean("atmService", AtmService.class);
        atmService.withdraw(1234, 100.0);

        System.out.println();
        atmService.withdraw(1235, 10000.0);


        System.out.println("END");

    }
}
