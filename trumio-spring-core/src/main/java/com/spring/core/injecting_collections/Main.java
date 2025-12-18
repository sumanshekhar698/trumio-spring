package com.spring.core.injecting_collections;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"bean_configs/collection_config.xml");

		Employee emp1 = (Employee) context.getBean("emp1");
		System.out.println(emp1.getName());
		System.out.println(emp1.getPin());
		System.out.println(emp1.getTags());
		System.out.println(emp1.getPhones());
		System.out.println(emp1.getPhones().getClass());// class java.util.ArrayList by default
		System.out.println(emp1.getPhones().getClass().getName());// java.util.ArrayList
		System.out.println(emp1.getAddress());
		System.out.println(emp1.getCourse());
		System.out.println(emp1.getGeneral());
		
//		context.close();

	}
}
