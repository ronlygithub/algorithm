package com.duanmh.math;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 * 
 * @author duanmh
 * 
 */
public class ReverseInteger {
	public int reverse(int x) {

		int cu = x >= 0 ? 1 : -1;
		int n = x >= 0 ? x : -1 * x;
		int value = 0;
		while (n > 0) {
			value = value * 10 + n % 10;
			n = n / 10;
		}
		return cu * value;

	}
}

