package evaluation.assesment2;

import java.util.Scanner;

public class SearchInMatrix {
	private String str;
	private String searchString;
	private int column;
	private static Scanner read = new Scanner(System.in);

	public SearchInMatrix(String str) {
		this.str = str;
	}

	private void search() {
		column--;
		int startRow = 0, startColumn = 0, endRow = 0, endColumn = 0;
		boolean isFound = false;
		for (int i = 0; i < str.length(); i++) {
			if (startColumn % column == 0 && startColumn!=0) {
				startRow++;
				startColumn = 0;
			} else {
				startColumn++;
			}
			if (str.charAt(i) == searchString.charAt(0)) {
				int len = 1;
				endRow = startRow;
				endColumn = startColumn;
				while (len + i < str.length() && len < searchString.length()) {
					if (str.charAt(len + i) != searchString.charAt(len)) {
						break;
					}
					if ((endColumn) % column == 0) {
						endRow++;
						endColumn = 0;
					} else {
						endColumn++;
					}
					len++;
				}
				if (len == searchString.length()) {
					isFound = true;
					break;
				}
			}
		}
		if (isFound) {
			System.out.println("Start row index = " + startRow + "\nStart column index = " + (startColumn-1));
			System.out.println("End row index = " + endRow + "\nEnd column index = " + (endColumn-1));
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
