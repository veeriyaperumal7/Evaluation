package com.veeriyaperumal.rajeesanproblem.date09_02_2024;

import java.util.Scanner;

/*
 * Given a sorted array of n integers that has been rotated an unknown number of times,
design and implement an O(log n) algorithm that finds an element in the array. You may
assume that the array was originally sorted in increasing order.
Input: Arr = [15,16,19,20,25,1,3,4,5,7,10,14], K=5
Output: 8(index of 5)
Return -1 if the element is not present.
 */

public class BinarySearchInRotatedArray {
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.println("Enter the length of the array : ");
		int len = read.nextInt();
		int arr[] = new int[len];
		System.out.println("Enter the array elements one by one : ");
		for (int i = 0; i < len; i++) {
			arr[i] = read.nextInt();
		}
		System.out.println("Enter the target : ");
		int target = read.nextInt();
		System.out.println("The taget present in the index is : "+ search(arr,target));
	}

	private static int search(int[] arr, int target) {
		int left=0,right=arr.length-1,mid=0;
		
		while(left<=right) {
			mid=(right-left)/2+left;
			if(arr[mid]==target) {
				return mid;
			}
			if(arr[left]<=arr[mid]) {
				if(target<=arr[mid] && target>=arr[left]) {
					right=mid-1;
				}else {
					left=mid+1;
				}
			}else {
				if(target>=arr[mid] && target<=arr[right]) {
					left=mid+1;
				}else {
					right=mid-1;
				}
			}
		}
		
		return -1;
	}
}
