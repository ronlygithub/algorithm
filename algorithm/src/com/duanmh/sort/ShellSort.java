package com.duanmh.sort;

public class ShellSort extends Sort{

	public void sort(int[] a){		
		
		int length = a.length;
		int h =1;
		@SuppressWarnings("unused")
		int N = length /3;
		while(h < length/3)
			h = 3*h+1;
		// 步长h 为1时，退化为插入排序
			while (h>=1) {
				for (int i = h; i < length; i++) {
					for (int j = i ; j >=h && a[j] < a[j-h]; j-=h) {
						exchange(a, j, j-h);
					}
				}
				h/=3;
			}
			
		
		
		
		
	}
	
}
