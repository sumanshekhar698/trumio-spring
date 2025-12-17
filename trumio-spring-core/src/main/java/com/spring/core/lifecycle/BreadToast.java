package com.spring.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

//lifecycle using @Annotation
public class BreadToast {
	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
		System.out.println("Setting price of BreadToast via setter");
	}

	@Override
	public String toString() {
		return "BreadToast [price=" + price + "]";
	}

	public BreadToast() {
		super();
	}

	// for 9+ java have to mention the dependencies
	@PostConstruct
	public void start() {
		System.out.println("INIT BreadToast using @Annotations");
	}

	@PreDestroy
	public void end() {
		System.out.println("DESTROY BreadToast using @Annotations");
	}

}
