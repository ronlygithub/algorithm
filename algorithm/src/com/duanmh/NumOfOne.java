/************************* ��Ȩ���� *********************************
 * 
 * ��Ȩ���У�XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
 * 
 ************************* �����¼ *********************************
 *
 * �����ߣ�XXXXXXXXXX   �������ڣ� 2014��11��27��
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
