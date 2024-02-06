package com.veeriyaperumal.rajeesanproblem.date06_02_2024;

public class DaysCount {
	public static void main(String[] args) {
		String fromDate = "02-01-2001", toDate = "06.02.2024";
		int[] months = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		int fromDay = Integer.parseInt(fromDate.substring(0, 2));
		int fromMonth = Integer.parseInt(fromDate.substring(3, 5));
		int fromYear = Integer.parseInt(fromDate.substring(6, 10));

		int toDay = Integer.parseInt(toDate.substring(0, 2));
		int toMonth = Integer.parseInt(toDate.substring(3, 5));
		int toYear = Integer.parseInt(toDate.substring(6, 10));
		int totalDays = 0;

		for (int i = fromYear + 1; i < toYear; i++) {
			if (isLeapYear(i)) {
				totalDays += 366;
			} else {
				totalDays += 365;
			}
		}

		for (int i = fromMonth + 1; i <= 12; i++) {
			totalDays += months[i];
		}
		totalDays += months[fromMonth] - fromDay+1;
		if (fromMonth <= 2) {
			if (isLeapYear(fromYear)) {
				totalDays += 1;
			}
		}

		for (int i = 1; i < toMonth; i++) {
			totalDays += months[i];
		}

		if (toMonth > 2) {
			if (isLeapYear(fromYear)) {
				totalDays += 1;
			}
		}
		totalDays+=toDay;

		System.out.println(totalDays);

	}

	private static boolean isLeapYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			return true;
		}
		return false;
	}
}
