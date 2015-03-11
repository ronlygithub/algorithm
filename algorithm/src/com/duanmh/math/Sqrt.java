package com.duanmh.math;

public class Sqrt {
	public int sqrt(int x) {
		if (x <= 0) {
			return 0;
		}
		double x0 = 1;
		double tmp = 0;
		do {
			tmp = x0;
			x0 = (x0 + x / x0) / 2;
		} while (java.lang.Math.abs(x0 - tmp) > 0.000001);
		return (int) x0;
	}
}

