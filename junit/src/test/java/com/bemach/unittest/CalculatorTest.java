package com.bemach.unittest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(value=Parameterized.class)
public class CalculatorTest {
	private int value1;
	private int value2;
	private int expected;
	
	@Before
	public void setup() {
		
	}
	
	@Parameters
	public static Collection<Integer[]> getTestParameters() {
		return Arrays.asList(new Integer[][] {
				{2, 1, 1}, 
				{9, -1, 10},
				{-3, -2, -1},
				{-5, 1, -6},
				{0, 0, 0}
		});
	}
	
	public CalculatorTest(int expected, int value1, int value2) {
		this.expected = expected;
		this.value1 = value1;
		this.value2 = value2;
	}
	
	@Test
	public void testAddingTwoValues() {
		Calculator calculator = new Calculator();
		int result = calculator.add (value1, value2);
		assertEquals(expected, result);
	}

	@Test(expected=ArithmeticException.class)
	public void DivideByZero() {
		Calculator calculator = new Calculator();
		calculator.divide(100, 0);
	}
	
	@After
	public void tearDown() {
		
	}
}
