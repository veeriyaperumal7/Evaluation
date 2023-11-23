package evaluation.assesment1;

import java.util.Scanner;

public class Question1 {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.print("Enter the number : ");
		int number = read.nextInt();
		int[][] pattern = new int[number][number];
		fillPattern(pattern, number);
		for (int[] arr : pattern) {
			for (int i : arr) {
				if (i != 0) {
					if (i > 9) {
						System.out.print(i + " ");
					} else {
						System.out.print(i + "  ");
					}
				} else {
					System.out.print("   ");
				}
			}
			System.out.println();
		}
	}

	private static void fillPattern(int[][] pattern, int number) {
		int startRow = 0, endRow = number - 1, startColumn = 0, endColumn = number - 1, num = 1, rotationCounter = 0;
		while (startRow <= endRow || startColumn <= endColumn) {
			for (int i = startRow; i <= endRow; i++) {
				pattern[i][startColumn + i] = num++;
			}
			startColumn++;
			endRow--;
			for (int i = endRow; i > startRow; i--) {
				pattern[i][endColumn] = num++;
			}
			for (int i = endColumn; i >= startColumn + rotationCounter; i--) {
				pattern[startRow][i] = num++;
			}
			endColumn--;
			startRow++;
			endRow--;
			rotationCounter++;// Rotation counter used to avoid overlapping one previous values.
		}
	}
}