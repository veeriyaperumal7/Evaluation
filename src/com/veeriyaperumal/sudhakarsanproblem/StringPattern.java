package com.veeriyaperumal.sudhakarsanproblem;

import java.util.Scanner;

public class StringPattern {
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		String str = "";
		System.out.println("Enter the String");
		str = read.nextLine();
		print(str);
	}

	static void print(String str) {
		int i = 0, j = 1, k = 0;
		String left = "", right = "";
		while (j < str.length()) {
			if (str.charAt(j) >= 'A' && str.charAt(j) <= 'Z') {
				break;
			}
			j++;
		}
		k = j;
		while (i < k || j < str.length()) {
			if (i < k) {
				if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
					left += String.valueOf(str.charAt(i)).toUpperCase();
				} else {
					left += str.charAt(i);
				}
				i++;
			}
			if (j < str.length()) {
				if (str.charAt(j) >= 'a' && str.charAt(j) <= 'z') {
					right += String.valueOf(str.charAt(j)).toUpperCase();
				} else {
					right += str.charAt(j);
				}
				j++;
			}
			System.out.println(left + right);
		}
	}
}
