package com.duanmh.MulThreads;

public class BankAccount {
	@SuppressWarnings("unused")
	private int number;

	private int balance;

	public BankAccount(int number, int balance) {
		this.number = number;
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}

	public synchronized void deposit(int amount) {
		// System.out.println("deposit");
		balance = balance + amount;
	}

	public synchronized void withdraw(int amount) {
		// System.out.println("withdraw");
		balance = balance - amount;
	}

	public static void main(String[] args) throws InterruptedException {
		BankAccount a = new BankAccount(1, 1000);
		Thread t1 = new Thread(new Depositor(a, 100), "depositor");
		Thread t2 = new Thread(new Withdrawer(a, 100), "withdraw");
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(a.getBalance());
	}

	static class Depositor implements Runnable {
		BankAccount account;
		int amount;

		public Depositor(BankAccount account, int amount) {
			this.account = account;
			this.amount = amount;
		}

		@Override
		public void run() {
			System.out.println("depositor is running");
			for (int i = 0; i < 500000; i++) {
				account.deposit(amount);
			}
			System.out.println("depositor is end");
		}
	}

	static class Withdrawer implements Runnable {
		BankAccount account;
		int amount;

		public Withdrawer(BankAccount account, int amount) {
			this.account = account;
			this.amount = amount;
		}

		@Override
		public void run() {
			System.out.println("withdrawer is running");
			for (int i = 0; i < 500000; i++) {
				account.withdraw(amount);
			}
			System.out.println("withdrawer is end");
		}
	}

}
