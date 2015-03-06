package com.leetcode.string;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding
 * column number.
 * 
 * For example:
 * 
 * A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28
 * 
 * @author duanmh
 * 
 */
public class TitleToNum {
	public static void main(String[] args) {
		TitleToNum instance = new TitleToNum();
		instance.titleToNumber("AC");
	}
	public int titleToNumber(String s) {
		if (s == null || s.isEmpty()) {
			return 0;
		}
		char[] charArray = s.toCharArray();
		int length = charArray.length - 1;
		int result = 0;
		for (int i = 0; i <= length; i++) {
			char c = charArray[i];
			if (c > 'Z' || c < 'A') {
				return 0;
			}
			result = result * 26 + (c - 'A' + 1);
		}
		return result;

	}
}

