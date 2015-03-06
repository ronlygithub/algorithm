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
	String str = new String("good");
	char[] c = { 'a', 'b', 'c' };
	public static void main(String[] args) {
		Test t = new Test();
		t.exchange(t.str, t.c);

	}

	public static int getMaxMinus(int a[]) {

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

	public static int sqrt(int x) {
		if (x <= 0) {
			return 0;
		}
		double x0 = 1;
		double tmp = 0;
		do {
			tmp = x0;
			x0 = (x0 + x / x0) / 2;
		} while (Math.abs(x0 - tmp) > 0.000001);
		return (int) x0;
	}
	
	public void exchange(String str, char[] c) {
		str = "test ok";
		c[0] = 'a';
	}
	

	



}
