package com.leetcode.string;

/**
 * 字符串转换为整数 需要考虑的因素： 1. 前导符号：+，- 2. 整数溢出
 * 
 * @author duanmh
 * 
 */

public class Solution {
    public int atoi(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		char[] charts = str.toCharArray();
		int length = charts.length;
		int start = 0;
		int flag = 1;

		while (start < length && charts[start] == ' ') {
			start++;
		}

		if (charts[start] == '-') {
			flag = -1;
			start++;
		} else if (charts[start] == '+') {
			flag = 1;
			start++;
		}
		int max = Integer.MAX_VALUE / 10;
		int value = 0;
		while (start < length) {
			if (!(charts[start] >= '0' && charts[start] <= '9')) {
				break;
			}
			if (value < max) {
				value = value * 10 + charts[start] - '0';
			} else if (value > max) {
				value = flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
				break;
			} else if (value == max) {
				if (charts[start] - '0' > 7) {
					value = flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
				} else {
					value = value * 10 + charts[start] - '0';
				}
				break;
			}
			start++;
		}

		return value * flag;
        
    }
}