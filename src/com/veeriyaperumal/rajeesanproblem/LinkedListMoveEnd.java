package com.veeriyaperumal.rajeesanproblem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 3. Give a Singly Linked List, write a program to delete the last element and move K-th last
element to last position. Your solution must be in O(n) time complexity.
Example :
Input: 7 -> 16 -> 100 -> 33 -> 21-> 9 -> 63 -> 11 -> 49 -> 199 -> 59 and K= 5
Output: 7 -> 16 -> 100 -> 33 -> 21 -> 9 -> 11 -> 49 -> 199 -> 63
Element 63 is the 5th element from the last and its moved to last position and 59 is deleted
which was the last element previously.
 */

public class LinkedListMoveEnd {
	class Node {
		int value;
		Node next;

		public Node() {

		}

		public Node(int value, Node node) {
			node.next = this;
			this.value = value;
		}
	}

	public static void main(String[] args) {
		LinkedListMoveEnd obj = new LinkedListMoveEnd();
		Node head = obj.new Node();
		Scanner read = new Scanner(System.in);
		System.out.print("Enter the how many values in the linked list : ");
		int n = read.nextInt();
		Node temp = head;
		while (n > 0) {
			Node newNode = obj.new Node(read.nextInt(), temp);
			temp = newNode;
			n--;
		}
		System.out.print("Enter the kth number : ");
		int k = read.nextInt();
		head = head.next;
		temp = head;
		obj.moveKthNode(temp, k);
		while (head != null) {
			System.out.print(head.value + "->");
			head = head.next;
		}

	}

	private void moveKthNode(Node head, int k) {
		Node lastNode = head;

		while (k > 0) {
			lastNode = lastNode.next;
			k--;
		}
		while (lastNode.next.next != null) {
			head = head.next;
			lastNode = lastNode.next;
		}
		Node temp = head.next.next;
		head.next.next = head.next.next.next;
		temp.next = null;
		lastNode.next = temp;

	}
}