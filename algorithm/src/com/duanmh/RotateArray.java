/************************* 版权声明 *********************************
 * 
 * 版权所有：XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
 * 
 ************************* 变更记录 *********************************
 *
 * 创建者：XXXXXXXXXX   创建日期： 2014年11月27日
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

package com.duanmh;

/**
 * @author duanmh
 * 
 */
public class RotateArray {
	public static void main(String[] args) {
		// int[] a = { 2, 4, 1, 0, 6, 5 };
		// int[] quickSort = quickSort(a, 0, a.length - 1);
		System.out.println("t");
	}

	public static int findMin(int[] num) {
		if (num == null || num.length == 0) {
			return -1; // should throw an exception, not sure if leetcode
						// supports it
		}
		int left = 0;
		int right = num.length - 1;
		while (left < right) {
			if (num[left] < num[right]) {
				return num[left];
			}
			int middle = left + (right - left) / 2;
			if (num[left] > num[middle]) {
				right = middle;
			} else if (num[left] < num[middle]) {
				left = middle + 1;
			} else { // num[l] == num[m]
				if (num[left] == num[right]) {
					left++;
					right--;
				} else { // only the num[l] == num[m] > num[r] case left
					left = middle + 1;
				}
			}
		}
		return num[left];
	}

	public static int[] quickSort(int[] array, int left, int right) {
		if (left > right) {
			return array;
		}
		int low = partion(array, left, right);
		System.out.println("low" + low);
		show(array);
		quickSort(array, left, low - 1);
		quickSort(array, low + 1, right);

		return array;

	}

	private static void show(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("\n");
	}

	/**
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 */
	private static int partion(int[] array, int left, int right) {

		int low = left;
		int heigh = right;
		int tmp = array[low];
		while (low < heigh) {
			while (low < heigh && tmp >= array[heigh]) {
				heigh--;
			}

			array[low] = array[heigh];
			while (low < heigh && array[low] >= tmp) {
				low++;
			}
			array[heigh] = array[low];
		}
		array[low] = tmp;
		return low;
	}

}
