package com.veeriyaperumal.assesment3;

import java.util.Scanner;
import java.util.ArrayList;

public class PascalTriangle {
	private static Scanner read = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter how many row needs in pascals triangle : ");
		int n = read.nextInt();
		PascalTriangle obj = new PascalTriangle();
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		obj.generaterPascalTriangle(result, n);
		obj.printPascal(result, n);
	}

	private void printPascal(ArrayList<ArrayList<Integer>> result, int n) {
		for (int i = 0; i < result.size(); i++) {
			for (int space = 0; space < (n - 1) - i; space++) {
				System.out.print("  ");
			}
			for (int j = 0; j < result.get(i).size(); j++) {
				System.out.printf("%4d", result.get(i).get(j));
			}
			System.out.println();
		}

	}

	private void generaterPascalTriangle(ArrayList<ArrayList<Integer>> result, int n) {
		int value = 1;
		for (int row = 1; row <= n; row++) {
			value = 1;
			ArrayList<Integer> rowList = new ArrayList<>();
			for (int j = 1; j <= row; j++) {
				rowList.add(value);
				value = value * (row - j) / j;
			}
			result.add(rowList);
		}
	}

}
