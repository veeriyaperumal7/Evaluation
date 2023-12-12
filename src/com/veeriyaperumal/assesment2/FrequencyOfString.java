package com.veeriyaperumal.assesment2;

import java.util.Arrays;
import java.util.Scanner;

public class FrequencyOfString {
	private String str;
	private static Scanner read = new Scanner(System.in);

	public FrequencyOfString(String str) {
		this.str = str;
	}

	private void printFrequency() {
		int spaceCount = 0;
		for (int i = 0; i < str.length(); i++) {// Count the how many separate
			if (str.charAt(i) == ' ') {
				spaceCount++;
			}
		}
		spaceCount++;
		int k = 0;
		String stringArray[] = new String[spaceCount];// This space count refers how many letters present in the string
		String temp = "";
		for (int i = 0; i < str.length(); i++) { // Take words and put into arrays.
			if (str.charAt(i) == '.' || str.charAt(i) == ',' || str.charAt(i) == '!' || str.charAt(i) == '!') {
				continue;
			} else if (str.charAt(i) == ' ') {
				stringArray[k] = new String(temp);
				temp = "";
				k++;
			} else {
				temp += str.charAt(i);
			}
		}
		stringArray[k] = new String(temp);
		String tempArray[] = Arrays.copyOf(stringArray, stringArray.length);// For counting purpose.
		for (int i = 0; i < tempArray.length; i++) {
			int count = 0;
			for (int j = 0; j < stringArray.length; j++) {
				if (tempArray[i].equals(stringArray[j])) {
					stringArray[j] = "-";//Change to (-) because don't need to recount.
					count++;
				}
			}
			tempArray[i] = tempArray[i] + "-" + String.valueOf(count);
		}
		sortIntoDescending(tempArray);// Frequency based sorting descending order
		System.out.print("Output : ");
		for (String str : tempArray) {
			if (str.charAt(str.length() - 1) == '0') {
				continue;
			}
			System.out.print(str + " ");
		}
	}

	private void sortIntoDescending(String[] tempArray) {
		for (int i = tempArray.length; i >= 0; i--) {
			for (int j = 1; j < i; j++) {
				if (Integer.parseInt(tempArray[j].substring(tempArray[j].lastIndexOf('-') + 1)) > Integer
						.parseInt(tempArray[j - 1].substring(tempArray[j - 1].lastIndexOf('-') + 1))) {
					String temp = tempArray[j];
					tempArray[j] = tempArray[j - 1];
					tempArray[j - 1] = temp;
				}
			}
		}

	}

	public static void main(String[] args) {
		System.out.print("Enter the string : ");
		FrequencyOfString obj = new FrequencyOfString(read.nextLine());
		obj.printFrequency();

	}

}
