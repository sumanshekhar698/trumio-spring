package com.spring.core.reference_injection;

public class BClass {
	private int yVar;

	public int getyVar() {
		return yVar;
	}

	public void setyVar(int yVar) {
		this.yVar = yVar;
	}

	public BClass() {
		super();
	}

	@Override
	public String toString() {
		return "BClass [yVar=" + yVar + "]";
	}

}
