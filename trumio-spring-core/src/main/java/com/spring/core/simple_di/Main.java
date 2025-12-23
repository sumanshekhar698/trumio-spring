package com.spring.core.simple_di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
//IOC stands for Inversion of Control :
	public static void main(String[] args) {
		System.out.println("START");
		
		// Creating objects using new
		Student st1 = new Student();
		System.out.println(st1);

		Student st2 = new Student(1, "Suman Shekhar", "Bangalore");
		System.out.println(st2);
		System.out.println();
		
//		ApplicationContext context0 = new ClassPathXmlApplicationContext("config.xml");
//		Every time a context is initialized it will create all the bean

		ApplicationContext context = new ClassPathXmlApplicationContext("bean_configs/simple_di.xml");
//		It will search the simple_di.xml in resource directory of src/main/resources/bean_configs
		

		// the bean will be of Object type , thus type casted with (Student)
		Student s1 = (Student) context.getBean("student1");
		System.out.println(s1);
		System.out.println(s1.hashCode());

		
		Student s1Bean = (Student) context.getBean("student1");
		System.out.println(s1Bean.hashCode());
		
		Student s2 = (Student) context.getBean("student2");
		System.out.println(s2);
		
		Student s3 = (Student) context.getBean("student3");
		System.out.println(s3);
		
		
		System.out.println("END");
		
	}

}
