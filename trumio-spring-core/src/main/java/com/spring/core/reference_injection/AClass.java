package com.spring.core.reference_injection;

public class AClass {
	
	private int xVar;
	private BClass bObj;


	public int getxVar() {
		return xVar;
	}

	public void setxVar(int xVar) {
		this.xVar = xVar;
	}

	public BClass getbObj() {
		return bObj;
	}

	public void setbObj(BClass bObj) {
		this.bObj = bObj;
	}

	public AClass() {
		super();
	}

	@Override
	public String toString() {
		return "AClass [xVar=" + xVar + ", bObj=" + bObj + "]";
	}



}
