package com.veeriyaperumal.rajeesanproblem.date06_02_2024;

public class PrintValueBetweenXandY {
public static void main(String[] args) {
	int arr[] = {1,2,3,4,5,6,3,8,6,544};
	int x=3,y=8;
	for(int i : arr) {
		if(i>=x && i<=y)
			System.out.print(i+ " ");
	}
}
}
