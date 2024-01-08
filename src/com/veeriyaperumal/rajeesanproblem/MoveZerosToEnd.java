package com.veeriyaperumal.rajeesanproblem;

import java.util.Scanner;

public class MoveZerosToEnd {
	private static Scanner read = new Scanner(System.in);

	public static void main(String[] args) {

		int arr[] = { 9,2,0,4,3,0,2,0 };
		moveZeros(arr, arr.length);
		System.out.print("After move zeros to end : ");
		for (int i : arr) {
			System.out.print(i + ",");
		}
	}

	private static void moveZeros(int arr[], int n) {
		int j = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] != 0 ) {
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				j++;
			}
		}

	}
}
