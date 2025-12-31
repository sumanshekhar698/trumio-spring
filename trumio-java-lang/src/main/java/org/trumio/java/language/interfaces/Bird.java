package org.trumio.java.language.interfaces;

@FunctionalInterface
public interface Bird {

	int x = 10;// public static final
//	abstract void fly();

	void eat();

	static void run() {
		System.out.println("Running");
	}

}
