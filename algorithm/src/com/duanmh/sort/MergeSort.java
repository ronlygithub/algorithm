/************************* ��Ȩ���� *********************************
 * 
 * ��Ȩ���У�XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
 * 
 ************************* �����¼ *********************************
 *
 * �����ߣ�XXXXXXXXXX   �������ڣ� 2014��12��4��
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

package com.duanmh.sort;

/**
 * @author duanmh
 * 
 */
public class MergeSort {

	private static int[] tmp;

	public static void main(String[] args) {

		int[] a = { 2, 4, 1, 8, 6, 3, 9, 5, 47, -5 };
		tmp = new int[a.length];
		mergeUP(a);
		mergeDownSort(a, 0, a.length - 1);
		System.out.println("\n");

	}

	private static void mergeDownSort(int[] array, int low, int high) {
		if (array == null || array.length == 0) {
			return;
		}

		if (low >= high) {
			return;
		}

		int middle = low + ((high - low) >> 1);
		mergeDownSort(array, low, middle);
		mergeDownSort(array, middle + 1, high);
		merge(array, low, high, middle);
	}

	private static void merge(int[] array, int low, int high, int middle) {

		int i = low;
		int j = middle + 1;

		for (int k = low; k <= high; k++) {
			tmp[k] = array[k];
		}

		for (int k = low; k <= high; k++) {
			if (i > middle) {
				array[k] = tmp[j++];
			} else if (j > high) {
				array[k] = tmp[i++];
			} else if (tmp[i] > array[j]) {
				array[k] = array[j++];
			} else if (tmp[i] <= array[j]) {
				array[k] = tmp[i++];
			}
		}
		show(array);
	}

	private static void mergeUP(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}

		int length = a.length;
		for (int i = 1; i < length; i += i) {
			for (int j = 0; j < length - i; j += i + i) {
				merge(a, j, Math.min(length - 1, j + i + i - 1), j + i - 1);
			}
		}

	}

	private static void show(int[] a) {
		if (a == null) {
			return;
		}

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("\n");
	}
}
