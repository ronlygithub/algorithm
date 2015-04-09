package com.designpattern;

public class Singleton {

	private static Singleton instance;
	private static int count = 0;

	private Singleton() {
	}

	public synchronized static Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
					count++;
					System.out.println(count);
				}
			}

			
		}
		return instance;
	}

	public static void main(String[] args) {
		int j = 100;
		while (j > 0) {
			fun();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			j--;
		}


	}

	private static void fun() {
		Singleton sing = new Singleton();
		Thread t = new Thread(new Threads(sing, "t"));
		Thread t2 = new Thread(new Threads(sing, "t2"));
		Thread t3 = new Thread(new Threads(sing, "t3"));
		Thread t4 = new Thread(new Threads(sing, "t4"));
		Thread t5 = new Thread(new Threads(sing, "t5"));

		t.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}

class Threads implements Runnable {
	private Singleton o;
	private String name;

	public Threads(Singleton o, String name) {
		this.o = o;
		this.name = name;
	}

	@Override
	public void run() {
		int i = 0;
		while (i < 5) {
			int hashCode = o.getInstance().hashCode();
			// System.out.println(name + " " + hashCode);

			i++;
		}

	}

}
