package com.duanmh.search;

public class BinarySearch {
	public static void main(String[] args) {

		int[] a = { 2, 3, 3, 5, 5, 6, 7, 12, 23, 45, 67, 89, 100 };
		// System.out.println(binarySearch(a));
		//
		// System.out.println(binarySearch(a, 0, 10, 10));
		System.out.println(binarySearchFirst(a, 100));
		System.out.println(binarySearchEnd(a, 90));

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

	public static int binarySearch(int[] a, int low, int high, int key) {
		if (low > high) {
			return -1;
		}

		int middle = low + ((high - low) >> 1);
		if (a[middle] > key) {
			return binarySearch(a, low, middle - 1, key);
		} else if (a[middle] < key) {
			return binarySearch(a, middle + 1, high, key);
		} else {
			return middle;
		}
	}

	/**
	 * 二分查找给定值第一次出现的位置
	 * @param a
	 * @param key
	 * @return
	 */
	public static int binarySearchFirst(int[] a, int key) {
		if (a == null || a.length == 0) {
			return 0;
		}

		int left = 0;
		int right = a.length - 1;

		while (left <= right) {
			int middle = left + ((right - left) >> 1);
			if (a[middle] > key) {
				right = middle - 1;
			} else if (a[middle] < key) {
				left = middle + 1;
			} else {
				if (middle == 0 || middle > 0 && a[middle - 1] != key) {
					return middle;
				} else if (middle > 0 && a[middle - 1] == key) {
					right = middle - 1;
				}

			}
		}

		return 0;

	}

	/**
	 * 二分查找给定值最后出现的为止
	 * @param a
	 * @param key
	 * @return
	 */
	public static int binarySearchEnd(int[] a, int key) {
		if (a == null || a.length == 0) {
			return -1;
		}

		int left = 0;
		int right = a.length - 1;
		int length = a.length - 1;

		while (left <= right) {
			int middle = left + ((right - left) >> 1);
			if (a[middle] > key) {
				right = middle - 1;
			} else if (a[middle] < key) {
				left = middle + 1;
			} else {
				if (middle == length || middle < length && a[middle + 1] != key) {
					return middle;
				} else if (middle < length && a[middle + 1] == key) {
					right = middle + 1;
				}

			}
		}

		return -1;

	}
}
