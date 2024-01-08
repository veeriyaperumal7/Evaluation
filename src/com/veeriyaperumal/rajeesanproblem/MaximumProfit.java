package com.veeriyaperumal.rajeesanproblem;

import java.util.Scanner;

public class MaximumProfit {
	private static Scanner read = new Scanner(System.in);

	public static void main(String[] args) {

		int arr[] = { 7,1,5,3,6,4 };

		System.out.print("The maximum profit is : " + getMaximumProfit(arr, arr.length));
	}

	private static int getMaximumProfit(int arr[], int n) {
		int maxPrice = arr[n - 1];
		int profit = 0;
		for (int i = n - 2; i >= 0; i--) {
			if (maxPrice < arr[i]) {
				maxPrice = arr[i];
			} else {
				if (maxPrice - arr[i] > profit) {
					profit = maxPrice - arr[i];
				}
			}
		}
		return profit;
	}
}