package com.veeriyaperumal.rajeesanproblem;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class SudokuSolver {

	public static void main(String[] args) throws InterruptedException {

		char[][] board = {
				// 1 2 3 4 5 6 7 8 9
				{ '5', '3', '.', '.', '7', '.', '.', '.', '.' }, { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' }, { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' }, { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' }, { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		char[][] board2 = {
				// 1 2 3 4 5 6 7 8 9
				{ '5', '3', '.', '.', '7', '.', '.', '.', '.' }, { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' }, { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' }, { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' }, { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		solve(board, 0, 0);
		System.out.println("Output : ");
		for (char arr[] : board) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println("\n");
		}
		withOutRecursion(board2);
	}

	private static void withOutRecursion(char[][] board) {
		List<Pojo> fillAblePortion = new ArrayList();
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				if (board[row][col] == '.') {
					fillAblePortion.add(new Pojo(row, col, '0'));
				}
			}
		}

		int index = 0;
		boolean flag = false;
		int r = fillAblePortion.get(index).row;
		int c = fillAblePortion.get(index).col;
		char n = fillAblePortion.get(index).num;
		n++;
		while (index < fillAblePortion.size()) {
			
			for (char num = n; num <= '9'; num++) {
				if (isValid((char) num, r, c, board)) {
					board[r][c] = num;
					flag = true;
					break;
				}
			}
			if (flag) {
				fillAblePortion.get(index).num=board[r][c];
				index++;
				if(index>=fillAblePortion.size()) break;
				r = fillAblePortion.get(index).row;
				c = fillAblePortion.get(index).col;
				n = fillAblePortion.get(index).num;
				n++;
			} else {
				board[r][c] = '.';
				fillAblePortion.get(index).num='0';
				index--;
				r = fillAblePortion.get(index).row;
				c = fillAblePortion.get(index).col;
				n = fillAblePortion.get(index).num;
				n++;
			}
			flag = false;
		}

		System.out.println("Output : ");
		for (char arr[] : board) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println("\n");
		}

	}

	private static boolean solve(char[][] board, int row, int col) {
		if (col == board[0].length) {
			col = 0;
			row++;
		}
		if (row >= board.length) {
			return true;
		}

		if (board[row][col] == '.') {
			for (char num = '1'; num <= '9'; num++) {
				if (isValid((char) num, row, col, board)) {
					board[row][col] = num;
					if (solve(board, row, col + 1)) {
						return true;
					}
					board[row][col] = '.';
				}
			}
			return false;
		}
		return solve(board, row, col + 1);
	}

	private static boolean isValid(char num, int row, int col, char[][] board) {
		int startRow = (row / 3) * 3, startCol = (col / 3) * 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[startRow + i][startCol + j] == num)
					return false;
			}
		}
		for (int i = 0; i < board.length; i++) {
			if (board[i][col] == num) {
				return false;
			}
			if (board[row][i] == num) {
				return false;
			}
		}
		return true;
	}

}

class Pojo {
	int row, col;
	char num;

	public Pojo(int row, int col, char num) {
		this.row = row;
		this.col = col;
		this.num = num;
	}
}
