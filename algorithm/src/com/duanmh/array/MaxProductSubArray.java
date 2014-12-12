/************************* ��Ȩ���� *********************************
 * 
 * ��Ȩ���У�XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
 * 
 ************************* �����¼ *********************************
 *
 * �����ߣ�XXXXXXXXXX   �������ڣ� 2014��12��3��
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
public class MaxProductSubArray {

	public static void main(String[] args) {
		int[] a = { 2, 3, -2, 4 };
		maxProductSubArray(a);
	}

	private static int maxProductSubArray(int[] a) {

		if (a == null || a.length == 0) {
			return 0;
		}

		int max = a[0];
		int result = a[0];
		int min = a[0];
		for (int i = 1; i < a.length; i++) {
			int tmp = max;
			max = Math.max(Math.max(max * a[i], min * a[i]), a[i]);
			min = Math.min(Math.min(tmp * a[i], min * a[i]), a[i]);
			if (max > result) {
				result = max;
			}
		}

		return result;

	}
}
