package com.spring.core.auto_wire.annotations;

public class Address {
	private String street;
	private int pin;
	private String city;
	

	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "Address [street=" + street + ", pin=" + pin + ", city=" + city + "]";
	}
	
}
