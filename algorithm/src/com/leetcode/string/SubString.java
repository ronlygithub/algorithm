package com.leetcode.string;




/**
 * 在指定的文本中查找指定的模式字符串
 * 
 * @author duanmh
 * 
 */
public class SubString {

	public static void main(String[] args) {
		System.out.println(findSubString("test", "this is a tet"));
		System.out.println(findSubStringB("test", "this is a test"));
	}

	public static boolean findSubString(String pattern, String text) {
		if (pattern == null || "".equals(pattern)) {
			return false;
		}

		if (text == null || "".equals(text)) {
			return false;
		}

		int pLength = pattern.length();
		int tLength = text.length();
		int j = 0;
		for (int i = 0; i <= tLength - pLength; i++) {
			for (j = 0; j < pLength; j++) {
				char tc = text.charAt(i + j);
				char pc = pattern.charAt(j);
				if (tc != pc) {
					break;
				}
			}
			if (j == pLength) {
				return true;
			}
		}
		return false;
		
	}

	public static boolean findSubStringB(String pattern, String text) {
		if (pattern == null || "".equals(pattern)) {
			return false;
		}

		if (text == null || "".equals(text)) {
			return false;
		}

		int pLength = pattern.length();
		int tLength = text.length();

		for (int i = 0, j = 0; i < tLength && j < pLength; i++) {
			char tc = text.charAt(i);
			char pc = pattern.charAt(j);
			if (tc != pc) {
				i = i - j;
				j = 0;
			} else {
				j++;
			}
			if (j == pLength) {
				return true;
			}

		}
		return false;

	}
}
