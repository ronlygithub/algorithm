/************************* 版权声明 *********************************
 * 
 * 版权所有：XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
 * 
 ************************* 变更记录 *********************************
 *
 * 创建者：XXXXXXXXXX   创建日期： 2014年12月4日
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

package com.duanmh.sort;

/**
 * @author duanmh
 * 
 */
public class MergeSort {

	private static int[] tmp;

	public static void main(String[] args) {

		int[] a = { 2, 4, 1, 8, 6, 3, 9, 5, 47, -5 };
		tmp = new int[a.length];
		mergeUP(a);
		mergeDownSort(a, 0, a.length - 1);
		System.out.println("\n");

	}

	private static void mergeDownSort(int[] array, int low, int high) {
		if (array == null || array.length == 0) {
			return;
		}

		if (low >= high) {
			return;
		}

		int middle = low + ((high - low) >> 1);
		mergeDownSort(array, low, middle);
		mergeDownSort(array, middle + 1, high);
		merge(array, low, high, middle);
	}

	private static void merge(int[] array, int low, int high, int middle) {

		int i = low;
		int j = middle + 1;

		for (int k = low; k <= high; k++) {
			tmp[k] = array[k];
		}

		for (int k = low; k <= high; k++) {
			if (i > middle) {
				array[k] = tmp[j++];
			} else if (j > high) {
				array[k] = tmp[i++];
			} else if (tmp[i] > array[j]) {
				array[k] = array[j++];
			} else if (tmp[i] <= array[j]) {
				array[k] = tmp[i++];
			}
		}
		show(array);
	}

	private static void mergeUP(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}

		int length = a.length;
		for (int i = 1; i < length; i += i) {
			for (int j = 0; j < length - i; j += i + i) {
				merge(a, j, Math.min(length - 1, j + i + i - 1), j + i - 1);
			}
		}

	}

	private static void show(int[] a) {
		if (a == null) {
			return;
		}

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("\n");
	}
}
