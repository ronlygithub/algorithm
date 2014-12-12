/************************* ��Ȩ���� *********************************
 * 
 * ��Ȩ���У�XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
 * 
 ************************* �����¼ *********************************
 *
 * �����ߣ�XXXXXXXXXX   �������ڣ� 2014��12��8��
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
public class SumOfValue {

	public static void main(String[] args) {
		int a[] = { 2, 4, 5, 6, 7, 8, 9, 11, 15 };
		getSumofValue(a, 15);
	}

	public static void getSumofValue(int array[], int value) {
		if (array == null || array.length < 2) {
			return;
		}

		int left = 0;
		int right = array.length - 1;

		while (left < right) {
			int sum = array[left] + array[right];
			if (sum == value) {
				System.out.println(value + " = " + array[left] + " + "
						+ array[right]);
				left++;
				right--;

			} else if (sum > value) {
				right--;

			} else if (sum < value) {
				left++;
			}
		}
	}
}
