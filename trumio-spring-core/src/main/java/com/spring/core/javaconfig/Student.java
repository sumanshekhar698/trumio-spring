package com.spring.core.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component//Used when @Bean is not declared on getter-method of the Java config
public class Student {

    //    @Autowired // automatic injection
    private Samosa samosa;

    public void study() {
        this.samosa.order();
        System.out.printf("Eating [%s] flavoured samosa and then studying\n", samosa.getFlavor());
    }

    public Samosa getSamosa() {
        return samosa;
    }

    //    @Autowired
    public void setSamosa(Samosa samosa) {
        System.out.println("Setting units of Student via setter");
        this.samosa = samosa;
    }

    //	through constructor injection
    public Student(Samosa samosa) {
        super();
        this.samosa = samosa;
        System.out.println("Student parameterized constructor called");
    }

    public Student() {
        System.out.println("Student parameterless constructor called");
    }

    @Override
    public String toString() {
        return "Student{" +
                "samosa=" + samosa +
                '}';
    }
}
