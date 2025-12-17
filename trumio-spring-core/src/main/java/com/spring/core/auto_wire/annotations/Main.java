package com.spring.core.auto_wire.annotations;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"bean_configs/autowire_config_1.xml");
//		to skip type-casting
		Worker w1 = context.getBean("w1", Worker.class);
		System.out.println(w1);
	}
}
