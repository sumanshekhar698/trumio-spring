package com.spring.core.stereotype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("bean_configs/stereo_config.xml");
		Student s1 = context.getBean("s1", Student.class);//
		System.out.println(s1);
		System.out.println(s1.getCourses().getClass());
		System.out.println(s1.hashCode());

		System.out.println();
		Student s2 = context.getBean("s1", Student.class);
		System.out.println(s2);
		System.out.println(s2.hashCode());

		// Changing scope via XML
		System.out.println();
		Teacher t1 = context.getBean("teacher", Teacher.class);
		Teacher t2 = context.getBean("teacher", Teacher.class);
		System.out.println("Teacher\n" + t1.hashCode());
		System.out.println(t2.hashCode());

	}

}
