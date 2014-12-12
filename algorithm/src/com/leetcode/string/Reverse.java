/************************* 版权声明 *********************************
 * 
 * 版权所有：XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
 * 
 ************************* 变更记录 *********************************
 *
 * 创建者：XXXXXXXXXX   创建日期： 2014年12月3日
 * 创建记录：创建类结构。
 * 
 * 修改者：       修改日期：
 * 修改记录：
 *
 * 修改者：       修改日期：
 * 修改记录：
 * ……
 ************************* To  Do *********************************
 *
 * 1、实现所有未实现的方法（抛出UnsupportedOperationException的方法）。
 * 
 ************************* 随   笔 *********************************
 *
 * 这里可以写写感想，感慨，疑问什么的。
 * 
 ******************************************************************
 */

package com.leetcode.string;

/**
 * @author duanmh
 * 
 */
public class Reverse {

	public static void main(String[] args) {

		System.out.println(reverse("  this   is a blue sas "));

	}

	private static String reverse(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}
		char[] array = str.toCharArray();
		int high = 0;
		int low = 0;
		int l = 0;
		int wordCound = 0;
		while (true) {
			while (high < array.length && array[high] == ' ') {
				high++;
			}
			if (high == array.length) {
				break;
			}
			if (wordCound > 0) {
				array[low++] = ' ';
			}

			l = low;
			while (high < array.length && array[high] != ' ') {
				array[low++] = array[high++];
			}

			reverseWord(array, l, low - 1);
			wordCound++;

		}
		reverseWord(array, 0, low - 1);

		str = String.copyValueOf(array, 0, low);
		return str;

	}

	private static void reverseWord(char[] charArray, int low, int hight) {

		while (low < hight) {
			char tmp = charArray[low];
			charArray[low] = charArray[hight];
			charArray[hight] = tmp;
			low++;
			hight--;
		}
	}

	public static String removeSpace(char[] charArray) {
		if (charArray == null || charArray.length == 0) {
			return "";
		}

		int space = 0;
		int noSpace = 0;

		while (space < charArray.length && noSpace < charArray.length) {
			while (noSpace < charArray.length && charArray[noSpace] == ' ') {
				noSpace++;
			}

			if (noSpace < charArray.length) {

				charArray[space++] = charArray[noSpace++];
			}

		}
		String valueOf = String.valueOf(charArray);
		return valueOf.substring(0, space);

	}
}
