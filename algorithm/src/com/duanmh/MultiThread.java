package com.duanmh;

public class MultiThread {

	public static void main(String[] args) {
		new Thread(new Thread1()).start();
		try {
			Thread.sleep(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
		new Thread(new Thread2()).start();
	}

	private static class Thread1 implements Runnable {

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

