package com.duanmh.MulThreads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingDeque {

	public static void main(String[] args) {
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(5);
		Producer p = new Producer(queue);
		Consumer c1 = new Consumer(queue, "c1");
		Consumer c2 = new Consumer(queue, "c2");
		new Thread(p).start();
		new Thread(c1).start();
		new Thread(c2).start();
	}
}

class Producer implements Runnable {

	private final BlockingQueue<String> queue;

	public Producer(BlockingQueue<String> q) {
		queue = q;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				queue.put(produce());
			}

		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	public String produce() {
		String temp = "" + (char) ('A' + (int) (Math.random() * 26));
		System.out.println("temp is " + temp);
		return temp;
	}
}

class Consumer implements Runnable {
	private final BlockingQueue<String> queue;
	private String name;

	public Consumer(BlockingQueue<String> queue, String name) {
		this.queue = queue;
		this.name = name;
	}


	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				consume(queue.take());
			}

		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}

	}

	void consume(String x) {
		System.out.println("consume " + name + " " + x);
	}
}
