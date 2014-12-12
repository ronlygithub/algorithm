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
public class ClimbingStairs {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " : " + climbStairs(i));
		}

	}

	public static int climbStairs(int n) {
		if (n <= 0) {
			return 0;
		}

		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}

		int count = 0;
		int n1 = 1;
		int n2 = 2;

		for (int i = 3; i <= n; i++) {
			count = n1 + n2;
			n1 = n2;
			n2 = count;
		}
		return count;

	}
}
