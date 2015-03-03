package com.duanmh.array;

import com.duanmh.sort.ShellSort;

/**
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You
 * may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author duanmh
 * 
 */
public class ClosestSum {

	public static void main(String[] args) {
		int[] s = { -1, 2, 1, -4 };
		threeSumClosest(s, 3);
	}

	public static int threeSumClosest(int[] num, int target) {
		if (num == null || num.length == 0) {
			return 0;
		}

		ShellSort shellSort = new ShellSort();
		shellSort.sort(num);

		int result = Math.abs(target - num[0] - num[1] - num[2]);
		int value = num[0] + num[1] + num[2];
		for (int i = 0; i < num.length; i++) {
			int tmp = target - num[i];
			for (int low = 0, high = num.length - 1; low < high;) {
				if (low == i) {
					low++;
				}
				if (high == i) {
					high--;
				}

				int sum = num[low] + num[high];
				int abs = Math.abs(tmp - sum);
				if (tmp - sum > 0) {
					low++;
				} else {
					high--;
				}

				if (low < high && result > abs) {
					result = abs;
					value = sum + num[i];
				}

			}
		}

		return value;
	}

}

