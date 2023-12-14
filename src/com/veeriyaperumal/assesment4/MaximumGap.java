package com.veeriyaperumal.assesment4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MaximumGap {

	private static Scanner read = new Scanner(System.in);

	public static void main(String[] args) {
		int n;
		int arr[];
		System.out.print("Enter the length of  the array : ");
		n = read.nextInt();
		if (n == 1) {
			System.out.print("0");
			return;
		}
		arr = new int[n];
		MaximumGap obj = new MaximumGap();
		obj.getArrayInput(arr, n);

		System.out.println("The maximum gap for the give array is : " + obj.getMaximumGap(arr));
	}

	private int getMaximumGap(int[] arr) {
		Arrays.sort(arr);
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < arr.length; i++) {
			max = Math.max(max, arr[i] - arr[i - 1]);
		}
		return max;
	}

	private void getArrayInput(int[] arr, int length) {
		System.out.print("Enter the array elements one by one : ");
		for (int i = 0; i < length; i++) {
			arr[i] = read.nextInt();
		}
	}
}
