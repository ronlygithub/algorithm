package com.duanmh.MulThreads;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CircleBarriaerDemo {

	private static int[] timeForWalk = { 5, 8, 15 };
	private static int[] timeForSelf = { 1, 3, 4 };
	// 旅游大巴
	private static int[] timeForBus = { 2, 4, 6 };

	static String nowTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(new Date()) + ": ";
	}

	static class Tour implements Runnable {
		private int[] timeForUse;
		private CyclicBarrier barrier;
		private String tourName;

		public Tour(CyclicBarrier barrier, String tourName, int[] timeForUse) {
			this.timeForUse = timeForUse;
			this.tourName = tourName;
			this.barrier = barrier;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(timeForUse[0] * 1000);
				System.out.println(nowTime() + tourName + "reached shenzhen");
				barrier.await();//
				Thread.sleep(timeForUse[1] * 1000);
				System.out.println(nowTime() + tourName + " Reached Guangzhou");
				barrier.await();// 到达中转
				Thread.sleep(timeForUse[2] * 1000);
				System.out.println(nowTime() + tourName + " Reached chongqing");

			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	}

	public static void main(String[] args) { // 三个旅行
		Runnable runner = new Runnable() {
			@Override
			public void run() {
				System.out.println("we are all here");
			}
		};
		CyclicBarrier barrier = new CyclicBarrier(4, runner);
		// 使用线程
		ExecutorService exec = Executors.newFixedThreadPool(4);

		exec.submit(new Tour(barrier, "WalkTou", timeForWalk));
		exec.submit(new Tour(barrier, "SelfTou", timeForSelf));
		exec.submit(new Tour(barrier, "BusTour", timeForBus));
		exec.submit(new Tour(barrier, "BusTour", timeForBus));
		exec.shutdown();
	}
}
