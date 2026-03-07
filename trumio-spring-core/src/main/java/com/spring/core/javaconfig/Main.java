package com.spring.core.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

//		 Using XML file 
//		ApplicationContext context = new ClassPathXmlApplicationContext("bean_configs/java_config.xml");
//		Student s1 = context.getBean("student", Student.class);
//		System.out.println(s1);
//		context.close();

//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
//                JavaConfig.class);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // 1. Get the environment and set an active profile
        context.getEnvironment().setActiveProfiles("prod");
        // 2. Register the config class
        context.register(JavaConfig.class);
        // 3. Refresh to start the container
        context.refresh();


        Student s0 = context.getBean("getStudent", Student.class);
        // by default, its method name, but we can call it via specified names too in the names array
        System.out.println(s0);
//        s0.study();// NullPointerException

        System.out.println();
        Student s1 = context.getBean("student_1", Student.class);
        System.out.println(s1);
        s1.study();
        System.out.println();

        Student s2 = context.getBean("student_2", Student.class);
        System.out.println(s2);
        s2.study();
        System.out.println();


        Samosa s = context.getBean(Samosa.class);
        System.out.println(s); // Will print the "Cheap Potato" version

        // will only work on DEV profile
        Samosa samosa = context.getBean("getSamosaPlain", Samosa.class);
        System.out.println(samosa);
        samosa.order();

    }

}
