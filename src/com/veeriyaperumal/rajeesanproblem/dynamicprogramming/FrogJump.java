package com.veeriyaperumal.rajeesanproblem.dynamicprogramming;

import java.util.Arrays;

/*
 * Problem statement
There is a frog on the '1st' step of an 'N' stairs long staircase. The frog wants to reach the 'Nth' stair. 'HEIGHT[i]' is the height of the '(i+1)th' stair.If Frog jumps from 'ith' to 'jth' stair, the energy lost in the jump is given by absolute value of ( HEIGHT[i-1] - HEIGHT[j-1] ). If the Frog is on 'ith' staircase, he can jump either to '(i+1)th' stair or to '(i+2)th' stair. Your task is to find the minimum total energy used by the frog to reach from '1st' stair to 'Nth' stair.

For Example
If the given ‘HEIGHT’ array is [10,20,30,10], the answer 20 as the frog can jump from 1st stair to 2nd stair (|20-10| = 10 energy lost) and then a jump from 2nd stair to last stair (|10-20| = 10 energy lost). So, the total energy lost is 20.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 10
1 <= N <= 100000.
1 <= HEIGHTS[i] <= 1000 .

Time limit: 1 sec
Sample Input 1:
2
4
10 20 30 10
3
10 50 10
Sample Output 1:
20
0
Explanation of sample input 1:
For the first test case,
The frog can jump from 1st stair to 2nd stair (|20-10| = 10 energy lost).
Then a jump from the 2nd stair to the last stair (|10-20| = 10 energy lost).
So, the total energy lost is 20 which is the minimum. 
Hence, the answer is 20.

For the second test case:
The frog can jump from 1st stair to 3rd stair (|10-10| = 0 energy lost).
So, the total energy lost is 0 which is the minimum. 
Hence, the answer is 0.
Sample Input 2:
2
8
7 4 4 2 6 6 3 4 
6
4 8 3 10 4 4 
Sample Output 2:
7
2
 */
public class FrogJump {

	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 10 };
		int dp[] = new int[arr.length];
		Arrays.fill(dp, -1);
		bruteApproach(0, arr);
		betterApproach(0, arr, dp);
		spaceOptimizedApproach(arr);

		System.out.println("The minimum energy required : " + optimizedApproach(arr));
	}

	private static int spaceOptimizedApproach(int[] arr) {
		int dp[] = new int[arr.length];

		for (int i = 1; i < arr.length; i++) {
			int left = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);
			int right = Integer.MAX_VALUE;
			if (i > 1)
				right = dp[i - 2] + Math.abs(arr[i] - arr[i - 2]);
			dp[i] = Math.min(left, right);
		}

		return dp[dp.length - 1];
	}

	private static int optimizedApproach(int[] arr) {
		int prev1 = 0, prev2 = 0, current = 0, i = 1;
		while (i < arr.length) {
			int one = prev1 + Math.abs(arr[i] - arr[i - 1]);
			int two = Integer.MAX_VALUE;
			if (i > 1)
				two = prev2 + Math.abs(arr[i] - arr[i - 2]);
			current = Math.min(one, two);
			prev2 = prev1;
			prev1 = current;
			i++;
		}
		return prev1;
	}

	private static int betterApproach(int index, int[] arr, int[] dp) {
		if (index == arr.length - 1) {
			return 0;
		}
		if (dp[index] != -1)
			return dp[index];

		int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
		left = betterApproach(index + 1, arr, dp) + Math.abs(arr[index] - arr[index + 1]);
		if (index + 2 < arr.length)
			right = betterApproach(index + 2, arr, dp) + Math.abs(arr[index] - arr[index + 2]);
		dp[index] = Math.min(left, right);
		return dp[index];

	}

	private static int bruteApproach(int index, int[] arr) {
		if (index == arr.length - 1)
			return 0;
		int oneStep = Integer.MAX_VALUE, twoStep = Integer.MAX_VALUE;
		oneStep = bruteApproach(index + 1, arr) + Math.abs(arr[index] - arr[index + 1]);
		if (index + 2 < arr.length)
			twoStep = bruteApproach(index + 2, arr) + Math.abs(arr[index] - arr[index + 2]);
		return Math.min(oneStep, twoStep);
	}

}
