package com.spring.core.simple_di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class Main {
    private static Object s0Bean;

    //IOC stands for Inversion of Control :
    public static void main(String[] args) {
        System.out.println("START");

        // Creating objects using new
//        Student st1 = new Student();
//        st1.setStudentAddress("LA");
//        st1.setStudentId(1);
//        st1.setStudentName("Johnny Depp");
//        System.out.println(st1);

//        Student st2 = new Student(1, "Suman Shekhar", "Bangalore");
//        System.out.println(st2);
//        System.out.println();

//		ApplicationContext context0 = new ClassPathXmlApplicationContext("config.xml");
//		Every time a context is initialized, it will create all the bean

        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean_configs/simple_di.xml");
//		It will search the simple_di.xml in the resource directory of src/main/resources/bean_configs


        if (context.containsBean("student0")) {
            Student s0Bean = (Student) context.getBean("student0");
            System.out.println(s0Bean);
            System.out.println(s0Bean.hashCode());
        }

        int beanDefinitionCount = context.getBeanDefinitionCount();
        System.out.println("Total number of beans defined in the context: " + beanDefinitionCount);

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanDefinitionNames));

        System.out.println("Is the Bean Scope Singleton ?" + context.isSingleton("student1"));


        Student s1Bean = (Student) context.getBean("student1");
        System.out.println(s1Bean);
        System.out.println(s1Bean.hashCode());

        // the bean will be of Object type, thus type cast with (Student)
        Object s1Obj = context.getBean("student1");
        Student s1Bean2 = (Student) s1Obj;//DOWN CASTING
        System.out.println(s1Bean2);
        System.out.println(s1Bean2.hashCode());

        Student s2 = (Student) context.getBean("student2");
        System.out.println(s2);

        Student s3 = (Student) context.getBean("student3");
        System.out.println(s3);


        System.out.println("END");

    }

}
