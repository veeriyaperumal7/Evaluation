package com.veeriyaperumal.assesment4;

import java.util.Scanner;
import java.util.ArrayList;

public class PersonCount {
	ArrayList<Person> list = new ArrayList<>();

	class Person {
		String name;
		int fromYear;
		int toYear;

		public Person(String name, int fromYear, int toYear) {
			this.name = name;
			this.fromYear = fromYear;
			this.toYear = toYear;
		}
	}

	private static Scanner read = new Scanner(System.in);

	public static void main(String[] args) {
		boolean flag = false;
		int n;
		PersonCount obj = new PersonCount();

		do {
			System.out.println("1->Add people");
			System.out.println("2->Show alive people");
			System.out.println("3->Exit");
			n = read.nextInt();
			read.nextLine();
			switch (n) {
			case 1:
				obj.addPeople();
				break;
			case 2:
				obj.showAlivePeople();
				break;
			}

		} while (n != 3);
	}

	private void showAlivePeople() {
		int toYear;
		boolean flag = false;
		System.out.print("Enter the to year : ");
		toYear = read.nextInt();
		
		for (Person p : list) {
			if (p.toYear >= toYear) {
				flag = true;
				System.out.println(p.name);
			}
		}
		if (!flag) {
			System.out.println("There is no person alive on the give year.");
		}

	}

	private void addPeople() {
		String name = "";
		int fromYear, toYear;
		
		System.out.print("Enter the name : ");
	
		name = read.nextLine();
		System.out.print("Enter the from year : ");
		fromYear = read.nextInt();
		System.out.print("Enter the to year : ");
		toYear = read.nextInt();
		list.add(new Person(name, fromYear, toYear));
		System.out.println("Person added successfully.");
	}

}
