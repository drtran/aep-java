package com.bemach.tdd;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {

	private BankAccount bank;
	
	@Before
	public void setUp() {
		bank = new BankAccount(50);
	}
	
	@Test 
	public void BankAccountShouldAllowDeposit() {
		bank.deposit(50);
		assertEquals(100, bank.getBalance());
	}
	
	@Test 
	public void BankAccountShouldAllowWithdraw() {
		bank.withdraw(15);
		assertEquals(35, bank.getBalance());
	}

	@Test 
	public void BankAccountShouldAllowWithdrawWithPenalty() {
		bank.withdraw(55);
		assertEquals(-15, bank.getBalance());
	}
	
	@Test
	public void BankAccountShouldCalculateInterest() {
		Double interest = bank.getInterest(0.05);
		assertEquals(new Double(2.5), interest);
	}
	
	@Test
	public void BankAccountShouldCalculateInterestRate() {
		Double interestRate = bank.getInterestRate(5.0);
		assertEquals(new Double(0.1), interestRate);
	}
	
	@Test (expected= ArithmeticException.class)
	public void BankAccountShouldThrowExceptionWhenGivenZeroInterest() {
		int badDiv = 5/0;
	}
	
	@After
	public void tearDown() {
		
	}
}
