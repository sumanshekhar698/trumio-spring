package org.trumio.java.language.design.singelton;

public class Main {

	public static void main(String[] args) {


//		PrimeMinister pm1 = new PrimeMinister("Joe Biden", 70);
//		PrimeMinister pm2 = new PrimeMinister("Donald Trump", 60);
//		PrimeMinister pm3 = new PrimeMinister("Donald Trump", 60);
		
		PrimeMinister pm1 = PrimeMinister.getMyPrimeMinister("Joe Biden", 70);
		PrimeMinister pm2 = PrimeMinister.getMyPrimeMinister("Donald Trump", 60);
		PrimeMinister pm3 = PrimeMinister.getMyPrimeMinister("Bill Clintom", 54);
		
		System.out.println(pm1);
		System.out.println(pm1.hashCode());
		System.out.println(pm2.hashCode());
		System.out.println(pm3.hashCode());
		


	}

}
