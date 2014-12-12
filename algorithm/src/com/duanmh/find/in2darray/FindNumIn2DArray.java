/************************* ��Ȩ���� *********************************
 * 
 * ��Ȩ���У�XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
 * 
 ************************* �����¼ *********************************
 *
 * �����ߣ�XXXXXXXXXX   �������ڣ� 2014��11��17��
 * ������¼��������ṹ��
 * 
 * �޸��ߣ�       �޸����ڣ�
 * �޸ļ�¼��
 *
 * �޸��ߣ�       �޸����ڣ�
 * �޸ļ�¼��
 * ����
 ************************* To  Do *********************************
 *
 * 1��ʵ������δʵ�ֵķ������׳�UnsupportedOperationException�ķ�������
 * 
 ************************* ��   �� *********************************
 *
 * �������дд���룬�п�������ʲô�ġ�
 * 
 ******************************************************************
 */

package com.duanmh.find.in2darray;

import java.util.Scanner;

/**
 * ��ά�������е���������һ�����ж��Ƿ���� [ {1,2,3}, {2,3,4}, {3,4,5}]
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

		System.out.println("����Ҫ���ҵ���: ");
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
