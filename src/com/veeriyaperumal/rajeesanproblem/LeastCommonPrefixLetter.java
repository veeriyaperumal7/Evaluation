package com.veeriyaperumal.rajeesanproblem;

import java.util.Scanner;
import java.util.Stack;

public class LeastCommonPrefixLetter {
	private Scanner read = new Scanner(System.in);

	public static void main(String[] args) {
		String expression;
		String arr[] = { "techie delight", "tech", "techie", "technology", "technical" };
		LeastCommonPrefixLetter obj = new LeastCommonPrefixLetter();
		System.out.print("The common prefix is : " + obj.getCommonPrefix(arr));
	}

	private String getCommonPrefix(String[] arr) {
		String result = "";
		outer: for (int i = 0; i < arr[0].length(); i++) {
			char c = arr[0].charAt(i);
			for (int j = 1; j < arr.length; j++) {
				if (arr[j].length() == i || arr[j].charAt(i) != c) {
					break outer;
				}
			}
			result += c;
		}
		return result;
	}

}
