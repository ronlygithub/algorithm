/************************* ��Ȩ���� *********************************
 * 
 * ��Ȩ���У�XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
 * 
 ************************* �����¼ *********************************
 *
 * �����ߣ�XXXXXXXXXX   �������ڣ� 2014��12��3��
 * ������¼��������ṹ��
 * 
 * �޸��ߣ�       �޸����ڣ�
 * �޸ļ�¼��
 *
 * �޸��ߣ�       �޸����ڣ�
 * �޸ļ�¼��
 * ����
 ************************* To  Do *********************************
 *
 * 1��ʵ������δʵ�ֵķ������׳�UnsupportedOperationException�ķ�������
 * 
 ************************* ��   �� *********************************
 *
 * �������дд���룬�п�������ʲô�ġ�
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
