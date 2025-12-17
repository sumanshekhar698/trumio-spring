package com.spring.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/*lifecycle methods using interface*/
public class CocaCola implements InitializingBean, DisposableBean {
	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		System.out.println("Setting price of CocaCola via setters");
		this.price = price;
	}

	public CocaCola() {
		super();
	}

	@Override
	public String toString() {
		return "CocaCola [price=" + price + "]";
	}

	// init code here
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("INIT CocaCola using interface");
	}

	// destroy|cleanup code here
	@Override
	public void destroy() throws Exception {
		System.out.println("DESTROY CocaCola using interface");
	}

}
