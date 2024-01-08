package com.veeriyaperumal.rajeesanproblem;

import java.util.Scanner;
import java.util.Stack;

public class PostfixExpressionEvaluation {
	private Scanner read = new Scanner(System.in);

	public static void main(String[] args) {
		String expression;
		System.out.print("Enter the expression : ");
		PostfixExpressionEvaluation obj = new PostfixExpressionEvaluation();
		expression = obj.read.nextLine();
		System.out.print("The value of the given expression is : " + obj.evaluate(expression));
	}

	private int evaluate(String expression) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
				stack.push(expression.charAt(i) - '0');
			} else {
				if (stack.size() < 2) {
					System.out.println("The given expression is invalid.");
					System.exit(0);
				} else {
					int num2 = stack.pop(), num1 = stack.pop();
					switch (expression.charAt(i)) {
					case '+':
						stack.push(num1 + num2);
						break;
					case '-':
						stack.push(num1 - num2);
						break;
					case '*':
						stack.push(num1 * num2);
						break;
					case '/':
						stack.push(num1 / num2);
						break;
					}
				}
			}
		}
		return stack.pop();
	}
}
