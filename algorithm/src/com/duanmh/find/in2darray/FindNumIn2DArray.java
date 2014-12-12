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

package com.duanmh.find.in2darray;

import java.util.Scanner;

/**
 * 二维数组行列递增，给定一个数判断是否存在 [ {1,2,3}, {2,3,4}, {3,4,5}]
 * 
 * @author duanmh
 * 
 */
public class FindNumIn2DArray {
	public static void main(String[] args) {
		int size = 3;
		int array[][] = { { 1, 2, 3 }, { 2, 3, 4 }, { 3, 4, 5 } };
		find(size, array);

	}

	/**
	 * @param size
	 * @param array
	 */
	private static void find(int size, int[][] array) {
		int num;
		boolean find = false;
		int rowNum = array.length;
		int colNum = array[0].length;
		if (array == null || rowNum <= 0 || colNum <= 0) {
			return;
		}

		System.out.println("输入要查找的数: ");
		Scanner scaner = new Scanner(System.in);
		num = scaner.nextInt();
		int col = colNum - 1;
		int row = 0;

		while (col >= 0 && row < rowNum) {
			if (array[row][col] == num) {
				find = true;
				break;
			} else if (array[row][col] > num) {
				col--;

			} else if (array[row][col] < num) {
				row++;
			}
		}

		if (find) {
			System.out.println("row: " + row + " col:" + col);
		} else {
			System.out.println("not find");
		}
	}
}
