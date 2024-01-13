package com.veeriyaperumal.rajeesanproblem;

import java.util.Scanner;

/*
 * Given a string S, find the longest palindromic substring in S. Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S). Palindrome string: A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S. Incase of conflict, return the substring which occurs first ( with the least starting index).

 

 

Example 1:

 

Input:

S = "aaaabbaa"

Output: aabbaa

Explanation: The longest Palindromic

substring is "aabbaa".

Example 2:

 

Input:

S = "abc"

Output: a

Explanation: "a", "b" and "c" are the

longest palindromes with same length.

The result is the one with the least

starting index.

 

Expected Time Complexity: O(|S|2).

Expected Auxiliary Space: O(1).
 */
public class LongestPallindromicSubstring {

	private Scanner read = new Scanner(System.in);

	public static void main(String[] args) {
		LongestPallindromicSubstring obj = new LongestPallindromicSubstring();
		System.out.print("Enter the string : ");
		String str = obj.read.nextLine();
		System.out.print("The longest pallindromic substring is : " + obj.findMaximumSubstring(str));
	}

	private String findMaximumSubstring(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {

			for (int j = str.length() - 1; j >= i; j--) {

				if (str.charAt(i) == str.charAt(j)) {
					if (isValidPallindrome(str, i, j)) {
						if (str.substring(i, j + 1).length() > result.length()) {
							result = str.substring(i, j + 1);
						}
					}
				}
			}
		}
		return result;
	}

	private boolean isValidPallindrome(String str, int i, int j) {
		while (i < j) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

}
