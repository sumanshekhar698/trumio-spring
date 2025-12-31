package org.trumio.java.language.interfaces;

public class Main {

	public static void main(String[] args) {

//		Bird bird = new Bird();//Directly

		Eagle eagle = new Eagle();// using implementation

		Bird sparrow = new Bird() {// Anonymous Inner Type

			@Override
			public void eat() {
				// TODO Auto-generated method stub

			}
		};

//		3* Lambda Fn :: This only applies top Functional Interface

		Bird hen = () -> {
			System.out.println("Hen and Chickens");
		};

	}

}
