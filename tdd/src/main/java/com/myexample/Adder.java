package com.myexample;

import java.math.BigDecimal;

public class Adder {

	private BigDecimal accumulator = BigDecimal.ZERO;

	public BigDecimal getAccumulator() {
		return accumulator;
	}

	public void setAccumulator(BigDecimal value) {
		accumulator = value;
	}

}
