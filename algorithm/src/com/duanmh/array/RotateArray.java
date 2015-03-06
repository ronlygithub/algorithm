package com.duanmh.array;

/**
 * Rotate an array of n elements to the right by k steps.
 * 
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to
 * [5,6,7,1,2,3,4].
 * 
 * Note: Try to come up as many solutions as you can, there are at least 3
 * different ways to solve this problem.
 * 
 * @author duanmh
 * 
 */
public class RotateArray {

	public void rotate(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k < 0) {
			return;
		}

		if (k > nums.length) {
			k = k % nums.length;
		}

		int end = nums.length - 1;
		rotateArray(nums, 0, nums.length - k - 1);
		rotateArray(nums, end - k + 1, end);
		rotateArray(nums, 0, nums.length - 1);
	}

	private void rotateArray(int[] nums, int start, int end) {
		while (start < end) {
			exchange(nums, start, end);
			start++;
			end--;
		}
	}

	private void exchange(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}

