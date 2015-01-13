package com.duanmh.array;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * 
 * @author duanmh
 * 
 */
public class MaxProfit {

	public static void main(String[] args) {
		int pri[] = { 9, 2 };
		System.out.println(maxProfite(pri));
	}

	public static int maxProfite(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
		int result = 0;
		int diffprices[] = new int[prices.length - 1];
		for (int i = 0; i < diffprices.length; i++) {
			diffprices[i] = prices[i + 1] - prices[i];
		}

		result = diffprices[0];
		int currentsum = 0;
		for (int i = 0; i < diffprices.length; i++) {
			currentsum += diffprices[i];
			if (currentsum > result) {
				result = currentsum;
			}
			if (currentsum < 0) {
				currentsum = 0;
			}
		}

		return Math.max(result, 0);

	}

	public int maxProfit(int[] prices) {
		if (prices.length == 0 | prices.length == 1) {
			return 0;
		}
		int min = Integer.MAX_VALUE, profit = 0;
		for (int x = 0; x < prices.length; x++) {
			if ((prices[x] - min) > profit) {
				profit = prices[x] - min;
			}
			if (prices[x] < min) {
				min = prices[x];
			}
		}
		return profit;

	}

}
