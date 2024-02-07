package com.veeriyaperumal.rajeesanproblem.date07_02_2024;

import java.util.Arrays;

public class MoveZerosToEnd {

	public static void main(String[] args) {
		int arr[] = { 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0 };
		int i = 0, j = 0;
		while (j < arr.length) {
			if (arr[j] != 0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
			}
			j++;
		}
		System.out.println(Arrays.toString(arr));
	}

}
