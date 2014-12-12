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

package com.duanmh.power;

/**
 * @author duanmh
 * 
 */
public class Power {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(power(0, 0));
		System.out.println(power(1, 0));
		System.out.println(power(2.5, 100));
		long end = System.currentTimeMillis();
		System.out.println("time spent: " + (end - start));
	}

	private static Double power(double base, int expent) {
		if (equals(base, 0.0)) {
			return 0.0;
		}
		if (expent == 0) {
			return 1.0;
		}

		int absExpent = expent;
		if (expent < 0) {
			absExpent *= -1;
		}
		Double unsignedPower = unsignedPower(base, absExpent);
		if (expent < 0) {
			unsignedPower = 1 / unsignedPower;
		}

		return unsignedPower;

	}

	private static Double unsignedPower(double base, int expent) {
		if (equals(base, 0.0)) {
			return 0.0;
		}
		if (expent == 0) {
			return 1.0;
		}
		int power = expent >> 1;
		Double result = unsignedPower(base, power);
		result = result * result;
		if ((expent & 0x1) == 1) {
			result *= base;
		}
		return result;
	}

	private static boolean equals(double numA, double numB) {
		if (numA - numB < 0.0000001) {
			return true;
		}
		return false;

	}

}
