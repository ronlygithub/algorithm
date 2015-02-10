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

import java.util.Scanner;

/**
 * @author duanmh
 * 
 */
public class NumOfOne {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int nextInt = s.nextInt();
		while (nextInt != -1) {
			int numOfOne = getNumOfOne(nextInt);
			System.out.println(numOfOne);
			nextInt = s.nextInt();
		}

	}

	private static int getNumOfOne(int value) {

		int i = 1;
		int before;
		int after;
		int current;
		int count = 0;
		while (value / i != 0) {

			before = value / (i * 10);
			current = value / i % 10;
			after = value - value / i * i;

			if (current > 1) {
				count += (before + 1) * i;
			} else if (current == 0) {
				count += before * i;
			} else if (current == 1) {
				count += before * i + after + 1;
			}

			i *= 10;

		}
		return count;

	}
}
