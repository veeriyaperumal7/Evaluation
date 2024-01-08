package com.veeriyaperumal.rajeesanproblem;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

/*2. Form a number system with only 3 and 4. Find the nth number of the number system.
Eg.) The numbers are: 3, 4, 33, 34, 43, 44, 333, 334, 343, 344, 433, 434, 443, 444, 3333, 
3334, 3343, 3344, 3433, 3434, 3443, 3444 ….
*/

public class FormANumberSystem {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.print("Enter the nth position : ");
		int n = read.nextInt();
		System.out.print("The nth number is : " + getNthNumber(n));
	}

	private static String getNthNumber(int n) {

		if (n == 1) {
			return "3";
		} else if (n == 2) {
			return "4";
		}
		n -= 2;
		Queue<String> queue = new LinkedList<>();
		queue.add("3");
		queue.add("4");
		while (!queue.isEmpty()) {
			String num = queue.poll();
			n--;
			queue.add(num + "3");
			if (n == 0) {
				return num + "3";
			}
			n--;
			queue.add(num + "4");
			if (n == 0) {
				return num + "4";
			}
		}
		return "No number found";
	}

}
