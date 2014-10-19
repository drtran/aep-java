package com.bemach.unittest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSimpleCalculator {
	private SimpleCalculator simpleCalculator;

	@BeforeClass
	
	@Before
	public void SetUp() {
		simpleCalculator = new SimpleCalculator();
	}
	
	@Test
	public void AddTwoValues() {
		simpleCalculator = new SimpleCalculator();
		int result = simpleCalculator.add(100, 101);
		assertEquals(201, result);
	}
	
	@Test(expected=ArithmeticException.class)
	public void DivideByZero() {
		simpleCalculator = new SimpleCalculator();
		simpleCalculator.divide(100, 0);
	}
	
	@After
	public void TearDown() {
		// May be used for say closing a connection to db or similar thing.
	}
}
