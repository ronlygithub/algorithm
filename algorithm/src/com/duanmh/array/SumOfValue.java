/************************* 版权声明 *********************************
 * 
 * 版权所有：XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
 * 
 ************************* 变更记录 *********************************
 *
 * 创建者：XXXXXXXXXX   创建日期： 2014年12月8日
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

package com.duanmh.array;

/**
 * @author duanmh
 * 
 */
public class SumOfValue {

	public static void main(String[] args) {
		int a[] = { 2, 4, 5, 6, 7, 8, 9, 11, 15 };
		getSumofValue(a, 15);
	}

	public static void getSumofValue(int array[], int value) {
		if (array == null || array.length < 2) {
			return;
		}

		int left = 0;
		int right = array.length - 1;

		while (left < right) {
			int sum = array[left] + array[right];
			if (sum == value) {
				System.out.println(value + " = " + array[left] + " + "
						+ array[right]);
				left++;
				right--;

			} else if (sum > value) {
				right--;

			} else if (sum < value) {
				left++;
			}
		}
	}
}
