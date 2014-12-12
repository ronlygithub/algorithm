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
public class SumOfSubArray {
	public static void main(String[] args) {

		int a[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		getSumOfSubArray(a, 1);
	}

	public static void getSumOfSubArray(int array[], int sum) {
		if (array == null || array.length == 0) {
			return;
		}

		int small = 0;
		int big = 1;
		int middle = (1 + sum) / 2;
		int currentSum = array[small] + array[big];
		while (small <= middle) {
			if (currentSum < sum && big < array.length - 1) {
				currentSum = currentSum + array[++big];
			} else if (currentSum > sum) {
				currentSum -= array[small++];
			} else if (big < array.length - 1) {
				System.out.println("small: " + array[small] + " big: "
						+ array[big]);
				currentSum = currentSum + array[++big];

			} else {
				break;
			}

		}
	}
}
