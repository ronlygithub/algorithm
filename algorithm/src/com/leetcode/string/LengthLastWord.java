package com.leetcode.string;

public class LengthLastWord {

	public static void main(String[] args) {
		String ts = "a bb   ";
		getLengthLastWord(ts);
	}

	public static int getLengthLastWord(String s) {
		if (s == null || "".equals(s)) {
			return 0;
		}

		char[] charArray = s.toCharArray();
		int length = charArray.length;
		int start = 0;
		int result = 0;

		int end = start;
		while (end < length) {
			while (end < length && charArray[end] == ' ') {
				end++;
			}
			start = end;
			while (end < length && charArray[end] != ' ') {
				end++;
			}
			if (end <= length && end != start) {
				result = end - start;
			}
		}
		return result;

	}
}
