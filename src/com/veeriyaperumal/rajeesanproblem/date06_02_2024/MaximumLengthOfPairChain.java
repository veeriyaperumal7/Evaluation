package com.veeriyaperumal.rajeesanproblem.date06_02_2024;

import java.util.Arrays;

public class MaximumLengthOfPairChain {
	public static void main(String[] args) {
		int pairs[][] = { { 5, 24 }, { 39, 60 }, { 15, 28 }, { 27, 40 }, { 50, 90 } };
		Arrays.sort(pairs, (a, b) -> {
			return a[0] - b[0];
		});
		int i = 0, j = 1;
		while (j < pairs.length) {
			if (pairs[i][1] >= pairs[j][0]) {
				j++;
			} else {
				i++;
				pairs[i] = pairs[j++];
			}
		}
		for (int k = 0; k <= i; k++) {
			System.out.print(Arrays.toString(pairs[k]) + " ->");
		}

	}
}
