package com.veeriyaperumal.assesment3;

import java.util.Arrays;

//int matrix[][]=
     //  {{2,0,9, 0,0,0, 6,0,0},
//        {0,4,0, 8,7,0, 0,1,2},
//        {8,0,0, 0,1,9, 0,4,0},
//        
//        {0,3,0, 7,0,0, 8,0,1},
//        {0,6,5, 0,0,8, 0,3,0},
//        {1,0,0, 0,3,0, 0,0,7},
//        
//        {0,0,0, 6,5,0, 7,0,9},
//        {6,0,4, 0,0,0, 0,2,0},
//        {0,8,0, 3,0,1, 4,5,0}};
//
//[2, 3, 9, 4, 1, 5, 6, 7, 0]
//[0, 4, 3, 8, 7, 5, 0, 1, 2]
//[8, 6, 2, 5, 1, 9, 3, 4, 7]
//[0, 3, 0, 7, 2, 4, 8, 5, 1]
//[0, 6, 5, 9, 1, 8, 2, 3, 7]
//[1, 6, 0, 9, 3, 2, 4, 5, 7]
//[8, 0, 0, 6, 5, 0, 7, 1, 9]
//[6, 9, 4, 0, 0, 8, 3, 2, 7]
//[0, 8, 0, 3, 0, 1, 4, 5, 2]

/*
[2, 3, 9, 4, 1, 5, 6, 7, 0]
[0, 4, 3, 8, 7, 5, 0, 1, 2]
[8, 6, 2, 5, 1, 9, 3, 4, 7]
[0, 3, 0, 7, 2, 4, 8, 5, 1]
[0, 6, 5, 9, 1, 8, 2, 3, 7]
[1, 6, 0, 9, 3, 2, 4, 5, 7]
[8, 0, 0, 6, 5, 0, 7, 1, 9]
[6, 9, 4, 0, 0, 8, 3, 2, 7]
[0, 8, 0, 3, 0, 1, 4, 5, 2]
 */

public class SudokuSolver {

	public static void main(String[] args) {int matrix[][] = { 
			    { 2, 1, 9, 0, 4, 3, 6, 0, 0 }, 
				{ 5, 4, 3, 8, 7, 0, 0, 1, 2 },
				{ 8, 7, 6, 2, 1, 9, 0, 4, 0 },
				{ 4, 3, 2, 7, 6, 5, 8, 9, 1 }, 
				{ 0, 6, 5, 0, 0, 8, 0, 3, 0 }, 
				{ 1, 0, 0, 0, 3, 0, 0, 0, 7 },
				{ 3, 2, 1, 6, 5, 0, 7, 0, 9 }, 
				{ 6, 5, 4, 9, 8, 7, 0, 2, 0 }, 
				{ 9, 8, 7, 3, 0, 1, 4, 5, 0 } };
		SudokuSolver obj = new SudokuSolver();
		printMatrix(matrix);
		obj.solve(0, 0, matrix);
		printMatrix(matrix);

	}

	private static void printMatrix(int matrix[][]) {
		for (int arr[] : matrix) {
			System.out.println(Arrays.toString(arr));
		}
		System.out.println();
	}

	private void solve(int row, int col, int matrix[][]) {

		if (row == 9) {
			return;
		}
		if (matrix[row][col] != 0) {
			if (col == 8) {
				solve(row + 1, 0, matrix);
			} else {
				solve(row, col + 1, matrix);
			}
		} else {
			System.out.println("row=" + row + "col=" + col);

			for (int i = 1; i <= 9; i++) {
				if (isValid(row, col, matrix, i)) {
					matrix[row][col] = i;

					if (col == 8) {
						solve(row + 1, 0, matrix);
						//matrix[row][col] = 0;
					} else {
						solve(row, col + 1, matrix);
						//matrix[row][col] = 0;
					}

				}
			}
			if (col == 8) {
				solve(row + 1, 0, matrix);
				matrix[row][col] = 0;
			} else {
				solve(row, col + 1, matrix);
				matrix[row][col] = 0;
			}
		}
	}

	private boolean isValid(int row, int col, int[][] matrix, int number) {

		for (int i = 0; i < matrix.length; i++) {
			if (matrix[row][i] == number || matrix[col][i] == number) {
				return false;
			}
		}
		int tempRow=(row>=0 && row<=2)?0:(row>=3 && row<=5)?3:6;
		
		if(col>=0 && col<=2) {
			for(int i=tempRow;i<tempRow+3;i++) {
				for(int j=0;j<3;j++) {
					if (matrix[i][j] == number ) {
						return false;
					}
				}
			}
		}else if(col>=3&& col<=5) {
			for(int i=tempRow;i<tempRow+3;i++) {
				for(int j=3;j<6;j++) {
					if (matrix[i][j] == number ) {
						return false;
					}
				}
			}
		}else {
			for(int i=tempRow;i<tempRow+3;i++) {
				for(int j=6;j<9;j++) {
					if (matrix[i][j] == number ) {
						return false;
					}
				}
			}
		}

		return true;
	}
}
