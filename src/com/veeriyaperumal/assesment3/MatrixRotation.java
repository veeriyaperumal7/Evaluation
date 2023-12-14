package com.veeriyaperumal.assesment3;

import java.util.Scanner;

public class MatrixRotation {
	private int matrix[][];
	private static Scanner read = new Scanner(System.in);

	public MatrixRotation(int size) {
		matrix = new int[size][size];
	}

	private void getMatrixInput() {
		System.out.println("Enter the input one by one : ");
		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix.length; column++) {
				matrix[row][column] = read.nextInt();
			}
		}

	}

	private void rotate90() {
		for (int row = 0, col = 0; row < matrix.length; row++, col++) {
			for (int i = row; i < matrix.length; i++) {
				int temp = matrix[i][col];
				matrix[i][col] = matrix[col][i];
				matrix[col][i] = temp;
			}
		}

		for (int row = 0; row < matrix.length; row++) {
			for (int left = 0, right = matrix[row].length - 1; left < right; left++, right--) {
				int temp = matrix[row][left];
				matrix[row][left] = matrix[row][right];
				matrix[row][right] = temp;
			}
		}
	}

	private void printMatrix() {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		System.out.print("Enter the size : ");
		MatrixRotation obj = new MatrixRotation(read.nextInt());
		obj.getMatrixInput();
		System.out.println("The before 90 degree matrix of given matrix is : ");
		obj.printMatrix();
		obj.rotate90();
		System.out.println("The after 90 degree matrix of given matrix is : ");
		obj.printMatrix();
	}

}
