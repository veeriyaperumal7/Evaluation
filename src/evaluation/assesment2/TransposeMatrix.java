package evaluation.assesment2;

import java.util.Scanner;

public class TransposeMatrix {
	private int matrix[][];
	private static Scanner read = new Scanner(System.in);

	public TransposeMatrix(int size) {
		matrix = new int[size][size];
	}

	private void getMatrixInput() {
		System.out.println("Enter the input one by one : ");
		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix.length; column++) {
				System.out.print("Matrix[" + "" + (row + 1) + "][" + (column + 1) + "] = ");
				matrix[row][column] = read.nextInt();
			}
		}

	}

	private void doTranspose() {
		int row = 0, col = 0;
		while (row < matrix.length) {
			for (int i = row; i < matrix.length; i++) {
				int temp = matrix[i][col];
				matrix[i][col] = matrix[col][i];
				matrix[col][i] = temp;
			}
			row++;
			col++;
		}
	}

	private void printMatrix() {
		System.out.println("The transpose matrix of given matrix is : ");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		System.out.print("Enter the size : ");
		TransposeMatrix obj = new TransposeMatrix(read.nextInt());
		obj.getMatrixInput();
		obj.doTranspose();
		obj.printMatrix();
	}

}
