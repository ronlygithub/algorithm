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

package com.duanmh.math;

/**
 * @author duanmh
 * 
 */
public class Math {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
//		System.out.println(power(0, 0));
//		System.out.println(power(1, 0));
//		System.out.println(power(2.5, 100));
		int value = Integer.MAX_VALUE;
		System.out.println("my: "+sqrt(value));
		
		long end = System.currentTimeMillis();
		System.out.println("time spent: " + (end - start));
		System.out.println("system: "+java.lang.Math.sqrt(value));
		long current = System.currentTimeMillis();
		System.out.println("time spent: " + (current - end));
		System.out.println(sqrtNewTon(value));
		System.out.println("trible: "+ value +"  " + tribleNewTon(125));
	}

	@SuppressWarnings("unused")
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
	
	public static Double sqrt(double value){
		double low = 0;
		double high = value;
		double result = 0;
		double middle = 0;
		int count = 0;
		do {
			middle = low + ((high-low)/2);
			result = middle*middle;
			if (result > value) {
				high = middle;
			}else if(result < value){
				low = middle;
			}
			count++;
		} while (java.lang.Math.abs(result - value) > 0.000000000001);
		
		System.out.println("count: " + count);
		return middle;		
	}
	
	public static Double sqrtNewTon(double value){
		
		double tmp = 1;		
		double result = 10;
		int count = 0;
		do {
			tmp = result;
			result = (result + value/result)/2;
			count++;
			
		} while (java.lang.Math.abs(result - tmp) > 0.000000000001);
		System.out.println("count: " + count);
		return result;
		
	}
	public static Double tribleNewTon(double value){
		
		double tmp = 1;		
		double result = 10;
		int count = 0;
		do {
			tmp = result;
			result = (2*result + value/(result*result))/3;
			count++;
			
		} while (java.lang.Math.abs(result - tmp) > 0.000000000001);
		System.out.println("count: " + count);
		return result;
		
	}

}
