package com.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string, S, and a list of words, L, that are all of the same
 * length. Find all starting indices of substring(s) in S that is a
 * concatenation of each word in L exactly once and without any intervening
 * characters.
 * 
 * For example, given: S: "barfoothefoobarman" L: ["foo", "bar"]
 * 
 * You should return the indices: [0,9]. (order does not matter).
 * 
 * @author duanmh
 * 
 */
public class SubstringConcatenation {
	private static Map<String, Word> map = new HashMap<String, Word>();

	public static void main(String[] args) {
		String[] L = { "foo", "bar" };
		String S = "barfoothefoobarman";
		SubstringConcatenation instance = new SubstringConcatenation();

		instance.findSubstring(S, L);
	}

	public List<Integer> findSubstring(String S, String[] L) {
		if (S == null || L == null || L.length == 0) {
			return null;
		}

		int length = L[0].length();
		int index = 0;
		int count = 0;
		int tmp = 0;
		List<Integer> result = new ArrayList<Integer>();
		init(L);

		char[] charArray = S.toCharArray();
		StringBuilder key = new StringBuilder();
		for (int j = 0; j < charArray.length; j++) {
			System.out.println();
			key = new StringBuilder();
			for (int i = j; i < charArray.length; i++) {
				key.append(charArray[i]);
				if (tmp != length - 1) {
					tmp++;
					continue;
				}
				tmp = 0;
				String string = key.toString();
				System.out.print(string + " ");
				if (map.containsKey(string)) {
					Word value = map.get(string);
					if (value.occurance != 0) {
						index = value.position + length;
						count = (i - index + 1) / length;
					} else {
						count++;
					}
					Word newValue = new Word(i - length + 1, 1);
					map.put(string, newValue);

				} else {
					index = i + 1;
					init(L);
					count = 0;
				}
				if (count == L.length) {
					result.add(index);
					count = 0;
				}
				key = new StringBuilder();
			}
		}
		return result;
	}

	private void init(String[] L) {
		for (String key : L) {
			map.put(key, new Word(0, 0));
		}
	}

	public class Word {
		int position;
		int occurance;

		public Word(int position, int occurance) {
			this.position = position;
			this.occurance = occurance;
		}
	}
}

