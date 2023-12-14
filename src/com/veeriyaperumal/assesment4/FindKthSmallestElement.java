package com.veeriyaperumal.assesment4;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindKthSmallestElement {
	public static Scanner read = new Scanner(System.in);
	int arr[];

	public FindKthSmallestElement(int length) {
		arr = new int[length];
	}

	private void getInput(int n) {
		System.out.print("Enter the array elements one by one : ");
		for (int i = 0; i < n; i++) {
			arr[i] = read.nextInt();
		}
	}

	public static void main(String[] args) {
		System.out.print("Enter how many elements in an array : ");
		int n = read.nextInt(), k = 0;
		FindKthSmallestElement obj = new FindKthSmallestElement(n);
		obj.getInput(n);
		System.out.print("Enter the Kth number : ");
		k = read.nextInt();
		obj.printKthElement(k);
	}

	private void printKthElement(int k) {
		Arrays.sort(arr);
		k--;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] == arr[i]) {
				continue;
			} else {
				k--;
				if (k == 0) {
					System.out.print("The Kth smallest element is : " + arr[i]);
					return;
				}
			}
		}
		System.out.print("Your Kth smallest value is not present.Give the valid Kth element.");

	}
}
