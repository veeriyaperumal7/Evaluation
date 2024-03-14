package com.veeriyaperumal.rajeesanproblem.date09_02_2024;

import java.util.Scanner;

/*
 * 2. Write a program to print all the LEADERS in the array. An element is leader if it is
greater than all the elements to its right side. And the rightmost element is always a
leader.
x
Example :
Input: {16, 17, 4, 3, 5, 2}
Output: 17, 5 and 2
 * 
 */

public class LeadersInArray {
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.println("Enter the length of the array : ");
		int len = read.nextInt();
		int arr[] = new int[len];
		System.out.println("Enter the array elements one by one : ");
		for (int i = 0; i < len; i++) {
			arr[i] = read.nextInt();
		}
		printLeaders(arr);
	}

	private static void printLeaders(int[] arr) {
		int max = arr[arr.length - 1];
		System.out.print("The leaders in the array is : " + max);
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] > max) {
				max = arr[i];
				System.out.print(arr[i] + ",");
			}
		}

	}
}
