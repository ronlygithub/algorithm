/************************* ��Ȩ���� *********************************
 * 
 * ��Ȩ���У�XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
 * 
 ************************* �����¼ *********************************
 *
 * �����ߣ�XXXXXXXXXX   �������ڣ� 2014��11��28��
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

/**
 * @author duanmh
 * 
 */
public class MinNum {
	public static void main(String[] args) {
		int[] array = { 3, 32, 321 };

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}

		getMinNum(array);

	}

	public static void getMinNum(int[] aray) {
		if (aray == null || aray.length == 0) {
			return;
		}

		String[] b = new String[aray.length];
		for (int i = 0; i < aray.length; i++) {
			b[i] = String.valueOf(aray[i]);
		}

		quick_sort(b, 0, b.length - 1);

		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i]);
		}

	}

	public static int compare(String numa, String numb) {
		String ab = numa + numb;
		String ba = numb + numa;

		return ab.compareTo(ba);

	}

	// ��������
	private static void quick_sort(String array[], int left, int right) {
		if (left < right) {
			// Swap(s[l], s[(l + r) / 2]); //���м��������͵�һ�������� �μ�ע1
			int i = left, j = right;
			String x = array[left];
			while (i < j) {
				while (i < j && compare(array[j], x) >= 0)
					// ���������ҵ�һ��С��x����
					j--;
				if (i < j)
					array[i++] = array[j];

				while (i < j && compare(array[i], x) < 0)
					// ���������ҵ�һ�����ڵ���x����
					i++;
				if (i < j)
					array[j--] = array[i];
			}
			array[i] = x;
			quick_sort(array, left, i - 1); // �ݹ����
			quick_sort(array, i + 1, right);
		}
	}
}
