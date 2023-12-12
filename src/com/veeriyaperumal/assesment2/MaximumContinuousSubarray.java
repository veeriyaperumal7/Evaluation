package com.veeriyaperumal.assesment2;

import java.util.Scanner;

public class MaximumContinuousSubarray {
	static Scanner read = new Scanner(System.in);
	int arr[];

	public MaximumContinuousSubarray(int length) {
		arr = new int[length];
	}

	private void getArrayInput() {
		System.out.print("Enter the array : ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = read.nextInt();
		}
	}

	private void getMaximumContinuousSubarray() {
		int max = Integer.MIN_VALUE, tempMax = 0, start = -1, end = -1, negativeCount = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				negativeCount++;
			}
			max = Math.max(max, arr[i]);
		}
		if (negativeCount == arr.length) {
			System.out.print("Maximum subarray is : " + max);
			return;
		}
		max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			tempMax += arr[i];
			if (tempMax < 0) {
				start = i;
				tempMax = 0;
			} else if (tempMax > max) {
				max = tempMax;
				end = i;
			}
		}
		if (tempMax > max) {
			end = arr.length - 1;
		}
		System.out.print("Maximum subarray is : ");

		if (start >= end) {
			System.out.print(arr[end]);
		} else {
			start++;
			while (start <= end) {
				System.out.print(arr[start++] + ",");
			}
		}
	}

	public static void main(String[] args) {

		System.out.print("Enter the length of the array : ");
		MaximumContinuousSubarray obj = new MaximumContinuousSubarray(read.nextInt());
		obj.getArrayInput();
		obj.getMaximumContinuousSubarray();
	}

}
