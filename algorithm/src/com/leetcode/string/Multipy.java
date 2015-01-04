package com.leetcode.string;


public class Multipy {
	public String multiply(String num1, String num2) {
		if (null == num1 || null == num2) {
			return "0";
		}

		if ("".equals(num1) || "".equals(num2)) {
			return "0";
		}

		return num2;

	}

}
