package com.duanmh.array;

/**
 * Given an array of integers, every element appears three times except for one.
 * Find that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * 
 * @author duanmh
 * 
 */


public class SingleNumII {

	int singleNumber(int A[], int n) {
		int oneNum = 0;
		int twoNum = 0;
		int threeNum = 0;
		for (int i = 0; i < n; i++) {
			threeNum = twoNum & A[i];
			twoNum = oneNum & A[i] | twoNum;
			oneNum = oneNum | A[i];
			oneNum = oneNum & (~threeNum);
			twoNum = twoNum & (~threeNum);
			threeNum = 0;
		}
		return oneNum;
	}
};
