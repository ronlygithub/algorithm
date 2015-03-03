package com.leetcode.string;

import java.util.HashSet;
import java.util.Set;

public class WordLadder {

	public int ladderLength(String start, String end, Set<String> dict) {
		if (start == null || end == null || dict == null || start.isEmpty() || end.isEmpty() || dict.isEmpty()) {
			return 0;
		}
		if (start == end) {
			return 1;
		}
		Set<String> current = new HashSet<String>();
		Set<String> past = new HashSet<String>();
		past.add(end); // ladder from the end to the start
		dict.add(start); // add start into dict, so that when start shows up in
							// the laddered output, the loop can end
		int count = 1;
		while (!past.isEmpty()) {
			if (past.contains(start)) {
				return count;
			}
			current = new HashSet<String>();
			for (String s : past) {
				current = convert(s, dict, current);
			}
			past = current;
			count++;
		}
		return 0;
	}

	Set<String> convert(String s, Set<String> dict, Set<String> current) { // convert
																			// the
																			// words
																			// in
																			// the
																			// past
																			// set
																			// into
																			// next
																			// laddered
																			// set
																			// according
																			// to
																			// dictionary
		for (String word : dict) {
			if (convertable(s, word)) {
				current.add(word);
			}
		}
		for (String word : current) {
			dict.remove(word);
		}
		return current;
	}

	boolean convertable(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() != s2.length() || s1.equals(s2)) {
			return false;
		}
		int diff = 0;
		for (int i = s1.length() - 1; i >= 0; i--) {
			if (s1.charAt(i) != s2.charAt(i)) {
				diff++;
			}
			if (diff > 1) {
				return false;
			}
		}
		return true;
	}
}


