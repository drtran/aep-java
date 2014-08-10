package com.bemach.tdd.tools.mortgage.solutions.ex1;

public class Calculator {
	private Double principle;
	private Double interestRate;
	
	public void setPrinciple(Double principle) {
		this.principle = principle;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public Double getMonthlyInterest() throws Exception {
		if (interestRate < 0) 
			throw new Exception("Interest cannot be negative!");
		return  (principle*(interestRate/12.0));
	}

}
