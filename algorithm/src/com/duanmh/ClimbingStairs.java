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
public class ClimbingStairs {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " : " + climbStairs(i));
		}

	}

	public static int climbStairs(int n) {
		if (n <= 0) {
			return 0;
		}

		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}

		int count = 0;
		int n1 = 1;
		int n2 = 2;

		for (int i = 3; i <= n; i++) {
			count = n1 + n2;
			n1 = n2;
			n2 = count;
		}
		return count;

	}
}
