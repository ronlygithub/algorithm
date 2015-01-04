package com.leetcode.string;




/**
 * 在指定的文本中查找指定的模式字符串
 * 
 * @author duanmh
 * 
 */
public class SubString {

	public static void main(String[] args) {
		System.out.println(findSubString("test", "this is a tet"));
		System.out.println(findSubStringB("s", "asss"));
	}

	public static boolean findSubString(String pattern, String text) {
		if (pattern == null || "".equals(pattern)) {
			return false;
		}

		if (text == null || "".equals(text)) {
			return false;
		}

		int pLength = pattern.length();
		int tLength = text.length();
		int j = 0;
		for (int i = 0; i <= tLength - pLength; i++) {
			for (j = 0; j < pLength; j++) {
				char tc = text.charAt(i + j);
				char pc = pattern.charAt(j);
				if (tc != pc) {
					break;
				}
			}
			if (j == pLength) {
				return true;
			}
		}
		return false;
		
	}

	public static int findSubStringB(String haystack, String needle) {
		if (haystack == null || needle == null) {
			return -1;
		}

		if (haystack.equals(needle)) {
			return 0;
		}



		int pLength = haystack.length();
		int tLength = needle.length();

		// for (int i = 0, j = 0; i < tLength && j < pLength; i++) {
		// char tc = needle.charAt(i);
		// char pc = haystack.charAt(j);
		// if (tc != pc) {
		// i = i - j;
		// j = 0;
		// } else {
		// j++;
		// }
		// if (j == pLength) {
		// return i - j + 1;
		// }
		//
		// }

		int i = 0;
		int j = 0;
		while (i < tLength && j < pLength && pLength - i >= tLength) {
			if (haystack.charAt(j) == needle.charAt(i)) {
				i++;
				j++;
			} else {
				i = i - j + 1;
				j = 0;
			}
		}

		return j == pLength ? i - j : -1;

	}
	
	public class Solution {
		public int strStr(String haystack, String needle) {
		    if (needle=="") {
				return 0;
			}
		    int i=0;
		    int j=0;
		    int k=0;
		    int hlength = haystack.length();
			int nlength = needle.length();
			while(i<hlength && hlength-i>=nlength){
		        k=i;
		        while(j<nlength){
		            if(haystack.charAt(k)!=needle.charAt(j)){
		                j=0;
		                break;
		            }
		            j++;
		            k++;
		        }
		        if(j==nlength) {
					return i;
				}
		        i++;
		    }
		    return -1;
		}
	}
}

