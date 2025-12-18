package org.trumio.java.language.inheritance;

class ClassZ {

	int x = 100;

}

public class ClassA extends ClassZ {

	int x = 8;

	void foo() {
		System.out.println("FOOOOOOO");
	}

	ClassA() {
		System.out.println("ClassA");
	}

	public static void main(String[] args) {
		ClassA classA = new ClassA();
		System.out.println(classA.x);

		ClassB classB = new ClassB();
		classB.say();

	}

}

class ClassB extends ClassA {
	int x = 10;

	void foo() {
		System.out.println("fooooo");
	}

	public ClassB() {
		super();
	}

	void say() {
		System.out.println(x);
		System.out.println(super.x);// super points to IMMEDIATE parent
		foo();
		super.foo();
	}

}
