package edu.pennstate.test_maven_project;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCalculator {
	private Calculator calc;
	
	@Before
	public void setupCalculator() {
		calc = new Calculator();
	}
	
	@Test
	public void shouldBeAbleToCreateACalculator(){
		// AAA:
		assertNotNull(null, calc);
	}
	
	@Test
	public void shouldBeAbleToAddTwoNumbers() {
		int result = calc.add(2,3);
		assertEquals(5, result);
	}
}
