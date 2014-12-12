/************************* 版权声明 *********************************
 * 
 * 版权所有：XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
 * 
 ************************* 变更记录 *********************************
 *
 * 创建者：XXXXXXXXXX   创建日期： 2014年12月3日
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
public class MaxProductSubArray {

	public static void main(String[] args) {
		int[] a = { 2, 3, -2, 4 };
		maxProductSubArray(a);
	}

	private static int maxProductSubArray(int[] a) {

		if (a == null || a.length == 0) {
			return 0;
		}

		int max = a[0];
		int result = a[0];
		int min = a[0];
		for (int i = 1; i < a.length; i++) {
			int tmp = max;
			max = Math.max(Math.max(max * a[i], min * a[i]), a[i]);
			min = Math.min(Math.min(tmp * a[i], min * a[i]), a[i]);
			if (max > result) {
				result = max;
			}
		}

		return result;

	}
}
