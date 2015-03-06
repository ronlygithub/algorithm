package com.leetcode.string;

public class ConvertToTitle {

	public static void main(String[] args) {
		ConvertToTitle inst = new ConvertToTitle();
		inst.convertToTitle(52);
	}
	public String convertToTitle(int n) {

		StringBuilder s = new StringBuilder();
		n--;
		while (n >= 0) {
			int tmp = n % 26;
			char c = (char) ('A' + tmp);
			s.append(c);
			n = n / 26 - 1;
		}
		return s.reverse().toString();

	}
}

