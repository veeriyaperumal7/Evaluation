package com.veeriyaperumal.assesment3;

import java.util.Scanner;
import java.util.ArrayList;

public class PrimeNumber {

	private static Scanner read = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter the end range of the prime number : ");
		int n = read.nextInt();
		PrimeNumber obj = new PrimeNumber();
		System.out.println("The given range for the prime number is : " + obj.generatePrimeNumbers(n).toString());
	}

	private ArrayList<Integer> generatePrimeNumbers(int n) {
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (i >= 1 && i <= 3) {
				result.add(i);
				continue;
			}
			if (i % 2 == 0) {
				continue;
			}
			if (isPrime(i)) {
				result.add(i);
			}
		}
		return result;
	}

	private boolean isPrime(int n) {
		for (int i = 2; i < n / 2 + 1; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
