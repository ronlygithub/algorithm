package com.duanmh.array;

import java.util.Hashtable;

/**
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 * 
 * @author duanmh
 * 
 */
public class TwoSum {

	public static void main(String[] args) {
		int a[] = { 0, 2, 3, 0 };
		twoSum(a, 0);
	}

	public static int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();

		for (int i = 0; i < numbers.length; i++) {
			if (table.containsKey(numbers[i])) {
				result[0] = table.get(numbers[i]) + 1;
				result[1] = i + 1;
			}
			table.put(target - numbers[i], i);
		}
		return result;
	}

}
