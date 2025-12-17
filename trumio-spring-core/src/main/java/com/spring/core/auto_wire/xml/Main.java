package com.spring.core.auto_wire.xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("bean_configs/autowire_config_2.xml");

		Address adr1 = context.getBean("address", Address.class);
		System.out.println(adr1);

		Worker w1 = context.getBean("w1", Worker.class);
		System.out.println(w1);

	}

}
