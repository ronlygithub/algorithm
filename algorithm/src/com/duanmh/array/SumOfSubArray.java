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
public class SumOfSubArray {
	public static void main(String[] args) {

		int a[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		getSumOfSubArray(a, 1);
	}

	public static void getSumOfSubArray(int array[], int sum) {
		if (array == null || array.length == 0) {
			return;
		}

		int small = 0;
		int big = 1;
		int middle = (1 + sum) / 2;
		int currentSum = array[small] + array[big];
		while (small <= middle) {
			if (currentSum < sum && big < array.length - 1) {
				currentSum = currentSum + array[++big];
			} else if (currentSum > sum) {
				currentSum -= array[small++];
			} else if (big < array.length - 1) {
				System.out.println("small: " + array[small] + " big: "
						+ array[big]);
				currentSum = currentSum + array[++big];

			} else {
				break;
			}

		}
	}
}
