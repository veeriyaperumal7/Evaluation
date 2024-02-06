package com.veeriyaperumal.rajeesanproblem;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Leetcode 576
 * There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary). You can apply at most maxMove moves to the ball.

Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it modulo 109 + 7.

 

Example 1:


Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
Output: 6
Example 2:


Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
Output: 12
 

Constraints:

1 <= m, n <= 50
0 <= maxMove <= 50
0 <= startRow < m
0 <= startColumn < n
 */

public class OutOfBoundryPaths {

	public static void main(String[] args) {
		OutOfBoundryPaths solution = new OutOfBoundryPaths();
		int result = solution.findPaths(3, 1, 5, 2, 0);
		System.out.println("Number of paths: " + result);
	}

	public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
		if (maxMove == 0) {
			return 0;
		}
		int count = 0;
		int index = 0;
		int[][] moves = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		ArrayList<ArrayList<int[]>> list = new ArrayList();
		list.add(new ArrayList<int[]>(Arrays.asList(new int[] { startRow, startColumn })));
		while (maxMove > 1) {
			ArrayList<int[]> temp = new ArrayList<>();
//			for (ArrayList<int[]> temp1 : list) {
			ArrayList<int[]> temp1 = list.get(index);
			for (int[] arr : temp1) {
				int row = arr[0];
				int col = arr[1];
				for (int[] move : moves) {
					int newRow = row + move[0];
					int newCol = col + move[1];
					if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
						temp.add(new int[] { newRow, newCol });
					}
				}
				// }
			}
			list.add(temp);
			index++;
			maxMove--;
		}
		for (ArrayList<int[]> temp1 : list) {
			for (int[] arr : temp1) {
				int row = arr[0];
				int col = arr[1];
				if (m == 1) {
					if (col == 0 || col == n - 1) {
						count += 3;
						count %= 1000000007;
					} else {
						count += 2;
						count %= 1000000007;
					}
				} else if (n == 1) {
					if (row == 0 || row == m - 1) {
						count += 3;
						count %= 1000000007;
					} else {
						count += 2;
						count %= 1000000007;
					}
				} else {
					if (row > 0 && row < m - 1) {
						if (col == 0 || col == n - 1) {
							count += 1;
							count %= 1000000007;
						}
					} else if (row == 0 || row == m - 1) {

						if (col == 0 || col == n - 1) {
							count += 2;
							count %= 1000000007;
						} else {
							count += 1;
							count %= 1000000007;
						}
					}
				}
			}
		}
		return count;
	}
}
