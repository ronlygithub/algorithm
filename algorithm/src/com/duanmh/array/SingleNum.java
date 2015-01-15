package com.duanmh.array;

/**
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * 
 * @author duanmh
 * 
 */

public class SingleNum {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 1, 2, 3, 4, 4, 5, 5, 8 };
		System.out.println(singleNum(a));
	}

	public static int singleNum(int num[]) {
		if (num == null || num.length == 0) {
			return 0;
		}

		int result = 0;
		for (int i : num) {
			result = result ^ i;
		}
		return result;

	}

}
