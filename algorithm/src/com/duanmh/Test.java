/************************* ��Ȩ���� *********************************
 * 
 * ��Ȩ���У�XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
 * 
 ************************* �����¼ *********************************
 *
 * �����ߣ�XXXXXXXXXX   �������ڣ� 2014��11��12��
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
/**
 * @author duanmh
 * 
 */
public class Test {

	public static void main(String[] args) {
		String[] param = {"100","30"};
		// MergeBars.main(param);
		
		
//		StdDraw.show(3);
		System.out.println(sqrt(3));
	}

	public static int getMaxMinus(int a[]) {

		if (a == null || a.length < 2) {
			return -1;
		}
		int maxMinus = a[0] - a[1];
		int minInArray = a[0];
		int maxInArray = a[0];
		for (int i = 0; i < a.length; i++) {
			if (a[i] < minInArray) {
				minInArray = a[i];
			}

			if (a[i] > maxInArray) {
				maxInArray = a[i];
			}
		}

		maxMinus = maxInArray - minInArray;
		System.out.println("max=" + maxInArray + " , min=" + minInArray);

		return maxMinus;

	}

	public static int sqrt(int x) {
		if (x <= 0) {
			return 0;
		}
		double x0 = 1;
		double tmp = 0;
		do {
			tmp = x0;
			x0 = (x0 + x / x0) / 2;
		} while (Math.abs(x0 - tmp) > 0.000001);
		return (int) x0;
	}
	
	

}
