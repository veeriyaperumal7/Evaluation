package com.veeriyaperumal.rajeesanproblem.date07_02_2024;

/*
 * Given a N*N square matrix, return an array of its anti-diagonals.
Look at the example for more details.
Example
Input:
1 2 3
4 5 6
7 8 9
Return the following :
[
[1],
[2, 4],
[3, 5, 7],
[6, 8],
[9]
]
Input :
1 2
3 4
Return the following :
[
[1],
[2, 3],
[4]
]
 */

public class AntiDiagonalMatrixPrint {

	public static void main(String[] args) {
		int mat[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		// int mat[][] = { { 1, 2}, { 3, 4}};
		int row = 0, col = 0;
		for (int i = 0; i < mat[0].length; i++) {
			row = 0;
			col = i;
			while (col >= 0) {
				System.out.print(mat[row++][col--] + " ");
			}
			System.out.println();
		}
		row = 1;
		col = mat[0].length - 1;
		while (row < mat.length) {
			for (int i = 0; row + i < mat.length; i++) {
				System.out.print(mat[row + i][col - i] + " ");
			}
			System.out.println();
			row++;
		}
	}

}
