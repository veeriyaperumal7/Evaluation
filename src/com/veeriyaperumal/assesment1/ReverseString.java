package com.veeriyaperumal.assesment1;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.println("Enter the string : ");
		String str = read.nextLine();
		ReverseString reverseString = new ReverseString();
		String revString = reverseString.reverse(str, 0);
		System.out.println(revString);
	}

	private String reverse(String str, int i) {
		if (i >= str.length()) {
			return "";
		}
		return reverse(str, i + 1) + str.charAt(i);
	}
}
