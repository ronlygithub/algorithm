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

package com.duanmh.power;

/**
 * @author duanmh
 * 
 */
public class Power {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(power(0, 0));
		System.out.println(power(1, 0));
		System.out.println(power(2.5, 100));
		long end = System.currentTimeMillis();
		System.out.println("time spent: " + (end - start));
	}

	private static Double power(double base, int expent) {
		if (equals(base, 0.0)) {
			return 0.0;
		}
		if (expent == 0) {
			return 1.0;
		}

		int absExpent = expent;
		if (expent < 0) {
			absExpent *= -1;
		}
		Double unsignedPower = unsignedPower(base, absExpent);
		if (expent < 0) {
			unsignedPower = 1 / unsignedPower;
		}

		return unsignedPower;

	}

	private static Double unsignedPower(double base, int expent) {
		if (equals(base, 0.0)) {
			return 0.0;
		}
		if (expent == 0) {
			return 1.0;
		}
		int power = expent >> 1;
		Double result = unsignedPower(base, power);
		result = result * result;
		if ((expent & 0x1) == 1) {
			result *= base;
		}
		return result;
	}

	private static boolean equals(double numA, double numB) {
		if (numA - numB < 0.0000001) {
			return true;
		}
		return false;

	}

}
