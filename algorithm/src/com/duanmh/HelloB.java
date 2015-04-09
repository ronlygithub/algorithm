package com.duanmh;
public class HelloB extends Thread {

	private int id;
	private int index = 0;

	private static int[] values = new int[20];
	private static Integer n = values[0];

	private static final Object lock = new Object();

	public HelloB(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		while (index < values.length) {
			synchronized (lock) {
				if (n % 2 != id) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (index < values.length) {
					System.out.println("Thread-" + id + " : " + values[index]);
					n = values[index];
					index++;
				}
				lock.notifyAll();
			}
		}
	}

	public static void main(String[] args) {

		for (int i = 0; i < values.length; i++) {
			values[i] = (int) (Math.random() * 10);
		}
		Thread t0 = new HelloB(0);
		Thread t1 = new HelloB(1);


		t0.start();
		t1.start();

	}

}
