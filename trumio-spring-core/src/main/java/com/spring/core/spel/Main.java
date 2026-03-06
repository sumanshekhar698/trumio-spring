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

//		When you use the SpelExpressionParser directly in Java code, it expects a raw expression. The symbols #{ } are
//		delimiters used by Spring (specifically in @Value or XML configurations) to separate
//		SpEL from literal text. Inside your Java code,
//		the parser sees the # as invalid and { as optional tokens because
//		they aren't part of the SpEL syntax itself.

//		Expression expression1 = spell.parseExpression("#{T(java.lang.Math).sqrt(169)}");// Expression Evaluation tester
		Expression expression2 = spell.parseExpression("{T(java.lang.Math).sqrt(169)}");// Expression Evaluation tester
		Expression expression3 = spell.parseExpression("T(java.lang.Math).sqrt(169)");// Expression Evaluation tester
		System.out.println(expression2.getValue());
		System.out.println(expression3.getValue());

	}

}
