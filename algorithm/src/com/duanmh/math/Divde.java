package com.duanmh.math;

public class Divde {

	public static void main(String[] args) {
		System.out.println(divide(12, 4));
	}

	public static int divide(int dividend, int divisor) {
		if (divisor == 0) {
			return Integer.MAX_VALUE;
		}

		int low = 0;
		int high = dividend;
		int middle = low + ((high - low) >> 1);
		int result = 0;
		while (low <= high) {
			middle = low + ((high - low) >> 1);
			for (int i = 0; i < middle; i++) {
				result += divisor;
			}
			if (result > high) {
				high = middle - 1;
				result -= divisor;
			} else if (result < low) {
				low = middle + 1;
				result += divisor;
			}
			result = 0;
		}

		return middle;

	}
}
