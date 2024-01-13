package com.veeriyaperumal.rajeesanproblem;

import java.util.Scanner;

/*
 * Print the given lines as one by one whenever
a) Space Comes
b) Special Character comes
c) In the word in the middle in which has upper case

Input :

This is a /// PowerShot.Total-75-runs$

Output :
This
is
a
///                         

Power
Shot
.
Total

-

75

-

runs

$
 */

public class PrintStringAsPerCondition {

	private Scanner read = new Scanner(System.in);

	public static void main(String[] args) {
		PrintStringAsPerCondition obj = new PrintStringAsPerCondition();
		System.out.print("Enter the string : ");
		String str = obj.read.nextLine();
		obj.getFormatedValue(str);
	}

	private void getFormatedValue(String str) {
		String temp = "";

		for (int i = 0; i < str.length();) {
			char c = str.charAt(i);
			if (c == ' ') {
				i++;
				continue;
			}
			if (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' || c >= '0' && c <= '9') {
				temp = getWord(i, str);
				System.out.println(temp);

			} else {
				temp = getSpecialWord(i, str);
				System.out.println("\n" + temp + "\n");

			}
			i += temp.length();
		}

		return;
	}

	private String getSpecialWord(int i, String str) {
		String word = str.charAt(i++) + "";
		while (i < str.length()) {
			char c = str.charAt(i);
			if (c == ' ' || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
				break;
			}
			word += str.charAt(i++) ;
		}
		return word;
	}

	private String getWord(int i, String str) {
		String word = str.charAt(i++) + "";
		while (i < str.length()) {
			char c = str.charAt(i);
			if ((c == ' ' || (c >= 'A' && c <= 'Z'))) {
				break;
			} else if ((!(c >= '0' && c <= '9') && !(c >= 'a' && c <= 'z'))) {
				break;
			}
			word += str.charAt(i++);
		}
		return word;
	}

}
