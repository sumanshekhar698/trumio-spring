package com.spring.core.constructor_injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean_configs/ci_config_1.xml",
				"bean_configs/ci_config_2.xml");
		Person p1 = (Person) context.getBean("person1");
		Person p2 = (Person) context.getBean("person2");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println();

		// Ambiguity Issue
		Addition a1 = (Addition) context.getBean("add");
		a1.doSum();
	}
}