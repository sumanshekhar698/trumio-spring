package com.spring.core.resources;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ResourceConfig.class);
        MyFileReader reader = context.getBean(MyFileReader.class);

        // Load from Classpath
        reader.readFile("classpath:files/info.txt");

        // Load from Web
        reader.readFile("http://www.springframework.org/schema/beans/spring-beans.xsd");

        context.close();
    }
}