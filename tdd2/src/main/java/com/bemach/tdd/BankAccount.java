package com.bemach.tdd;

public class BankAccount {

	private int balance;

	public int getBalance() {
		return balance;
	}

	public BankAccount(int i) {
		balance = i;
	}

	public void deposit(int i) {
		balance += i;
	}

	public void withdraw(int i) {
		balance -= i;
		if (balance < 0)
			balance -= 10;
	}

	public Double getInterest(double d) {
		return balance*d;
	}

	public Double getInterestRate(double d) throws ArithmeticException {
		return (balance/d)/100.0;
	}

}
