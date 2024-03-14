package com.veeriyaperumal.rajeesanproblem;

import java.util.ArrayList;
import java.util.Stack;

public class StringDecoding {
	ArrayList<Integer> arr = new ArrayList<>();

	public static void main(String args[]) {
		System.out.println(decodeStringByUsingStack("3[a2[c]]"));
	}
	
	public static String decodeString(String s) {
		int[] numStack = new int[s.length()];
		String[] stringStack = new String[s.length()];
		String res = "";
		int numStackIndex = 0, stringStackIndex = 0, n = 0, index = 0;
		while (index < s.length()) {
			char c = s.charAt(index++);
			if (c >= '0' && c <= '9') {
				n = n * 10 + (c - '0');
			} else if (c == '[') {
				numStack[numStackIndex++] = n;
				n = 0;
				stringStack[stringStackIndex++] = res;
				res = "";
			} else if (c == ']') {
				int count = numStack[--numStackIndex];
				String temp = res;
				res = stringStack[--stringStackIndex];
				while (count > 0) {
					res += temp;
					count--;
				}
			} else {
				res += c;
			}
		}
		return res;
	}

	public static String decodeStringByUsingStack(String s) {
		Stack<Integer> st = new Stack<>();
		Stack<StringBuilder> st1 = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int n = 0;

		for (char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				n = n * 10 + (c - '0');
			} else if (c == '[') {
				st.push(n);
				n = 0;
				st1.push(sb);
				sb = new StringBuilder();
			} else if (c == ']') {
				int k = st.pop();
				StringBuilder temp = sb;
				sb = st1.pop();
				while (k-- > 0) {
					sb.append(temp);
				}
			} else {
				sb.append(c);
			}
		}

		return sb.toString();
	}
}