package com.spring.core.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component//Used when @Bean is not declared on getter-method of the Java config
public class Student {

	@Autowired // automatic injection
	private Samosa units;

	public void study() {
		this.units.order();
		System.out.println("STYDYING: \"\"The Pen in mightier than sword");
	}

	public Samosa getUnits() {
		return units;
	}

//	through constructor injection
//	public Student(Samosa units) {
//		super();
//		this.units = units;
//	}

	public void setUnits(Samosa units) {
		this.units = units;
	}
}
