package com.duanmh.search;

public class SearchInsert {

	public static void main(String[] args) {
		int A[] = { 1, 2, 4, 6, 8 };
		System.out.println(searchInsert(A, 5));
	}

	public static int searchInsert(int[] A, int target) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int low = 0;
		int high = A.length - 1;
		int middle = 0;
		int posi = middle;
		while (low <= high) {
			middle = low + ((high - low) >> 1);
			if (A[middle] == target) {
				posi = middle;
				return posi;
			} else if (A[middle] > target) {
				high = middle - 1;
			} else {
				low = middle + 1;
				posi = low;
			}
		}

		return posi;

	}
}
