package com.leetcode.string;

public class CompareVersion {

	public static void main(String[] args) {
		System.out.println(compareVersion("1.1", "1"));
	}

	public static int compareVersion(String version1, String version2) {

		if (version1 == null || "".equals(version1)) {
			return -1;
		}

		if (version2 == null || "".equals(version2)) {
			return -1;
		}
		String[] split1 = version1.split("\\.");
		String[] split2 = version2.split("\\.");
		int length1 = split1.length;
		int length2 = split2.length;
		for (int i = 0, j = 0; i < length1 || j < length2; i++, j++) {
			int v1 = i < length1 ? Integer.valueOf((split1[i])) : 0;
			int v2 = j < length2 ? Integer.valueOf((split2[j])) : 0;
			if (v2 == v1) {
				continue;
			} else if (v1 > v2) {
				return 1;
			} else if (v1 < v2) {
				return -1;
			}
		}

		return 0;

	}

}
