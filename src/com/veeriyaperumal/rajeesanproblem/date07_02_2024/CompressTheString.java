package com.veeriyaperumal.rajeesanproblem.date07_02_2024;

/*
 * Write a program to compress the given string by using the below rules,
i) Replace all the consecutive occurrence of a character with that character followed by
count.
ii) If the consecutive occurrence not found, then use the character alone.(if the character
present only once, then don't include the count)
Examples:
Input: aaabbcdd
Output: a3b2cd2
Input: xyyyzzzabb
Output: xy3z3ab2
 */

public class CompressTheString {

	public static void main(String[] args) {
		String str = "xyyyzzzabb";
		StringBuilder res = new StringBuilder();
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i - 1) == str.charAt(i)) {
				count++;
			} else {
				res.append(str.charAt(i - 1));
				if (count > 1)
					res.append(count);
				count = 1;
			}
			if (i == str.length() - 1) {
				res.append(str.charAt(i - 1));
				if (count > 1)
					res.append(count);
			}
		}

		System.out.println(res.toString());
	}
}
