package com.leetcode.string;

/**
 * 字符串最长公共前缀
 * 
 * @author duanmh
 * 
 */
public class LongestCommonPrefix {
	public static void main(String[] args) {
		String test[] = { "test", "" };
		System.out.println(longestCommonPrefix(test));
	}

	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		String prefix = "";
		char current = ' ';
		int length = 0;
		while (true) {
			if (length < strs[0].length()) {
				current = strs[0].charAt(length);
			} else {
				return prefix;
			}
			for (int i = 1; i < strs.length; i++) {
				if (length >= strs[i].length()) {
					return prefix;
				}

				if (strs[i].charAt(length) != current) {
					return prefix;
				}
			}
			prefix += current;
			length++;
		}

	}

}
