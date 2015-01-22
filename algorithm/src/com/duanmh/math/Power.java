package com.duanmh.math;

public class Power {

	public static void main(String[] args) {
		System.out.println(power(2, -3));
	}

	public static double power(double x, int n) {
		double result = 0;
		if (n < 0) {
			result = powerPosi(x, n * -1);
			result = result < Double.MIN_EXPONENT ? 0 : 1 / result;
		} else {
			result = powerPosi(x, n);
		}

		return result;

	}

	public static double powerPosi(double x, int n) {
		if (n == 0 || x == 1) {
			return 1;
		}
		if (n == 1) {
			return x;
		}
		double result = powerPosi(x, n >> 1);
		result *= result;
		if ((n % 2) == 1) {
			result = result * x;
		}
		return result;
	}
}
