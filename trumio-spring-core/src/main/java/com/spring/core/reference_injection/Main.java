package com.spring.core.reference_injection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "bean_configs/ref_config.xml");


        Object oref1 = context.getBean("aref1");
        if (oref1 instanceof AClass) {
            AClass aref1 = (AClass) oref1;
//		Object aref1 = context.getBean("aref1");

            System.out.println(aref1);
            System.out.println(aref1.getxVar());

            System.out.println(aref1.getbObj());
            System.out.println(aref1.getbObj().getyVar());

            AClass aref2 = (AClass) context.getBean("aref2");
            System.out.println(aref2);

            AClass aref3 = (AClass) context.getBean("aref3");
            System.out.println(aref3);
        }

        int beanDefinitionCount = context.getBeanDefinitionCount();
        System.out.println(beanDefinitionCount);

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanDefinitionNames));


        context.close();

//		((ConfigurableApplicationContext) context).close();// to close ==> downcast to Configurable Application context
    }
}
