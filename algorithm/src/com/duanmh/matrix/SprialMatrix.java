package com.duanmh.matrix;

import java.util.ArrayList;
import java.util.List;

public class SprialMatrix {
	List<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) {
		
		
		int[][] array = { { 1, 2, 3, 0 }, { 4, 5, 6, 0 }, { 7, 8, 9, 0 },
				{ 10, 10, 10, 10 } };
		printMatrix(array, 1, 3);
	}

	public static void printMatrix(int[][] array, int row, int colum) {
		if (array == null || row <= 0 || colum <= 0 || array.length==0) {
			return;
		}

		int start = 0;
		while ((row > 2 * start) && (colum > 2 * start)) {
			print(array, row, colum, start);
			start++;
		}
	}

	public static void print(int[][] array, int row, int colum, int start) {
		if (array == null || row <= 0 || colum <= 0) {
			return;
		}

		int realRow = row - start - 1;
		int realColum = colum - start - 1;
		for (int i = start; i <= realColum; i++) {
			System.out.print(array[start][i] + " ");
		}

		if (start < realRow) {
			for (int i = start + 1; i <= realRow; i++) {
				System.out.print(array[i][realColum] + " ");
			}
		}

		if (start < realRow && start < realColum) {
			for (int i = realColum - 1; i >= start; i--) {

				System.out.print(array[realRow][i] + " ");

			}
		}

		if (start < realRow-1 && start < realColum) {
			for (int i = realRow - 1; i > start; i--) {
				System.out.print(array[i][start] + " ");
			}
		}
		
		

	}

}
