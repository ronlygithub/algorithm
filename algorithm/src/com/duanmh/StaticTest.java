package com.duanmh;

public class StaticTest {

	
	/**
	 * @param args
	 */
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		a = null;
		b = null;
		a.show();
		b.show();
	}




}


