package com.veeriyaperumal.rajeesanproblem;

/*
 * 1. Given a sorted array arr[] of size N. Find the element that appears only once in the array. All other elements appear exactly twice. 

Example 1:

Input:
N = 11
arr[] = {1, 1, 2, 2, 3, 3, 4, 50, 50, 65, 65}
Output: 4
Explanation: 4 is the only element that 
appears exactly once.

Expected Time Complexity: O(log N)
Expected Auxiliary Space: O(1)

Test cases : 
arr[] = {1, 1, 2, 2, 3, 3, 4, 4, 50, 50, 65, 65, 70, 70, 80, 80, 90, 90, 100}
# The only element that appears exactly once is 100
# Output: 100

arr[] = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 10, 10}
# The only element that appears exactly once is 9
# Output: 9

arr[] = {-10, -8, -8, -6, -6, -4, -4, -2, -2, 0, 0, 2, 2, 4, 4}
# The only element that appears exactly once is -10
# Output: -10



 */

public class UniqueElementInArray {

	public static void main(String[] args) {
		int arr[] = { -10, -8, -8, -6, -6, -4, -4, -2, -2, 0, 0, 2, 2, 4, 4 };

		UniqueElementInArray obj = new UniqueElementInArray();
		System.out.println("The unique element is : " + obj.getUnique(arr));
	}

	private int getUnique(int[] arr) {

		int start = 0, end = arr.length - 1, mid = 0;

		while (start <= end) {
			mid = (end - start) / 2 + start;

			if (mid % 2 == 0) {
				if (mid + 1 < arr.length && arr[mid] == arr[mid + 1]) {
					start = mid + 2;
				} else if (mid - 1 >= 0 && arr[mid] == arr[mid - 1]) {
					end = mid - 2;
				} else {
					break;
				}
			} else {

				if (mid - 1 >= 0 && arr[mid] == arr[mid - 1]) {
					start = mid + 1;
				} else if (mid + 1 < arr.length && arr[mid] == arr[mid + 1]) {
					end = mid - 1;
				} else {
					break;
				}
			}

		}

		return arr[mid];
	}

}
