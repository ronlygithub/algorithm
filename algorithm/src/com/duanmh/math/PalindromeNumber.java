package com.duanmh.math;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * @author duanmh
 * 
 */
public class PalindromeNumber {
	public static void main(String[] args) {
		isPalindrome(123);
		reverse(1056389759);
	}

	public static boolean isPalindrome(int x) {
		int n = x;
		int value = 0;
		while (n > 0) {
			value = value * 10 + n % 10;
			n = n / 10;
		}

		return value == x;

	}

	public static int reverse(int x) {
		int cu = x >= 0 ? 1 : -1;
		int n = x >= 0 ? x : -1 * x;
		int value = 0;
		int i = Integer.MAX_VALUE / 10;
		while (n > 0) {
			if (value > i) {
				return 0;
			}
			value = value * 10 + n % 10;
			n = n / 10;
		}
		return cu * value;
	}
}

