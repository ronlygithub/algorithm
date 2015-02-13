package com.duanmh.search;

public class RotatedArray {

	public static void main(String[] args) {
		int[] a = { 3, 4, 5, 0, 1, 2 };
		System.out.println(search(a, 4));
	}

	public static int search(int[] A, int target) {

		if (A == null || A.length == 0) {
			return -1;
		}

		int low = 0;
		int high = A.length - 1;
		while (low <= high) {
			int middle = low + ((high - low) >> 1);
			if (A[middle] == target) {
				return middle;
			}

			if (A[middle] > A[low]) {
				if (target < A[low] || target > A[middle]) {
					low = middle + 1;
				} else {
					high = middle - 1;
				}
			} else {
				if (target < A[middle] || target > A[high]) {
					high = middle - 1;
				} else {
					low = middle + 1;
				}

			}
		}
		return low < A.length && A[low] == target ? low : -1;

	}
}
