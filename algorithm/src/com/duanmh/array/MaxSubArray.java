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

package com.duanmh.array;

/**
 * @author duanmh
 * 
 */
public class MaxSubArray {
	static boolean invalida = false;

	public static void main(String[] args) {
		// int[] array = { 1, 2, -4, 5, 9, -7 };
		int[] array = { 0, -1, -22, 4 };
		int maxSubArray = getMaxSubArray(array);
		System.out.println(maxSubArray);
	}

	private static int getMaxSubArray(int[] array) {
		if (array == null || array.length == 0) {
			invalida = true;
			return -1;
		}

		invalida = false;
		int currentSum = 0;
		int greatSum = array[0];
		for (int i = 0; i < array.length; i++) {
			if (currentSum <= 0) {
				currentSum = array[i];
			} else {
				currentSum += array[i];
			}

			if (greatSum < currentSum) {
				greatSum = currentSum;
			}
		}

		return greatSum;

	}
}
