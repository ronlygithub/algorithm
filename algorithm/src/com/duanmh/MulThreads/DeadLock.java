package com.duanmh.MulThreads;
public class DeadLock {
	void harness2() throws InterruptedException {
		StringBuffer L1 = new StringBuffer("L1");
		StringBuffer L2 = new StringBuffer("L2");
		Thread t1 = new T3(L1, L2);
		Thread t2 = new T3(L2, L1);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}


	public static void main(String[] args) {
		DeadLock dlt = new DeadLock();
		try {
			dlt.harness2();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private class T3 extends Thread {
		StringBuffer L1;
		StringBuffer L2;

		public T3(StringBuffer L1, StringBuffer L2) {
			this.L1 = L1;
			this.L2 = L2;
		}

		@Override
		public void run() {
			synchronized (L1) {
				System.out.println(L1 + " is locked");
				synchronized (L2) {
					System.out.println(L1 + "is locked");
				}
			}
		}
	}
}
