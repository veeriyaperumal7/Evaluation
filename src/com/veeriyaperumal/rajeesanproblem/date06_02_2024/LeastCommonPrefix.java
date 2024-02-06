package com.veeriyaperumal.rajeesanproblem.date06_02_2024;

public class LeastCommonPrefix {
	public static void main(String[] args) {
		String arr[] = { "flower", "flow", "flight" };
		int smallStringIndex = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i].length() < arr[smallStringIndex].length()) {
				smallStringIndex = i;
			}
		}
		int count;
		String res = arr[smallStringIndex];
		while (res.length() > 0) {
			count = 0;
			for (int i = 0; i < arr.length; i++) {
				if (i == smallStringIndex)
					continue;
				else {
					if (arr[i].indexOf(res) != -1) {
						count++;
					} else {
						break;
					}
				}
			}
			if (count == arr.length - 1) {
				break;
			}
			res=res.substring(0,res.length()-1);
		}
		System.out.println("The least common prefix string is : "+res);
	}
}
