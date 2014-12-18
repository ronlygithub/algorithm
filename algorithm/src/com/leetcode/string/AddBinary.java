package com.leetcode.string;


/**
 * �������ַ�����ʾ���������
 * 
 * @author duanmh
 * 
 */
public class AddBinary {

	public static void main(String[] args) {
		// System.out.println(addBinary("11", "1"));
		System.out.println(addDecimalism("120699999999999999999999999999999999999999999999999999999999999999999999999",
				"93"));
	}

	/**
	 * �������ӷ�
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static String addDecimalism(String a, String b) {
		if (a == null || "".equals(a)) {
			return b;
		}

		if (b == null || "".equals(b)) {
			return a;
		}

		char[] charA = a.toCharArray();
		char[] charB = b.toCharArray();

		int lengthA = charA.length - 1;
		int lengthB = charB.length - 1;
		int byteA;
		int byteB;
		int sum = 0;
		int curr = 0;
		StringBuilder result = new StringBuilder();
		while (lengthA > -1 || lengthB > -1 || curr >= 1) {
			byteA = lengthA > -1 ? Character.getNumericValue(charA[lengthA--]) : 0;
			byteB = lengthB > -1 ? Character.getNumericValue(charB[lengthB--]) : 0;
			sum = (byteA + byteB + curr) % 10;
			curr = (byteA + byteB + curr) / 10;
			result.append(sum);
		}
		return result.reverse().toString();

	}

	public static String addBinary(String a, String b) {
		if (a == null || "".equals(a)) {
			return b;
		}

		if (b == null || "".equals(b)) {
			return a;
		}

		char[] charA = a.toCharArray();
		char[] charB = b.toCharArray();

		int lengthA = charA.length;
		int lengthB = charB.length;
		int byteA;
		int byteB;
		int sum = 0;
		int curr = 0;
		int i = lengthA - 1, j = lengthB - 1;
		StringBuilder result = new StringBuilder();
		while (i > -1 || j > -1 || curr == 1) {
			byteA = i > -1 ? Character.getNumericValue(charA[i--]) : 0;
			byteB = j > -1 ? Character.getNumericValue(charB[j--]) : 0;
			sum = byteA ^ byteB ^ curr;
			curr = ((byteA + byteB + curr) >= 2) ? 1 : 0;
			result.append(sum);
		}
		return result.reverse().toString();
	}
}
