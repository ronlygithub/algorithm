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
