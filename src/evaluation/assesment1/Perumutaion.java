package evaluation.assesment1;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Perumutaion {
	private int arr[];

	public Perumutaion(int n) {
		arr = new int[n];
	}

	private void getArrayInput() {
		Scanner read = new Scanner(System.in);
		System.out.print("Enter the number one by one : ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = read.nextInt();
		}

	}

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.println("Enter the size of a number : ");
		int n = read.nextInt();
		
		ArrayList<int[]> result = new ArrayList<>();
		Perumutaion permutation = new Perumutaion(n);
		permutation.getArrayInput();
		
		permutation.findPermutation(0, permutation.arr.length, result);
		
		System.out.println("Permutation of a number is  : ");
		for (int[] temp : result) {
			System.out.println(Arrays.toString(temp));
		}

	}

	private void findPermutation(int start, int end, ArrayList<int[]> result) {
		if (start >= end) {
			int tempArray[] = Arrays.copyOf(arr, end);
			result.add(tempArray);
			return;
		}
		for (int i = start; i < end; i++) {
			swap(i, start, arr);
			findPermutation(start + 1, end, result);
			swap(i, start, arr);
		}
	}

	private static void swap(int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
