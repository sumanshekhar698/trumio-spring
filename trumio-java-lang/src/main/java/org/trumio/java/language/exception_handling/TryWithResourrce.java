package org.trumio.java.language.exception_handling;

import java.util.Scanner;

public class TryWithResourrce {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in);) {
			sc.next();
		}

//		sc.close();

	}

}
