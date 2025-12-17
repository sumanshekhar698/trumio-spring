package com.spring.core.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestConfigFree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 *** using xml ApplicationContext context = new ClassPathXmlApplicationContext
		 * context = new
		 * ClassPathXmlApplicationContext("com/spring/core/javaconfig/javaconfig.xml");
		 * Student s1 = context.getBean("student",Student.class);
		 * System.out.println(s1); context.close();
		 */

		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		Student s1 = context.getBean("getStudent", Student.class);
		// by default its method name but we can call it via specified names too in the
		// names array
		System.out.println(s1);
		s1.study();

	}

}
