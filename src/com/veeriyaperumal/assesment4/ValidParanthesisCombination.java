package com.veeriyaperumal.assesment4;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ValidParanthesisCombination {
	char arr[];
	String input;
	private static Scanner read = new Scanner(System.in);

	public ValidParanthesisCombination(String input) {
		this.input = input;
		arr = input.toCharArray();
	}

	private static String getInput() {
		int n;
		String str = "";
		System.out.print("Enter the number of paranthesis set : ");
		n = read.nextInt();
		for (int i = 0; i < n; i++) {
			str += "()";
		}
		return str;
	}

	public static void main(String[] args) {
		ValidParanthesisCombination obj = new ValidParanthesisCombination(getInput());
		Set<String> result = new HashSet<>();
		obj.generateCombination(0, obj.input.length(), result, obj.arr);
		obj.printValidCombinations(result);
	}

	private void printValidCombinations(Set<String> result) {
		System.out.println("The valid combinations of a given " + input.length()/2 + " paranthesis set is : ");
		for (String temp : result) {
			System.out.println(temp);
		}

	}

	private void generateCombination(int start, int end, Set<String> result, char arr[]) {
		if (start >= end) {
			if (isValidParanthesis(new String(arr))) {
				result.add(new String(arr));
			}
			return;
		}
		for (int i = start; i < end; i++) {
			swap(i, start, arr);
			generateCombination(start + 1, end, result, arr);
			swap(i, start, arr);
		}
	}

	private boolean isValidParanthesis(String str) {
		Stack<Character> stack = new Stack();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				stack.push(str.charAt(i));
			} else {
				if (stack.isEmpty()) {
					return false;
				} else {
					stack.pop();
				}
			}
		}
		return (stack.isEmpty()) ? true : false;

	}

	private static void swap(int i, int j, char[] arr) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
