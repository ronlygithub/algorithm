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

/**
 * @author duanmh
 * 
 */
public class RotateArray {
	public static void main(String[] args) {
		// int[] a = { 2, 4, 1, 0, 6, 5 };
		// int[] quickSort = quickSort(a, 0, a.length - 1);
		System.out.println("t");
	}

	public static int findMin(int[] num) {
		if (num == null || num.length == 0) {
			return -1; // should throw an exception, not sure if leetcode
						// supports it
		}
		int left = 0;
		int right = num.length - 1;
		while (left < right) {
			if (num[left] < num[right]) {
				return num[left];
			}
			int middle = left + (right - left) / 2;
			if (num[left] > num[middle]) {
				right = middle;
			} else if (num[left] < num[middle]) {
				left = middle + 1;
			} else { // num[l] == num[m]
				if (num[left] == num[right]) {
					left++;
					right--;
				} else { // only the num[l] == num[m] > num[r] case left
					left = middle + 1;
				}
			}
		}
		return num[left];
	}

	public static int[] quickSort(int[] array, int left, int right) {
		if (left > right) {
			return array;
		}
		int low = partion(array, left, right);
		System.out.println("low" + low);
		show(array);
		quickSort(array, left, low - 1);
		quickSort(array, low + 1, right);

		return array;

	}

	private static void show(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("\n");
	}

	/**
	 * @param array
	 * @param left
	 * @param right
	 * @return
	 */
	private static int partion(int[] array, int left, int right) {

		int low = left;
		int heigh = right;
		int tmp = array[low];
		while (low < heigh) {
			while (low < heigh && tmp >= array[heigh]) {
				heigh--;
			}

			array[low] = array[heigh];
			while (low < heigh && array[low] >= tmp) {
				low++;
			}
			array[heigh] = array[low];
		}
		array[low] = tmp;
		return low;
	}

}
