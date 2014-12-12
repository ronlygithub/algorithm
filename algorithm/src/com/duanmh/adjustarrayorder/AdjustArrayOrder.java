/************************* 版权声明 *********************************
 * 
 * 版权所有：XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
 * 
 ************************* 变更记录 *********************************
 *
 * 创建者：XXXXXXXXXX   创建日期： 2014年11月17日
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

package com.duanmh.adjustarrayorder;

import java.util.Scanner;

/**
 * @author duanmh
 * 
 */
public class AdjustArrayOrder {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int length = s.nextInt();
		int array[] = new int[length];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 1000);
			System.out.print(array[i] + " ");
		}
		System.out.println("\n");
		reOrder(array);
	}

	private static void reOrder(int[] array) {
		if (array == null || array.length == 0) {
			return;
		}

		int indexStart = 0;
		int indexEnd = array.length - 1;
		while (indexEnd > indexStart) {
			while (test(array[indexStart])) {
				indexStart++;
			}

			while (!test(array[indexEnd])) {
				indexEnd--;
			}

			if (indexEnd > indexStart) {
				int tmp = array[indexEnd];
				array[indexEnd] = array[indexStart];
				array[indexStart] = tmp;
			}

		}

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

	}

	private static boolean test(int value) {

		if ((value & 0x1) == 1) {
			return true;
		}

		return false;

	}
}
