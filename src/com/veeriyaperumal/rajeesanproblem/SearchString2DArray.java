package com.veeriyaperumal.rajeesanproblem;

/*
 * 1. Given a 2D grid of characters, you have to search for all the words in a dictionary by
moving only along two directions, either right or down. Print the word if it occurs.
Sample :
 a z o l
 n x h o
 v y i v
 o r s e
 Dictionary = {van, zoho, love, are, is}
 Output:
 zoho
 love
 Is
 */

public class SearchString2DArray {

	public static void main(String[] args) {
		String[] dictionary = { "van", "zoho", "love", "are", "is" };

		char[][] mat = { { 'a', 'z', 'o', 'l' }, { 'n', 'x', 'h', 'o' }, { 'v', 'y', 'i', 'v' },
				{ 'o', 'r', 's', 'e' } };

		System.out.print("Dictionary word present in the 2D grid : ");
		SearchString2DArray obj = new SearchString2DArray();
		for (String str : dictionary) {
			if (obj.exist(mat, str))
				System.out.print(str + " ");
		}
	}

	public boolean exist(char[][] mat, String word) {
		boolean[][] visited = new boolean[mat.length][mat[0].length];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (word.charAt(0) == mat[i][j] && isFound(mat, word, i, j, visited, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isFound(char[][] mat, String word, int row, int col, boolean[][] visited, int index) {
		if (index == word.length()) {
			return true;
		}
		if (row >= mat.length || col >= mat[0].length || row < 0 || col < 0 || visited[row][col]
				|| word.charAt(index) != mat[row][col]) {
			return false;
		}
		visited[row][col] = true;
		boolean flag = (isFound(mat, word, row + 1, col, visited, index + 1)
				|| isFound(mat, word, row - 1, col, visited, index + 1)
				|| isFound(mat, word, row, col - 1, visited, index + 1)
				|| isFound(mat, word, row, col + 1, visited, index + 1));
		if (!flag) {
			visited[row][col] = false;
		}
		return flag;
	}

}
