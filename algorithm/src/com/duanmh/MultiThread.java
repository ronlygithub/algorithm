package com.duanmh;

public class MultiThread {

	public static void main(String[] args) {

		Thread[] odd = new Thread[5];
		for (int i = 0; i < odd.length; i++) {
			odd[i] = new Thread(new Thread1());
		}

		Thread[] even = new Thread[5];
		for (int i = 0; i < even.length; i++) {
			even[i] = new Thread(new Thread2());
		}

		for (int i = 0; i < 5; i++) {
			even[i].start();
			odd[i].start();
		}


	}

	private static class Thread1 extends Thread {
		@SuppressWarnings("unused")
		private int posi;
		@SuppressWarnings("unused")
		private int[] value;

		@SuppressWarnings("unused")
		public Thread1(int[] value, int posi) {
			this.posi = posi;
			this.value = value;
		}

		public Thread1() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public void run() {
			synchronized (MultiThread.class) {
				System.out.println("enter thread1");
				System.out.println("thread1 is waiting");
				try {
					MultiThread.class.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}

				System.out.println("thread1 is going on");
				System.out.println("thread1 is over");
			}

		}

	}

	private static class Thread2 implements Runnable {

		@Override
		public void run() {
			synchronized (MultiThread.class) {
				System.out.println("enter thread2");
				System.out.println("thread2 notify other to relase wait lock");
				MultiThread.class.notify();
				try {
					System.out.println("thread2 is sleeping 10 ms");
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}

				System.out.println("thread2 is going on");
				System.out.println("thread2 is over");
			}

		}
	}


}

