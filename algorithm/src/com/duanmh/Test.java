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
public class Test {
	public static void main(String[] args) throws Exception {
		System.out.println(Test.test());
	}

	static int test() throws Exception {
		int x = 1;
		try {
			x++;
			return x;
		} finally {
			++x;
			System.out.println("finally " + x);
		}
	}
}



//数组分割问题2.cpp : Defines the entry point for the console application.
//


