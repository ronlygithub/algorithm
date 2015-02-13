package com.duanmh.array;

public class MatrixRotate {

	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate(a);
	}

	public static void rotate(int[][] matrix) {

		if (matrix.length == 0 || matrix.length == 1) {
			return;
		}

		int temp = 0;
		int n = matrix.length - 1;

		for (int i = 0; i < matrix.length - 1; i++) {
			for (int j = 0; j + i < n; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[n - j][n - i];
				matrix[n - j][n - i] = temp;
			}
		}

		for (int i = 0; i < matrix.length / 2; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[n - i][j];
				matrix[n - i][j] = temp;
			}
		}
	}
}
