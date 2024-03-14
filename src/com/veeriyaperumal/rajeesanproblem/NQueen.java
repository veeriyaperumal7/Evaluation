package com.veeriyaperumal.rajeesanproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen {

	public static void main(String[] args) {

		NQueen obj = new NQueen();
		for (List<String> board : obj.solveNQueens(10)) {
			for (String str : board) {
				System.out.println(str);
			}
			System.out.println("--------------------------");
		}
	}

	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList();
		char[][] chessBoard = new char[n][n];
		for (char arr[] : chessBoard)
			Arrays.fill(arr, '-');
		solveQueens(res, chessBoard, 0, n);
		return res;
	}

	void solveQueens(List<List<String>> res, char[][] chessBoard, int row, int n) {
		if (row == n) {
			ArrayList<String> board = new ArrayList();
			for (char arr[] : chessBoard) {
				board.add(String.valueOf(arr));
			}
			res.add(board);
			return;
		}

		for (int col = 0; col < n; col++) {
			if (isValidMove(row, col, chessBoard, n)) {
				chessBoard[row][col] = 'Q';
				solveQueens(res, chessBoard, row + 1, n);
				chessBoard[row][col] = '-';
			}
		}

	}

	private boolean isValidMove(int row, int col, char[][] chessBoard, int n) {
		for (int i = 0; i < n; i++) {
			if (chessBoard[i][col] == 'Q' || chessBoard[row][i] == 'Q') {
				return false;
			}
		}

		for (int i = 0; i < n; i++) {
			if (row + i < n && col + i < n && chessBoard[row + i][col + i] == 'Q') {
				return false;
			}
			if (row + i < n && col - i >= 0 && chessBoard[row + i][col - i] == 'Q') {
				return false;
			}
			if (row - i >= 0 && col + i < n && chessBoard[row - i][col + i] == 'Q') {
				return false;
			}
			if (row - i >= 0 && col - i >= 0 && chessBoard[row - i][col - i] == 'Q') {
				return false;
			}
		}
		return true;

	}
}
