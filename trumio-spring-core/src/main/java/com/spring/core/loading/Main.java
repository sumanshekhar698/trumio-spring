package com.spring.core.loading;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

		LazyBean bean1 = context.getBean("lazyBean", LazyBean.class);
		System.out.println(bean1);
		System.out.println(bean1.hashCode());

		LazyBean bean2 = context.getBean("lazyBean", LazyBean.class);
		System.out.println(bean2);
		System.out.println(bean2.hashCode());
//		
//		LazyBean bean3 = context.getBean("lazyBean", LazyBean.class);
//		System.out.println(bean3);

//		On Demand
//		PrototypeBean2 bean4 = context.getBean("prototypeBean2", PrototypeBean2.class);
//		System.out.println(bean4);
//		PrototypeBean2 bean5 = context.getBean("prototypeBean2", PrototypeBean2.class);
//		System.out.println(bean5);
//		PrototypeBean2 bean6 = context.getBean("prototypeBean2", PrototypeBean2.class);
//		System.out.println(bean6);

	}
}
