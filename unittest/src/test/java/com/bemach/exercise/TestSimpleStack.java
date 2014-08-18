package com.bemach.exercise;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestSimpleStack {
	private SimpleStack<BigDecimal> stack;
	
	@Before
	public void SetUp() {
		stack = new SimpleStack<BigDecimal>();
	}
	
	@Test
	public void NewStackShouldHaveZeroItem() {
		// Arrange, Act, Assert
		assertEquals(0,stack.size());
	}
	
	@Test (expected=ArrayIndexOutOfBoundsException.class)
	public void PopEmptyStackShouldCauseAnException() {
		stack.pop();
	}
	
	@Test
	public void CanPushOneItemIntoStack() {
		BigDecimal value1 = new BigDecimal(5);
		stack.push(value1);
		assertEquals(value1,stack.pop());
		assertEquals(0,stack.size());
	}
	
	@Test
	public void CanPushTwoItemsIntoStack() {
		BigDecimal value1 = new BigDecimal(25);
		BigDecimal value2 = new BigDecimal(15);
		stack.push(value1);
		stack.push(value2);
		assertEquals(value2,stack.pop());
		assertEquals(value1,stack.pop());
		assertEquals(0,stack.size());
	}
	
	@After
	public void TearDown() {
		
	}
}
