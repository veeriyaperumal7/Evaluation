package com.veeriyaperumal.rajeesanproblem;

import java.util.Scanner;

/*
 * 4. Given a sorted array of n integers that has been rotated an unknown number of times,
design and implement an O(log n) algorithm that finds an element in the array. You may
assume that the array was originally sorted in increasing order.
Input: Arr = [15,16,19,20,25,1,3,4,5,7,10,14], K=5
Output: 8(index of 5)
Return -1 if the element is not present.
Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}, key = 3
Output : 8
Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}, key = 30
Output : -1
 */

public class BinarySearchInRotatedArray {

	public static void main(String[] args) {

		Scanner read = new Scanner(System.in);
		int arr[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		System.out.print("Enter the key value : ");
		int key = read.nextInt();
		System.out.println("The index of key value is : " + search(0, arr.length - 1, arr, key));
	}

	private static int search(int start, int end, int[] arr, int key) {
	    if (start > end) {
	        return -1;
	    }
	    int mid = (end - start) / 2 + start;
	    if (arr[mid] == key) {
	        return mid;
	    }
	    
	    if (arr[start] <= arr[mid]) {
	        if (arr[start] <= key && key < arr[mid]) {
	            return search(start, mid - 1, arr, key);
	        } else {
	            return search(mid + 1, end, arr, key);
	        }
	    } else {
	        if (arr[mid] < key && key <= arr[end]) {
	            return search(mid + 1, end, arr, key);
	        } else {
	            return search(start, mid - 1, arr, key);
	        }
	    }
	}


}