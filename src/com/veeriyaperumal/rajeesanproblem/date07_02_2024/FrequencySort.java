package com.veeriyaperumal.rajeesanproblem.date07_02_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Write a program to sort the given array according to frequency of elements.
Examples :
Input : {2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12}
Output : {3, 3, 3, 3, 2, 2, 2, 12, 12, 4, 5}
Input : {0, 2, 1, -1, 1, 2, 0, 4, -1, 4}
Output : {-1, -1, 0, 0, 1, 1, 2, 2, 4, 4}
Input : { 4, 6, 8, 2, 5, 7, 9 }
Output : { 2, 4, 5, 6, 7, 8, 9 }
 */

public class FrequencySort {

	public static void main(String[] args) {
		int arr[] = { 0, 2, 1, -1, 1, 2, 0, 4, -1, 4 };
		int i = 0;
		Map<Integer, Frequency> map = new HashMap<Integer, Frequency>();
		for (int val : arr) {
			Frequency obj = map.getOrDefault(val, null);
			if (obj == null) {
				obj = new Frequency(val, 1);
				map.put(val, obj);
			} else {
				obj.count++;
			}
		}
		List<Frequency> res = new ArrayList(map.values());
		Collections.sort(res, new Comparator<Frequency>() {
			@Override
			public int compare(Frequency o1, Frequency o2) {
				if (o1.count == o2.count) {
					if (o1.number < o2.number) {
						return -1;
					} else {
						return 1;
					}
				}
				return o2.count - o1.count;
			}
		});
		for (Frequency obj : res) {
			while (obj.count > 0) {
				arr[i++] = obj.number;
				obj.count--;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}

class Frequency {
	int number;
	int count;

	public Frequency(int number, int count) {
		this.number = number;
		this.count = count;
	}

}
