package com.veeriyaperumal.assesment4;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicates {
	public static Scanner read = new Scanner(System.in);
	private ArrayList<Integer> list = new ArrayList();

	public RemoveDuplicates() {
	}

	public static void main(String[] args) {
		System.out.print("Enter how many number given : ");
		int n = read.nextInt();
		RemoveDuplicates obj = new RemoveDuplicates();
		obj.getInput(n);
		System.out.print("Before remove duplicates : ");
		obj.printList();
		obj.removeDuplicate();
		System.out.print("After remove duplicates : ");
		obj.printList();
	}

	private void printList() {
		for (int i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	private void removeDuplicate() { // Approach 1-> while insert use contains
										// Approach 2-> put into hash maps
										// Approach 3-> if range know frequency
										// Using sort
										// For loop approach
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i) == list.get(j)) {
					list.remove(j);
					j--;
				}
			}
		}
	}

	private void getInput(int n) {
		System.out.print("Enter the elements one by one : ");
		for (int i = 0; i < n; i++) {
			list.add(read.nextInt());
		}
	}
}
