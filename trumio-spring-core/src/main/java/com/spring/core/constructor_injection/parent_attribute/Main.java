package com.spring.core.constructor_injection.parent_attribute;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
//		Resource r = new ClassPathResource("config_ci2.xml");
//		BeanFactory factory = new XmlBeanFactory(r);

		ApplicationContext context = new ClassPathXmlApplicationContext("bean_configs/ci_config_3.xml");
		Employee e1 = (Employee) context.getBean("e1");
		Employee e2 = (Employee) context.getBean("e2");

		e1.show();
		e2.show();

	}
}