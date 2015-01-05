package com.duanmh.sort;

public class InsertSort extends Sort {
	@Override
	public void sort(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}		
	
		int count = 0;
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0 ; j--) {
				if (a[j] < a[j-1]) {
					exchange(a, j-1, j);
//					count++;
				}
				
			}
		}
		
//		System.out.println("ÄæÐò¶ÔÊý£º " + count);
		
	}

}
