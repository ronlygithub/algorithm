package com.duanmh.array;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (ie, buy one and sell one share of the stock
 * multiple times). However, you may not engage in multiple transactions at the
 * same time (ie, you must sell the stock before you buy again).
 * 
 * @author duanmh
 * 
 */
public class MaxProfitII {
	public static int maxProfite(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int result = 0;
		int diffprices[] = new int[prices.length - 1];
		for (int i = 0; i < diffprices.length; i++) {
			diffprices[i] = prices[i + 1] - prices[i];
		}
		result = 0;
		for (int i = 0; i < diffprices.length; i++) {
			if (diffprices[i] > 0) {
				result += diffprices[i];
			}
		}

		return result;

	}
}
