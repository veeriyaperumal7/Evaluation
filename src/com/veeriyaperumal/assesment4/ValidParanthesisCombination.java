package com.veeriyaperumal.assesment4;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ValidParanthesisCombination {
	char arr[];
	private static Scanner read = new Scanner(System.in);

	public ValidParanthesisCombination(int length) {
		arr = new char[length];
	}

	public static void main(String[] args) {
		System.out.print("Enter how many set of paranthesis : ");
		ValidParanthesisCombination obj = new ValidParanthesisCombination(read.nextInt() * 2);
		Set<String> result = new HashSet<>();
		obj.generateCombination(0, result, 0, 0, obj.arr, obj.arr.length / 2);
		obj.printValidCombinations(result);
	}

	private void printValidCombinations(Set<String> result) {
		System.out.println("The valid combinations of a given " + arr.length / 2 + " paranthesis set is : ");
		for (String temp : result) {
			System.out.println(temp);
		}

	}

	private void generateCombination(int index, Set<String> result, int open, int close, char arr[], int n) {
		if (close == n) {
			result.add(new String(arr));
			return;
		}
		if (open < n) {
			arr[index] = '(';
			generateCombination(index + 1, result, open + 1, close, arr, n);
		}
		if (close < open) {
			arr[index] = ')';
			generateCombination(index + 1, result, open, close + 1, arr, n);
		}

	}

//	private boolean isValidParanthesis(String str) {
//		Stack<Character> stack = new Stack();
//		for (int i = 0; i < str.length(); i++) {
//			if (str.charAt(i) == '(') {
//				stack.push(str.charAt(i));
//			} else {
//				if (stack.isEmpty()) {
//					return false;
//				} else {
//					stack.pop();
//				}
//			}
//		}
//		return (stack.isEmpty()) ? true : false;
//
//	}

}
