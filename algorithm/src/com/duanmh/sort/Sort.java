package com.duanmh.sort;

public  class Sort {
	public  void sort(int[] a ){
		
	}
	
	public  int less(int v, int b){
		return 0;
		
	}	

	
	public static boolean isSorted(int[] a) {
		for (int i = 0; i < a.length-1; i++) {
			if (a[i]>a[i+1]) {
				return false;
			}
		}
		return true;
	}

	public static void show(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
			System.out.println("\n");
		}
		
	}

	public static void exchange(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
		
	}
}
