package org.trumio.java.language.design.singelton;

public class PrimeMinister {//SingleTon Design Pattern

	private String name;
	private int age;
	private static PrimeMinister pm;

	private PrimeMinister(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	static synchronized PrimeMinister getMyPrimeMinister(String name, int age) {
		if (pm == null) {
			pm = new PrimeMinister(name, age);
		}

		return pm;

	}

	@Override
	public String toString() {
		return "PrimeMinister [name=" + name + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
