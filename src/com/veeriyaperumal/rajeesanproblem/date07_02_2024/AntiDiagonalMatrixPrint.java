package com.veeriyaperumal.rajeesanproblem.date07_02_2024;

import java.util.ArrayList;
import java.util.List;

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
		int row = mat.length, col = mat[0].length;
		ArrayList<ArrayList<Integer>> res = new ArrayList();

		for (int i = 0; i < row * 2 - 1; i++) {
			res.add(new ArrayList<>());
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				res.get(i + j).add(mat[i][j]);
			}
		}

		System.out.println("[");
		for (ArrayList<Integer> list : res) {
			System.out.println(list);
		}

		System.out.print("]");
	}

}
