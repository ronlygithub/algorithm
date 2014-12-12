/************************* 版权声明 *********************************
 * 
 * 版权所有：XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
 * 
 ************************* 变更记录 *********************************
 *
 * 创建者：XXXXXXXXXX   创建日期： 2014年11月28日
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
public class MinNum {
	public static void main(String[] args) {
		int[] array = { 3, 32, 321 };

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}

		getMinNum(array);

	}

	public static void getMinNum(int[] aray) {
		if (aray == null || aray.length == 0) {
			return;
		}

		String[] b = new String[aray.length];
		for (int i = 0; i < aray.length; i++) {
			b[i] = String.valueOf(aray[i]);
		}

		quick_sort(b, 0, b.length - 1);

		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i]);
		}

	}

	public static int compare(String numa, String numb) {
		String ab = numa + numb;
		String ba = numb + numa;

		return ab.compareTo(ba);

	}

	// 快速排序
	private static void quick_sort(String array[], int left, int right) {
		if (left < right) {
			// Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
			int i = left, j = right;
			String x = array[left];
			while (i < j) {
				while (i < j && compare(array[j], x) >= 0)
					// 从右向左找第一个小于x的数
					j--;
				if (i < j)
					array[i++] = array[j];

				while (i < j && compare(array[i], x) < 0)
					// 从左向右找第一个大于等于x的数
					i++;
				if (i < j)
					array[j--] = array[i];
			}
			array[i] = x;
			quick_sort(array, left, i - 1); // 递归调用
			quick_sort(array, i + 1, right);
		}
	}
}
