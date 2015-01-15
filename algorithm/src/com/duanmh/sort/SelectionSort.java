package com.duanmh.sort;
/**
 * —°‘Ò≈≈–Ú
 * @author Administrator
 *
 */
public class SelectionSort extends Sort  {

	public void sort(int [] a) {
		
		for (int i = 0; i < a.length; i++) {			
			for (int j = i+1; j < a.length; j++) {
				if (a[i]>a[j]) {
					exchange(a, i, j);
				}
			}
		}
		
	}		
	

}
