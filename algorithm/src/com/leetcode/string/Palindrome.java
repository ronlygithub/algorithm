package com.leetcode.string;

/**
 * ╩ьнд
 * 
 * @author duanmh
 * 
 */
public class Palindrome {

	public static void main(String[] args) {
		String s = "1a2";
		System.out.println(isPalindrome(s));
	}

	public static boolean isPalindrome(String s) {
		if (s == null || s.length() <= 1) {
			return true;
		}
		s = s.toLowerCase();
		char[] charArray = s.toCharArray();
		int length = charArray.length;
		int left = 0;
		int right = length - 1;

		while (left < right) {
			while (left < right && (!isnum(charArray[left]))) {
				left++;
			}
			while (right > left && (!isnum(charArray[right]))) {
				right--;
			}

			if (charArray[left] != charArray[right]) {
				return false;
			}

			left++;
			right--;

		}

		return true;

	}

	private static boolean isnum(char c) {
		if ((c <= 'z' && c >= 'a') || (c <= '9' && c >= '0')) {
			return true;
		}
		return false;

	}

}
