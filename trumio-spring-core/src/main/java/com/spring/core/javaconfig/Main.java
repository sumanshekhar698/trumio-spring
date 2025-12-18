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

		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		Student s1 = context.getBean("stud", Student.class);
		// by default its method name but we can call it via specified names too in the
		// names array
		System.out.println(s1);
		s1.study();

	}

}
