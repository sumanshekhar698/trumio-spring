package com.spring.core.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Main {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("bean_configs/spel_config.xml");
		SpelFeatureShowcase d1 = context.getBean("spelFeatureShowcase", SpelFeatureShowcase.class);
		System.out.println(d1);
		
		SpelExpressionParser spell = new SpelExpressionParser();

//		No  when using SpelExpressionParser class
		Expression expression = spell.parseExpression("0>=1 ? true:false");// Expression Evaluation tester
		System.out.println(expression.getValue());

	}

}
