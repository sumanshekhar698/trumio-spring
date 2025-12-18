package com.spring.core.auto_wire.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Worker {
	@Qualifier("current") // to pin point the dependency
	@Autowired // uses "type" by default
	private Address address;
//	if there are multiple types available, if atleast one is matching the var name, 
//	it will not give error else it will be ambiguous for multiple beans

	public Address getAddress() {
		return address;
	}

//	@Autowired
//	@Qualifier("permanent")//setter gets priority over properties
	public void setAddress(Address address) {
		System.out.println("Setters are used for injection");
		this.address = address;
	}

	@Override
	public String toString() {
		return "Worker [address=" + address + "]";
	}

	public Worker() {
		super();
	}

//	@Autowired
//	@Qualifier("permanent")// not allowed in Constructors
	public Worker(Address address) {
		super();
		System.out.println("Parameterized constructor is used for injection");
		this.address = address;
	}

}
