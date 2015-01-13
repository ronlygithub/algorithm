package com.leetcode.string;

/**
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given an encoded message containing digits,
 * determine the total number of ways to decode it.
 * 
 * For example, Given encoded message "12", it could be decoded as "AB" (1 2) or
 * "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 * 
 * @author duanmh
 * 
 */
public class NumberDecoding {

	public static void main(String[] args) {
		System.out.println(numDecodings("10000"));
	}

	public static int numDecodings(String s) {
		char[] charArray = s.toCharArray();
		if (charArray.length == 0 || charArray[0] == '0') {
			return 0;
		}
	    int cur_2 = 1,cur_1 = 1,cur = 0;

		for (int i = 2; i <= charArray.length; i++) {
			if (charArray[i - 1] != '0') {
				cur += cur_1;
			}
			if (charArray[i - 2] == '1' || (charArray[i - 2] == '2' && charArray[i - 1] < '7')) {
				cur+=cur_2;
			}
	        cur_2 = cur_1;
	        cur_1 =  cur;
	        cur = 0;
	    }
	    return cur_1;
	}
}
