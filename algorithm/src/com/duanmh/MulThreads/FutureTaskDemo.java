package com.duanmh.MulThreads;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {

	public static void main(String[] args) {

		// 初始化一个Callable对象和FutureTask对象；
		Callable<Integer> pAccount = new PrivateAccount();
		FutureTask<Integer> futureTask = new FutureTask<Integer>(pAccount); // 使用FutureTask创建一个线程
		System.out.println(System.nanoTime());
		// 启动线程
		Thread pAccountThread = new Thread(futureTask);
		pAccountThread.start();
		// 主线程执行自己的任务
		System.out.println("main ");
		// 从其他帐户获取总金额
		int totalMoney = new Random().nextInt(1000);
		System.out.println(" You have " + totalMoney + " in your other Accounts. ");
		System.out.println(" Waiting");
		// 测试后台的就计算线程是否完成，如果未完成，等待
		while (!futureTask.isDone()) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("future task ends at " + System.nanoTime());
		Integer privataAccountMoney = null;
		// 如果后台的FutureTask计算完成，则返回计算结果

		try {
			privataAccountMoney = futureTask.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		System.out.println("total monuey " + (totalMoney + privataAccountMoney.intValue()));

	}
}

// 创建一个Callable类，模拟计算一个私有帐户中的金额
class PrivateAccount implements Callable<Integer> {
	Integer totalMoney;

	@Override
	public Integer call() throws Exception {
		// 为了延长计算时间，这里暂停几秒
		Thread.sleep(5000);
		totalMoney = new Integer((int) (Math.random() * 1000));
		System.out.println(" You have " + totalMoney + " in your private Account. ");
		return totalMoney;
	}

}
