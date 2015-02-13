package com.duanmh.search;


public class MedianOfTwoArray {
	public static void main(String[] args) {

		int[] a = { 3, 4 };
		;
		int b[] = { 1, 2 };
		System.out.println(findMedianSortedArrays(a, b));

	}

	public static double findMedianSortedArrays(int A[], int B[]) {
		int lengtha = A == null ? 0 : A.length;
		int lengthb = B == null ? 0 : B.length;
		int length = lengtha + lengthb;
		int middle = length / 2;
		double findKthNum2 = findKthNum(A, 0, lengtha, B, 0, lengthb,
				middle + 1);
		if (length % 2 == 0) {
			double findKthNum = findKthNum(A, 0, lengtha, B, 0, lengthb, middle);
			return (findKthNum + findKthNum2) / 2;
		}
		return findKthNum2;
	}



	public static double findKthNum(int[] a, int starta, int enda, int[] b, int startb, int endb, int k) {
		assert (!(a == null && b == null));
		int lengtha = enda - starta;
		int lengthb = endb - startb;
		lengtha = lengtha < 0 ? 0 : lengtha;
		lengthb = lengthb < 0 ? 0 : lengthb;

		if (lengtha == 0) {

			return b[k - 1];
		}
		if (lengthb == 0) {
			return a[k - 1];
		}

		if (lengtha == 1 && lengthb == 1) {

			return (k == 1 ? Math.min(a[0], b[0]) : Math.max(a[0], b[0]));
		}

		if (lengtha > lengthb) {
			return findKthNum(b, startb, endb, a, starta, enda, k);
		}

		int i = Math.min(lengtha / 2, k / 2);
		int j = k - i - 1;
		int ai = a[i];
		int bj = b[j];
		int ai_1 = i - 1 < 0 ? Integer.MIN_VALUE : a[i - 1];
		int bj_1 = j - 1 < 0 ? Integer.MIN_VALUE : b[j - 1];
		if (ai <= bj) {
			if (ai>=bj_1) {
				return ai;
			} else {
				return findKthNum(a, starta + i + 1, enda - i - 1, b, startb, j, k - i - 1);
			}
		}else{
			
			if (bj >= ai_1) {
				return bj;
			}else {
				return findKthNum(a, starta, i, b, startb + j + 1, endb - j - 1, k - j - 1);
			}
			
		}
	}

}
