package com.duanmh.array;


/**
 * 最长不重复子串的长度
 * 
 * @author duanmh
 * 
 */
public class LongestSubstring {

	public static void main(String[] args) {
		// String test = "aaaaaa";
		String test = "qopubjguxhxdipfzwswybgfylqvjzhar";
		lengthOfLongestSubstring(test);
	}

	public static int lengthOfLongestSubstring(String s) {
		if (s == null || "".equals(s)) {
			return 0;
		}
		char[] array = s.toCharArray();

		int result = 1;
		int current = 1;
		int start = 0;


		for (int end = 1; end < array.length; end++) {		
			int index = search(array, end, start, end - 1);
			if (index == -1) {
				current++;
				continue;
			}
			result = result > current ? result : current;
			start = index + 1;
			current = end - start + 1;
		}
		result = result > current ? result : current;
		return result;
	}
	
	public static int search(char[] strs, int posi, int start, int end) {
		if (strs == null || start > end) {
			return -1;
		}

		for (int i = start; i <= end; i++) {
			if (strs[i] == strs[posi]) {
				return i;
			}
		}
		return -1;


	}


}
