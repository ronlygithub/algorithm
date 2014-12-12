package com.duanmh.heap;
public class Heap {
	private int object[] ;
	private int size = 0;
	
	public static void main(String[] args) {
		int[] a = { 0, 1, 2, 3, 5, 6, 7 };
		Heap heap = new Heap(a);
	}
	
	public Heap(int[] object){		
		this.object = new int[object.length];
	}
	
	public void initData(int[] object) {
		int length = object.length;
		for (int i = 0; i < length; i++) {
			add(object[i]);
		}	
	}
	
	private boolean add(int e){
		

		int i = size;
		if (i == 0) {
			object[i] = e;
		}else {
			siftUp(i,e);
		}
		return true;
	}
	
	private boolean siftUp(int i, int e){
		while (i >0) {
			int parent = (i-1)>>1;
			if (object[parent] > e) {
				object[i] = object[parent];
				i = parent;
			} else {
				break;
			}
		}
		object[i] = e;
		return true;
	}
}
