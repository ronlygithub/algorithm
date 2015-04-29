package com.duanmh.MulThreads;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {

	public static void main(String[] args) {

		// ��ʼ��һ��Callable�����FutureTask����
		Callable<Integer> pAccount = new PrivateAccount();
		FutureTask<Integer> futureTask = new FutureTask<Integer>(pAccount); // ʹ��FutureTask����һ���߳�
		System.out.println(System.nanoTime());
		// �����߳�
		Thread pAccountThread = new Thread(futureTask);
		pAccountThread.start();
		// ���߳�ִ���Լ�������
		System.out.println("main ");
		// �������ʻ���ȡ�ܽ��
		int totalMoney = new Random().nextInt(1000);
		System.out.println(" You have " + totalMoney + " in your other Accounts. ");
		System.out.println(" Waiting");
		// ���Ժ�̨�ľͼ����߳��Ƿ���ɣ����δ��ɣ��ȴ�
		while (!futureTask.isDone()) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("future task ends at " + System.nanoTime());
		Integer privataAccountMoney = null;
		// �����̨��FutureTask������ɣ��򷵻ؼ�����

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

// ����һ��Callable�࣬ģ�����һ��˽���ʻ��еĽ��
class PrivateAccount implements Callable<Integer> {
	Integer totalMoney;

	@Override
	public Integer call() throws Exception {
		// Ϊ���ӳ�����ʱ�䣬������ͣ����
		Thread.sleep(5000);
		totalMoney = new Integer((int) (Math.random() * 1000));
		System.out.println(" You have " + totalMoney + " in your private Account. ");
		return totalMoney;
	}

}
