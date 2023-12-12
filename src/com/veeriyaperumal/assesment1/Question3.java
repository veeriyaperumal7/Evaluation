package com.veeriyaperumal.assesment1;

import java.util.Scanner;
import java.util.Stack;

public class Question3 {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.print("Enter the number : ");
		String  equation=read.nextLine();
        if(isValidEquation(equation) && isValidParenthesis(equation)) {
        	System.out.print("Valid");
        }else {
        	System.out.print("Invalid");
        }
	}

	public static boolean isValidParenthesis(String equation) {
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<equation.length();i++) {
			if(equation.charAt(i)=='(') {
				stack.push(equation.charAt(i));
			}else if(equation.charAt(i)==')') {
				if(stack.isEmpty()) {
					return false;
				}else {
					stack.pop();
				}
			}
		}
		return (stack.isEmpty())?true : false;
	}

	public static boolean isValidEquation(String equation) {
		equation=equation.toLowerCase();
		for(int i=0;i<equation.length();i++) {
			char c=equation.charAt(i);
			if(c=='+'||c=='-'||c=='/'||c=='%'||c=='*') {
				if(i-1<0 || i+1>=equation.length()) {
					return false;
				}else if(equation.charAt(i-1)==')' && equation.charAt(i+1)=='(') {
					 continue;
				}else if(equation.charAt(i-1)<'a' || equation.charAt(i-1)>'z' ||
						equation.charAt(i+1)<'a' || equation.charAt(i+1)>'z' )  {
					return false;
				}
			}
		}
		return true;
	}

}
