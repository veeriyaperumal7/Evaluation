package com.veeriyaperumal.rajeesanproblem;

import java.util.ArrayList;

/*
 * Problem statement
There is an integer array ‘A’ of size ‘N’.



Number of inversions in an array can be defined as the number of pairs of ‘i’, ‘j’ such that ‘i’ < ‘j’ and ‘A[i]’ > ‘A[j]’.

You must return the number of inversions in the array.



For example,
Input:
A = [5, 3, 2, 1, 4], N = 5
Output:
7
Explanation: 
The pairs satisfying the condition for inversion are (1, 2), (1, 3), (1, 4), (1, 5), (2, 3), (2, 4), and (3, 4). 
The number of inversions in the array is 7.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1:
4
4 3 2 1
Sample Output 1:
6
Explanation Of Sample Input 1:
Input:
A = [4, 3, 2, 1], N = 4
Output:
6
Explanation: 
The pairs satisfying the condition for inversion are (1, 2), (1, 3), (1, 4), (2, 3), (2, 4), and (3, 4).    
The number of inversions in the array is 6.
Sample Input 2:
5
1 20 6 4 5
Sample Output 2:
5
Constraints:
1 <= N <= 10^5
1 <= A[i] <= 10^9
Time Limit: 1 sec
 */

public class CountInversionInArray {

	public static void main(String[] args) {
		System.out.println("The inversion count in array is : "+numberOfInversions(new int[] {4,3,2,1}, 4));
	}
	
	public static int numberOfInversions(int[] a, int n) {
		return mergeSort(0, n - 1, a);
	}

	private static int mergeSort(int start, int end, int[] a) {
		int count = 0;
		if (start >= end) {
			return count;
		}
		int mid = (end - start) / 2 + start;
		count += mergeSort(start, mid, a);
		count += mergeSort(mid + 1, end, a);
		return count += merge(start, mid, end, a);

	}

	private static int merge(int start, int mid, int end, int a[]) {
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		int j = mid + 1, count = 0, i = start;
		while (i <= mid && j <= end) {
			if (a[i] <= a[j]) {
				tempList.add(a[i++]);
			} else {
				count += mid - i + 1;
				tempList.add(a[j++]);
			}
		}
		while (i <= mid) {
			tempList.add(a[i++]);
		}
		while (j <= end) {
			tempList.add(a[j++]);
		}
		for (int val : tempList) {
			a[start++] = val;
		}
		return count;
	}

}
