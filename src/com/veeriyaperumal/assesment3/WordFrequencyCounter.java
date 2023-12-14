package com.veeriyaperumal.assesment3;

import java.util.Arrays;
import java.util.Scanner;

public class WordFrequencyCounter {
	private static Scanner read = new Scanner(System.in);

	private void printFrequency(String sentence) {
		int spaceCount = 0;

		for (int i = 0; i < sentence.length(); i++) {// Count the space,this is used to find how many words present.
			if (sentence.charAt(i) == ' ') {
				spaceCount++;
			}
		}
		spaceCount++;
		int k = 0;
		String stringArray[] = new String[spaceCount];
		String word = "";
		for (int i = 0; i < sentence.length(); i++) {
			if (sentence.charAt(i) == '.' || sentence.charAt(i) == ',' || sentence.charAt(i) == '!'
					|| sentence.charAt(i) == '\'') {
				continue;
			} else if (sentence.charAt(i) == ' ') {
				stringArray[k] = new String(word);
				word = "";
				k++;
			} else {
				word += sentence.charAt(i);
			}
		}
		stringArray[k] = new String(word);
		String tempArray[] = Arrays.copyOf(stringArray, stringArray.length);// This array is used to count and store the
																			// frequency.

		for (int i = 0; i < tempArray.length; i++) {
			int count = 0;
			for (int j = 0; j < stringArray.length; j++) {
				if (tempArray[i].toLowerCase().equals(stringArray[j].toLowerCase())) {
					stringArray[j] = "|";// Change to '|' because don't need to recount.
					count++;
				}
			}
			tempArray[i] = tempArray[i] + " - " + String.valueOf(count);// Concatenate the frequency value with string.
		}
		System.out.print("Output : ");
		for (String string : tempArray) {
			if (string.charAt(string.length() - 1) == '0') {
				continue;
			}
			System.out.print(string + " ");
		}
	}

	public static void main(String[] args) {
		System.out.print("Enter the string : ");
		WordFrequencyCounter obj = new WordFrequencyCounter();
		String sentence = read.nextLine();
		obj.printFrequency(sentence);
	}
}
