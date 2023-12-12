package com.veeriyaperumal.assesment2;

import java.util.Scanner;

public class SearchInMatrix {
	private String str;
	private String searchString;
	private int column;
	private static Scanner read = new Scanner(System.in);

	public SearchInMatrix(String str) {
		this.str = str;
	}

	/*tha
	 * nks
	 * for
	 * the
	 * int
*/
	
	private void search() {
		int startRow = 0, startColumn = 0, endRow = 0, endColumn = 0;
		boolean isFound = false;
		for (int i = 0; i < str.length(); i++) {
			if (searchString.charAt(0) == str.charAt(i)) {
				int j = 0;
				while (i + j < str.length() && j < searchString.length()) { // Horizontal Check.
					if (searchString.charAt(j) != str.charAt(i + j)) {
						break;
					}
					j++;
				}
				if (j == searchString.length()) {
					isFound = true;
					startRow = i / column;
					startColumn = i % column;
					endRow = (i + searchString.length() - 1) / column;
					endColumn = (i + searchString.length() - 1) % column;
					break;
				}
				int verticalCount = 0;
				j = i;
				while (j < str.length() && verticalCount < searchString.length()) {// Vertical Check.
					if (searchString.charAt(verticalCount) != str.charAt(j)) {
						break;
					}
					j += column;
					verticalCount++;
				}

				if (verticalCount == searchString.length()) {
					isFound = true;
					startRow = i / column;
					startColumn = i % column;
					endRow = j / column;
					endRow--;
					endColumn = j % column;
					break;
				}

			}
		}
		if (isFound) {
			System.out.println("Start row index = " + startRow + "\nStart column index = " + (startColumn));
			System.out.println("End row index = " + endRow + "\nEnd column index = " + (endColumn));
		} else {
			System.out.println("Given string not found.");
		}
	}

	public static void main(String[] args) {
		System.out.print("Enter the string : ");
		SearchInMatrix obj = new SearchInMatrix(read.nextLine());
		System.out.print("Enter the search string : ");
		obj.searchString = read.nextLine();
		System.out.print("Enter the column length : ");
		obj.column = read.nextInt();
		obj.search();
	}

}
