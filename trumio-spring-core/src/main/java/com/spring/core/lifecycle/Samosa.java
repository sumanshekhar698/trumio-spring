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

	public void init() {
		System.out.println("INIT Samosa via xml");
	}

	public void destroy() {
		System.out.println("DESTROY Samosa via xml");
	}
}
