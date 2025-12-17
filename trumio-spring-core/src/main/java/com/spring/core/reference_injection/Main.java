package com.spring.core.reference_injection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"bean_configs/ref_config.xml");
		AClass aref1 = (AClass) context.getBean("aref1");
		System.out.println(aref1);
		System.out.println(aref1.getxVar());
		
		System.out.println(aref1.getbObj());
		System.out.println(aref1.getbObj().getyVar());
		
		AClass aref2 = (AClass) context.getBean("aref2");
		System.out.println(aref2);
		
		context.close();
		
//		((ConfigurableApplicationContext) context).close();// to close ==> downcast to Configurable Application context
	}
}
