package com.duanmh.search;

public class BinarySearch {
	public static void main(String[] args) {

		int[] a = { 2, 3, 5, 6, 7, 12, 23, 45, 67, 89, 100 };
		System.out.println(binarySearch(a));

	}

	public static int binarySearch(int[] a) {
		if (a == null || a.length == 0) {
			return -1;
		}
		int key = 23;
		int low = 0;
		int heigh = a.length - 1;
		while (low <= heigh) {
			int middle = low + ((heigh - low) >> 1);
			if (a[middle] < key) {
				low = middle + 1;
			} else if (a[middle] > key) {
				heigh = middle - 1;
			} else {
				return middle;
			}

		}

		return -1;

	}
}
