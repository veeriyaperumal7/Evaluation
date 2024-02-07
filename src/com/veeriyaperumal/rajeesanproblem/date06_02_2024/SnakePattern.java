package com.veeriyaperumal.rajeesanproblem.date06_02_2024;

import java.util.Scanner;

public class SnakePattern {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.print("Enter how many rows :");
		int n = read.nextInt(), count = 0;
		int number = 0;
		int spaceCount = n - 1;
		while (count < n) {
			for (int i = 1; i <= spaceCount; i++) {
				System.out.print("    ");
			}
			spaceCount--;
			for (int i = 1; i <= n; i++) {
				System.out.print(++number + "    ");
			}
			count++;
			System.out.println();
			for (int i = 1; i <= spaceCount && count < n; i++) {
				System.out.print("    ");
			}
			spaceCount--;
			number += n;
			int temp = number;
			for (int i = 1; i <= n && count < n; i++) {
				System.out.print(temp-- + "    ");
			}
			System.out.println();
			count++;
		}
	}
}
