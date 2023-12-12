package com.veeriyaperumal.assesment2;

import java.util.Scanner;

public class FormString {
	private static Scanner read = new Scanner(System.in);
	String str1, str2;

	private boolean canForm() {
		int freq[] = new int[26];
		String temp = "";
		if (str1.length() < str2.length()) {
			temp = str2;
			str2 = str1;
			str1 = temp;
		}
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) >= 'a' && str1.charAt(i) <= 'z') {
				freq[str1.charAt(i) - 97]++;
			} else {
				freq[str1.charAt(i) - 65]++;
			}
		}
		for (int i = 0; i < str2.length(); i++) {
			if (str2.charAt(i) >= 'a' && str2.charAt(i) <= 'z') {
				if (freq[str2.charAt(i) - 97] != 0) {
					freq[str2.charAt(i) - 97]--;
				} else {
					return false;
				}
			} else {
				if (freq[str2.charAt(i) - 65] != 0) {
					freq[str2.charAt(i) - 65]--;
				} else {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		FormString obj = new FormString();
		System.out.print("Enter the String 1 : ");
		obj.str1 = read.nextLine();
		System.out.print("Enter the String 2 : ");
		obj.str2 = read.nextLine();
		if (obj.canForm()) {
			System.out.println("True - " + obj.str2 + " can be formed.");
		} else {
			System.out.println("False - " + obj.str2 + " cannot be formed.");
		}
	}

}
