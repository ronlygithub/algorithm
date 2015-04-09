package com.duanmh;


public class ThreadReadDeamo extends Thread {

	private int sum = 0;
	public static void main(String[] args) {
		ThreadReadDeamo ts = new ThreadReadDeamo();
		Thread t1 = new Thread(ts);
		Thread t2 = new Thread(ts);

		t1.start();
		t2.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(ts.sum);
	}

	@Override
	public void run() {
		for (int i = 1; i <= 50; i++) {
			sum = sum + i;
		}
	}
}

class T1 extends Thread {
	private String name;

	public T1(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name + "Ñ­»·" + i);
		}
	}
}




