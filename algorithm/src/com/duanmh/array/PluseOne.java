package com.duanmh.array;

/**
 * Given a non-negative number represented as an array of digits, plus one to
 * the number.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 * 
 * @author duanmh
 * 
 */

public class PluseOne {
	public static int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0) {
			return digits;
		}

		int length = digits.length;
		int c = 1;
		for (int i = length - 1; i >= 0; i--) {
			int result = c + digits[i];
			if (result > 9) {
				c = 1;
				result = result - 10;
			} else {
				c = 0;

			}
			digits[i] = result;

		}

		if (c > 0) {
			int[] result = new int[length + 1];
			result[0] = c;
			for (int i = 1; i < result.length; i++) {
				result[i] = digits[i - 1];
			}
			return result;

		}
		return digits;
	}

	public static void main(String[] args) {
		int[] dig = { 9, 4, 9, 9 };
		plusOne(dig);
	}
}

