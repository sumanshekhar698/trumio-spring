package com.spring.core.lifecycle;

/*lifecycle methods using xml*/
public class Samosa {
	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		System.out.println("Setting price of Samosa via setter");
		this.price = price;
	}

	public Samosa() {
		super();
	}

	@Override
	public String toString() {
		return "Samosa [price=" + price + "]";
	}

	// I want this init fn to be triggered after bean creation
	public void init() {
		System.out.println("INIT Samosa via xml");
	}

	// I want this destroy fn to be triggered bean object deletion
	public void destroy() {
		System.out.println("DESTROY Samosa via xml");
	}
}
