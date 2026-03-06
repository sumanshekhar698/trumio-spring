package com.spring.core.auto_wire.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Worker {

    //	Even though your constructor is empty, and you didn't call the setter,
    //	Spring is injecting the value directly into the private field using Java Reflection.
//    @Qualifier("permanent") // to pinpoint the dependency
//    @Autowired // uses "type" by default
    private Address address;
//	if there are multiple types available, if at least one is matching the var name,
//	it will not give error else it will be ambiguous for multiple beans

    public Address getAddress() {
        return address;
    }

    //    @Autowired
//    @Qualifier("current")//setter gets priority over properties injection
    public void setAddress(Address address) {
        System.out.println("Setters used for injection");
        this.address = address;
    }

    @Override
    public String toString() {
        return "Worker [address=" + address + "]";
    }

    public Worker() {
        super();
        System.out.println("Parameterless constructor is used for injection");

    }

    @Autowired
//	@Qualifier("permanent")// not allowed in Constructors
    public Worker(@Qualifier("permanent") Address address) {
//    public Worker(Address address) {
        super();
        System.out.println("Parameterized constructor is used for injection");
        this.address = address;
    }

}
