package com.veeriyaperumal.rajeesanproblem;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class DecodeString {
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.print("Enter the string : ");
		String str = read.nextLine();
		System.out.print("Decoded string is : " + Arrays.toString(decode(str)));
	}

	private static int[] decode(String str) {
		int num = 1, j = 0, i = 0;
		int arr[] = new int[str.length() + 1];
		Stack<Integer> stack = new Stack<>();

		while (i < str.length()) {
			if (str.charAt(i) == 'I') {
				if (stack.isEmpty()) {
					arr[j++] = num++;
				} else {
					arr[j++] = num++;
					while (!stack.isEmpty()) {
						arr[j++] = stack.pop();
					}
				}
			} else {
				stack.push(num++);
			}
			i++;
		}
		if (stack.isEmpty()) {
			arr[j] = num++;
		} else {
			arr[j++] = num++;
			while (!stack.isEmpty()) {
				arr[j++] = stack.pop();
			}
		}
		return arr;
	}
}
