package com.spring.core.constructor_injection.parent_attribute;

public class Address {//POJO
	private String addressLine1, city, state, country;

	public Address(String addressLine1, String city, String state, String country) {
		super();
		this.addressLine1 = addressLine1;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public String toString() {
		return addressLine1 + " " + city + " " + state + " " + country;
	}

}