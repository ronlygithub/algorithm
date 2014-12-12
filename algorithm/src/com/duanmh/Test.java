/************************* 版权声明 *********************************
 * 
 * 版权所有：XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
 * 
 ************************* 变更记录 *********************************
 *
 * 创建者：XXXXXXXXXX   创建日期： 2014年11月12日
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
/**
 * @author duanmh
 * 
 */
public class Test {

	public static void main(String[] args) {
		int array[] = new int[10000000];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 100000);
		}
		long startTime = System.currentTimeMillis();
		System.out.println(getMaxMinus(array));
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime));
	}

	private static int getMaxMinus(int a[]) {

		if (a == null || a.length < 2) {
			return -1;
		}
		int maxMinus = a[0] - a[1];
		int minInArray = a[0];
		int maxInArray = a[0];
		for (int i = 0; i < a.length; i++) {
			if (a[i] < minInArray) {
				minInArray = a[i];
			}

			if (a[i] > maxInArray) {
				maxInArray = a[i];
			}
		}

		maxMinus = maxInArray - minInArray;
		System.out.println("max=" + maxInArray + " , min=" + minInArray);

		return maxMinus;

	}

}
