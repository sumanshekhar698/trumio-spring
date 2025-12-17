package com.spring.core.constructor_injection;

public class Addition {
	private int a;
	private int b;

	/*
	 * Here ambiguity arises if we have it define type in .xml due to ambiguity the
	 * top order(the 1st) constructor matching the parameter is getting executed
	 * First priority goes to String irrespective of order Then the order of
	 * constructor in checked if it doesn't matches
	 *
	 */

//	it will be called if we are passing int int as this is the 1st constructor matching
	public Addition(double a, double b) {
		super();
		System.out.println("Adition(double a, double b) called");
		this.a = (int) a;
		this.b = (int) b;
	}

	public Addition(int a, int b) {
		super();
		/*
		 * Spring is so intelligent that it can match the best constructor from the
		 * first explicit type="int only"
		 */
		System.out.println("Adition(int a, int b) called");
		this.a = a;
		this.b = b;
	}

	public Addition(String a, String b) {
//		highest priority is given to String
		super();
		System.out.println("Adition(String a, String b) called");
		this.a = Integer.parseInt(a);
		this.b = Integer.parseInt(b);
	}

	public void doSum() {
		System.out.println("a = " + a + " | b = " + b);
		System.out.println("SUM =" + (this.a + this.b));
	}

}
