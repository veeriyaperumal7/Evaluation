package com.veeriyaperumal.assesment4;

import java.util.Scanner;
import java.util.Stack;

public class EvaluatePostExpression {

	private static Scanner read = new Scanner(System.in);

	public static void main(String[] args) {
		String expression;
		System.out.print("Enter the expression : ");
		expression = read.nextLine();
		EvaluatePostExpression obj = new EvaluatePostExpression();
		System.out.print("The value of the given expression is : " + obj.evaluate(expression));
	}

	private int evaluate(String expression) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) < '0' || expression.charAt(i) > '9') {
				if (stack.size() < 2) {
					System.out.println("Invalid expression.");
					System.exit(0);
				} else {
					int b = stack.pop(), a = stack.pop();
					switch (expression.charAt(i)) {
					case '+':
						stack.push(a + b);
						break;
					case '-':
						stack.push(a - b);
						break;
					case '*':
						stack.push(a * b);
						break;
					case '/':
						stack.push(a / b);
						break;
					}
				}
			} else {
				stack.push(Integer.parseInt(String.valueOf(expression.charAt(i))));
			}
		}
		return stack.pop();
	}

}
