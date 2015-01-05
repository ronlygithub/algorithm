package com.duanmh.sort;

public class Data<T> implements Comparable<T> {

	T value = null;
	
	public Data(T value)
	{ 
		this.value=value; 
	}
	
	@Override
	public int compareTo(T o) {
		
		return 0;
	}

	
}
