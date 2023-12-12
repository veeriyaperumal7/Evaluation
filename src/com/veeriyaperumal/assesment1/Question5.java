package com.veeriyaperumal.assesment1;
import java.util.*;
public class Question5 {
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner read = new Scanner(System.in);
        System.out.println("Enter the number of strings to be entered :");
        int n = read.nextInt();
        read.nextLine();
        String[] arr = new String[n];
        for(int i=0;i<n;i++) {
        	System.out.println("Enter the string"+(i+1));
        	arr[i]=read.nextLine();
        }
        for(int i=0;i<n;i++) {
        	System.out.println("String"+(i+1)+": "+makeLargestPossible(arr[i]));
        	
        }
	}
	public static String makeLargestPossible(String s) {
		char[] arr = s.toCharArray();
		s="";
		Arrays.sort(arr);
		for(int i=arr.length-1;i>=0;i--) {
        	s+=arr[i];
        }
		return s;
	}

}
