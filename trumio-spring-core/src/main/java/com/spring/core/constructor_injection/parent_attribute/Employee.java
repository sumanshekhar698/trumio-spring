package com.spring.core.constructor_injection.parent_attribute;

public class Employee {
	private int id;
	private String name;
	private Address address;

	public Employee() {
	}

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Employee(int id, String name, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	void show() {
		System.out.println(id + " | " + name + " | " + address);
	}

}