package com.veeriyaperumal.assesment4;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class CombinationsOfString {

	public static Scanner read = new Scanner(System.in);
	private String input;

	public CombinationsOfString(String input) {
		this.input = input;
	}

	public static void main(String[] args) {
		System.out.print("Enter the string to find the combinations : ");
		CombinationsOfString obj = new CombinationsOfString(read.nextLine());
		List<String> result = new ArrayList<>();
		obj.generateCombinations(0, result, "");
		obj.printCombinations(result);
	}

	public void printCombinations(List<String> result) {
		for (String temp : result) {
			System.out.println(temp);
		}
	}

	private void generateCombinations(int index, List<String> result, String str) {
		if (index >= input.length()) {
			result.add(new String(str));
			return;
		}
		str += input.charAt(index);
		generateCombinations(index + 1, result, str);
		str = str.substring(0, str.length() - 1);
		generateCombinations(index + 1, result, str);
	}
}
