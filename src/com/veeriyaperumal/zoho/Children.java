package com.veeriyaperumal.zoho;

import java.util.Arrays;

public class Children {
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		int arr[] = { 1,2,3,0,2 };
		int res[] = new int[arr.length];
		Arrays.fill(res,1);
		
		for(int i=1;i<arr.length;i++) {
			if(arr[i]<arr[i-1]) {
				if(res[i-1]<=res[i]) {
					res[i-1]=res[i]+1;
				}
			}else if(arr[i-1]<arr[i]) {
				if(res[i]<=res[i-1]) {
					res[i]=res[i-1]+1;
				}
			}
		}
			
		int temp=0;
		for(int i : res) {
			temp+=i;
		}
		System.out.println(temp);

	}


}
