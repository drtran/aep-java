package com.bemach.unittest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSimpleCalculator {
	private SimpleCalculator simpleCalculator;

	@BeforeClass
	public static void setUpClass() {
	
	}
	
	@Before
	public void setUp() {
		simpleCalculator = new SimpleCalculator();
	}
	
	@Test
	public void addTwoValues() {
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
	public void tearDown() {
		
	}
}
