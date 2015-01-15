package com.leetcode.string;

/**
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * For example, S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
 * 
 * Note: If there is no such window in S that covers all characters in T, return
 * the emtpy string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always
 * be only one unique minimum window in S.
 * 
 * @author duanmh
 * 
 */
public class MinumWindow {

	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));

	}

	public static String minWindow(String str, String ttr) {
		if (str.isEmpty() || ttr.isEmpty()) {
			return "";
		}

		char[] S = str.toCharArray();
		char[] T = ttr.toCharArray();
		int count = T.length;
		int require[] = new int[128];
		boolean chSet[] = new boolean[128];
		for (int i = 0; i < count; ++i) {
			require[T[i]]++;
			chSet[T[i]] = true;
		}
		int i = -1;
		int j = 0;
		int minLen = Integer.MAX_VALUE;
		int minIdx = 0;
		while (i < S.length - 1 && j < S.length) {
			if (count > 0) {
				i++;
				require[S[i]]--;
				System.out.println("i = " + i + " s[i] = " + S[i]);
				if (chSet[S[i]] && require[S[i]] >= 0) {
					count--;
				}
			} else {
				if (minLen > i - j + 1) {
					minLen = i - j + 1;
					minIdx = j;
				}
				require[S[j]]++;
				if (chSet[S[j]] && require[S[j]] > 0) {
					count++;
				}
				j++;
			}
		}
		if (minLen == Integer.MAX_VALUE) {
			return "";
		}
		return str.substring(minIdx, minLen);

	}
}
