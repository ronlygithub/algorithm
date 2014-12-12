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

package com.duanmh.array;

/**
 * @author duanmh
 * 
 */
public class MaxSubArray {
	static boolean invalida = false;

	public static void main(String[] args) {
		// int[] array = { 1, 2, -4, 5, 9, -7 };
		int[] array = { 0, -1, -22, 4 };
		int maxSubArray = getMaxSubArray(array);
		System.out.println(maxSubArray);
	}

	private static int getMaxSubArray(int[] array) {
		if (array == null || array.length == 0) {
			invalida = true;
			return -1;
		}

		invalida = false;
		int currentSum = 0;
		int greatSum = array[0];
		for (int i = 0; i < array.length; i++) {
			if (currentSum <= 0) {
				currentSum = array[i];
			} else {
				currentSum += array[i];
			}

			if (greatSum < currentSum) {
				greatSum = currentSum;
			}
		}

		return greatSum;

	}
}
