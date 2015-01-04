package com.leetcode.string;


public class MajorityElement {

	public static void main(String[] args) {
		int[] array = { 6, 5, 5 };
		majorityElement(array);
	}

	public static int majorityElement(int[] num) {
		int count = 1;
		int element = num[0];
		// Arrays.sort(num);
		for (int i = 1; i < num.length; i++) {
			if (num[i] == element) {
				count++;
			} else {
				count--;
			}

			if (count <= 0) {
				element = num[i];
				count = 1;
			}
		}
		return element;

	}
}
