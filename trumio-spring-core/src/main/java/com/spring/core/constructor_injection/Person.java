package com.spring.core.constructor_injection;

import java.util.List;

public class Person {
	private String name;
	private int age;
	private Certificate certificate;
	private List<String> listOfCourses;

	public Person(String name, int age, Certificate certificate, List<String> listOfCourses) {
		super();
		System.out.println("Person(age,certificate,listOfCourses) constructor called");
		this.name = name;
		this.age = age;
		this.certificate = certificate;
		this.listOfCourses = listOfCourses;

	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", certificate=" + certificate + ", listOfCourses="
				+ listOfCourses + "]";
	}

}
