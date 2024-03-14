package com.veeriyaperumal.rajeesanproblem.dynamicprogramming;

/*
 * Leetcode -198
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400
 */

public class HouseRobber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = { 2, 7, 9, 3, 1 };
		int dp[] = new int[nums.length];
		System.out.println(findMaxBruteApproach(nums, nums.length - 1));
		System.out.println(findMaxBetterApproach(nums, nums.length - 1, dp));
		System.out.println(findMaxBetterTabulationApproach(nums));
		System.out.println(findMaxOptimalApproach(nums));
	}

	private static int findMaxOptimalApproach(int[] nums) {
		int prev1=nums[0],prev2=0,curr=0;
		for(int i=1;i<nums.length;i++) {
			curr = Math.max(nums[i]+prev2, prev1);
			prev2=prev1;
			prev1=curr;
		}
		return prev1;
	}

	private static int findMaxBetterTabulationApproach(int[] nums) {
		int dp[] = new int[nums.length];
		dp[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int pick = 0, nonPick = 0;
			pick = nums[i];
			if (i - 2 >= 0) pick += dp[i - 2];
			
			nonPick = dp[i - 1];
			dp[i] = Math.max(pick, nonPick);
		}

		return dp[nums.length - 1];
	}

	private static int findMaxBruteApproach(int[] nums, int i) {
		if (i == 0) {

			return nums[0];
		}
		int pick = Integer.MIN_VALUE, notPick = Integer.MIN_VALUE;
		if (i - 2 >= 0)
			pick = nums[i] + findMaxBruteApproach(nums, i - 2);
		notPick = findMaxBruteApproach(nums, i - 1);
		return Math.max(pick, notPick);
	}

	private static int findMaxBetterApproach(int[] nums, int i, int dp[]) {
		if (i == 0) {
			return nums[0];
		}
		if (dp[i] != 0)
			return dp[i];
		int pick = Integer.MIN_VALUE, notPick = Integer.MIN_VALUE;
		if (i - 2 >= 0)
			pick = nums[i] + findMaxBetterApproach(nums, i - 2, dp);
		notPick = findMaxBetterApproach(nums, i - 1, dp);
		return dp[i] = Math.max(pick, notPick);
	}

}
