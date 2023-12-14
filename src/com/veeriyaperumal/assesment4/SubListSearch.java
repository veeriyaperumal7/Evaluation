package com.veeriyaperumal.assesment4;

import java.util.Scanner;

public class SubListSearch {

	private static Scanner read = new Scanner(System.in);

	private static void getArrayInput(int arr[], int length) {
		System.out.print("Enter the array elements one by one : ");
		for (int i = 0; i < length; i++) {
			arr[i] = read.nextInt();
		}
	}

	public static void main(String[] args) {
		int[] arr1, arr2;
		int n1, n2;
		SubListSearch obj = new SubListSearch();
		System.out.print("Enter length of the main list : ");
		n1 = read.nextInt();
		arr1 = new int[n1];
		getArrayInput(arr1, n1);
		System.out.print("Enter length of the sub list : ");
		n2 = read.nextInt();
		arr2 = new int[n2];
		getArrayInput(arr2, n2);
		if (isSublist(arr1, arr2)) {
			System.out.println("The given sublist is present in the given list");
		} else {
			System.out.println("The given sublist is not present in the given list");
		}
	}

	private static boolean isSublist(int[] arr1, int[] arr2) {
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] == arr2[0]) {
				int j = 0;
				while (j < arr2.length) {
					if (arr1[j + i] != arr2[j]) {
						break;
					}
					j++;
				}
				if (j == arr2.length) {
					return true;
				}
			}
		}
		return false;
	}

}
