package com.duanmh.add;

public class BitAdd {
	
	public static void main(String[] args) {
		System.out.println(add(5,5));
	}
	
	public static int add(int num1, int num2){
		int sum,carray = 0;
		
		do {
			sum = num1^num2;
			carray = (num1&num2)<<1;
			num1 = sum;
			num2 = carray;			
		} while (num2!=0);		
		
		return sum;
		
	}

}
