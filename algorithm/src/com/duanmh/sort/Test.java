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
		
		int[] b = {2,1,0,4};
		
		StdOut.writeFile("g:/preOrder", a);
		long start = System.currentTimeMillis();
		SelectionSort selectionSort = new SelectionSort();
//		selectionSort.sort(a);
		InsertSort insertSort = new InsertSort();
		ShellSort shellSort = new ShellSort();
	
		shellSort.sort(a);
		
//		InsertSort.show(a);
		System.out.println(Sort.isSorted(b));
		long end = System.currentTimeMillis();
		System.out.println((end - start)/1000);
		System.out.println(SelectionSort.isSorted(a));
		StdOut.writeFile("g:/postOrder", a);
	}
}