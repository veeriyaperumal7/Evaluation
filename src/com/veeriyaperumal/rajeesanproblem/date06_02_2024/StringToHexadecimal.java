package com.veeriyaperumal.rajeesanproblem.date06_02_2024;

public class StringToHexadecimal {

	public static void main(String[] args) {
		String str = "hello world";
		System.out.print("The hexadecimal string is ");
		for (char c : str.toCharArray()) {
			System.out.print(charToHex(c));
		}

	}

	private static String charToHex(char character) {
		StringBuilder sb = new StringBuilder();
		int decimalValue = character;
		while (decimalValue != 0) {
			int remainder = decimalValue % 16;
			char c = (char) (remainder < 10 ? '0' + remainder : 'a' + remainder - 10);
			sb.insert(0,c);
			decimalValue/=16;
		}
		return sb.toString();
	}
}
