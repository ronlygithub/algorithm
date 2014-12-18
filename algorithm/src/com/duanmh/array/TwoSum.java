package com.duanmh.array;

import java.util.Arrays;

/**
 * from leetcode
 * 
 * @author duanmh
 * 
 */
public class TwoSum {

	public static void main(String[] args) {
		int a[] = { 3, 2, 4 };
		twoSum(a, 6);
	}

	public static int[] twoSum(int[] numbers, int target) {
		Arrays.sort(numbers);
		int high = numbers.length - 1;
		int low = 0;
		int[] result = new int[2];
		while (low < high) {
			int left = numbers[low];
			int right = numbers[high];
			if (left + right > target) {
				high--;
			} else if (left + right < target) {
				low++;
			} else {
				result[0] = low;
				result[1] = high;
				return result;
			}

		}

		return result;

	}
}
