package com.veeriyaperumal.rajeesanproblem;

import java.util.*;

public class ValueForm {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.print("Enter the number : ");
		String num = read.next();
		System.out.print("Enter the answer : ");
		ArrayList<String> result = new ArrayList<>();
		int answer = read.nextInt();
		int arr[] = new int[num.length()];
		for (int i = 0; i < num.length(); i++) {
			arr[i] = Integer.parseInt(num.charAt(i) + "");
		}

		findPermutation(0, arr.length, result, arr);
		String output = findAnswer(result, answer);
		if (output != null) {
			System.out.println("The output is " + output + "=" + answer);
		} else {
			System.out.println("There is no output for this given value");
		}

	}

	private static String findAnswer(ArrayList<String> result, int answer) {
		for (String arr : result) {
			for (int i = 1; i <= arr.length(); i++) {
				ArrayList<String> operation = new ArrayList<>();
				ArrayList<String> digitCombination = new ArrayList<>();
				generateOperatorCombination(operation, "", 0, arr.length() - i);
				generateDigitCombination(digitCombination, arr, i);
				System.out.println(operation);
				System.out.println(digitCombination);

				for (String operands : operation) {
					int value = Integer.parseInt(digitCombination.get(0));
					StringBuilder res = new StringBuilder(digitCombination.get(0));
					for (int j = 1; j < digitCombination.size(); j++) {
						res.append(operands.charAt(j - 1)).append(digitCombination.get(j));
						int num = Integer.parseInt(digitCombination.get(j));
						value = doOperation(value, operands.charAt(j - 1), num);
					}
					if (value == answer) {
						return res.toString();
					}
				}
			}
		}

		return null;
	}

	private static int doOperation(int num1, char operator, int num2) {
		switch (operator) {
		case '+':
			return num1 + num2;
		case '-':
			return num1 - num2;
		case '*':
			return num1 * num2;
		case '/':
			if (num2 == 0) {
				break;
			}
			return num1 / num2;
		}
		return 0;
	}

	private static void generateDigitCombination(ArrayList<String> digitCombination, String num, int len) {
		for (int i = 0; i <= num.length() - len; i += len) {
			digitCombination.add(num.substring(i, i + len));
		}
	}

	private static void generateOperatorCombination(ArrayList<String> operation, String combination, int len, int end) {

		if (len == end) {
			operation.add(combination);
			return;
		}
		generateOperatorCombination(operation, combination + "+", len + 1, end);
		generateOperatorCombination(operation, combination + "-", len + 1, end);
		generateOperatorCombination(operation, combination + "*", len + 1, end);
		generateOperatorCombination(operation, combination + "/", len + 1, end);
	}

	private static void findPermutation(int start, int end, ArrayList<String> result, int arr[]) {

		if (start >= end) {
			String tempArray = "";
			for (int i : arr)
				tempArray += String.valueOf(i);
			result.add(tempArray);
			return;
		}
		for (int i = start; i < end; i++) {
			swap(i, start, arr);
			findPermutation(start + 1, end, result, arr);
			swap(i, start, arr);
		}
	}

	private static void swap(int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
