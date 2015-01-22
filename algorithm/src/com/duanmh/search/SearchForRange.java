package com.duanmh.search;

/**
 * Given a sorted array of integers, find the starting and ending position of a
 * given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * 
 * @author duanmh
 * 
 */
public class SearchForRange {

	public static void main(String[] args) {
		int a[] = { 1, 2, 2, 2, 3, 4, 5, 5, 5 };
		System.out.println(findLow(a, 9));
		System.out.println(findHigh(a, 9));
	}

	public static int findLow(int A[], int key) {
		if (A == null || A.length == 0) {
			return -1;
		}
		int low = 0;
		int high = A.length - 1;
		int posi = -1;
		while (low <= high) {
			int middle = low + ((high - low) >> 1);
			if (key == A[middle]) {
				posi = middle;
				high = middle - 1;
			} else if (key > A[middle]) {
				low = middle + 1;
			} else if (key < A[middle]) {
				high = middle - 1;
			}

		}
		return posi;

	}

	public static int findHigh(int A[], int key) {
		if (A == null || A.length == 0) {
			return -1;
		}
		int low = 0;
		int high = A.length - 1;
		int posi = -1;
		while (low <= high) {
			int middle = low + ((high - low) >> 1);
			if (key == A[middle]) {
				posi = middle;
				low = middle + 1;
			} else if (key > A[middle]) {
				low = middle + 1;
			} else if (key < A[middle]) {
				high = middle - 1;
			}

		}
		return posi;

	}
}
