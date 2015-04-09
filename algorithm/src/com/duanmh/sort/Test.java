package com.duanmh.sort;

import com.duanmh.io.StdOut;

public class Test {
	static int n = 10000;
	public static void main(String[] args) {
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			int value =	(int) (Math.random()*10*n);
			a[i] = value;
		}
		
		int[] b = { 45, 74, 56, 38, 40, 84 };
		QuickSort qsort = new QuickSort();
		qsort.quickSort(b, 0, b.length - 1);
		// StdOut.writeFile("g:/preOrder", a);
		// long start = System.currentTimeMillis();
		// @SuppressWarnings("unused")
		// SelectionSort selectionSort = new SelectionSort();
		// // selectionSort.sort(a);
		// @SuppressWarnings("unused")
		// InsertSort insertSort = new InsertSort();
		// ShellSort shellSort = new ShellSort();
		//
		// shellSort.sort(a);
		//
		// // InsertSort.show(a);
		// System.out.println(Sort.isSorted(b));
		// long end = System.currentTimeMillis();
		// System.out.println((end - start)/1000);
		System.out.println(SelectionSort.isSorted(a));
		StdOut.writeFile("g:/postOrder", a);
	}
}
