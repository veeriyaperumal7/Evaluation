package com.veeriyaperumal.rajeesanproblem;

public class ZigZagFashion {
	public static void main(String[] args) {
		String str = "WELCOMETOZOHOCORPORATION";
		int row = 8, index = 0, col = 0;
		if (row <= 1) {
			System.out.println(str);
			return;
		}
		char mat[][] = new char[row][str.length() / 2];
		while (index < str.length()) {
			for (int i = 0; i < row && index < str.length(); i++) {
				mat[i][col] = str.charAt(index++);
			}
			col++;
			for (int i = row - 2; i > 0 && index < str.length(); i--) {
				mat[i][col++] = str.charAt(index++);
			}
		}
		for (char arr[] : mat) {
			for (char c : arr) {
				System.out.print(c + " ");
			}
			System.out.println();
		}
	}
}
