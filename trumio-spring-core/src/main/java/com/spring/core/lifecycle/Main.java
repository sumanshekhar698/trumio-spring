package com.spring.core.lifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

//		ApplicationContext
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("bean_configs/lifecycle_config.xml");

		context.registerShutdownHook();
// 		Registering shutdown hook when you have to destroy object call the hooked-> destroy method()

		Samosa s1 = (Samosa) context.getBean("s1");
		System.out.println(s1);

		CocaCola c1 = (CocaCola) context.getBean("c1");
		System.out.println(c1);

		BreadToast b1 = (BreadToast) context.getBean("b1");
		System.out.println(b1);

//		The order of destroy for beans may differ but 
//		individual order of every beans is setting->init->destroy

		context.close();
	}

}
