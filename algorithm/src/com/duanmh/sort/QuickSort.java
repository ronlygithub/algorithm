package com.duanmh.sort;

public class QuickSort extends Sort {

	public void quickSort(int[] array, int low, int high) {
		if (array == null || array.length == 0) {
			return;
		}

		if (low >= high) {
			return;
		}

		int k = partion(array, low, high);
		quickSort(array, low, k - 1);
		quickSort(array, k + 1, high);

	}

	private int partion(int[] array, int low, int high) {
		int i = low;
		int j = high + 1;
		int v = array[low];
		while (true) {
			while (array[++i] < v) {
				if (i == high) {
					break;
				}
			}

			while (array[--j] > v) {
				if (j == low) {
					break;
				}
			}

			if (i >= j) {
				break;
			}

			int tmp = array[i];
			array[i] = array[j];
			array[j] = tmp;
		}

		int tmp = array[low];
		array[low] = array[j];
		array[j] = tmp;
		return j;


	}
}

