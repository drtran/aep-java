package com.bemach.mocking;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import org.junit.Test;

/**
 * BDD with JUnit Tests
 * 
 * Given
 * When 
 * Then
 * 
 * @author ktran
 *
 */
public class FlowerTest1 {
	public static final int TEST_NUMBER_OF_LEAFS = 5;
	
	@Test
	public void shouldReturnGivenValueUsingBDDSemantics() {
		Flower flowerMock = mock(Flower.class);
		given(flowerMock.getNumberOfLeafs()).willReturn(TEST_NUMBER_OF_LEAFS);
		int numberOfLeafs = flowerMock.getNumberOfLeafs();
		assertEquals(numberOfLeafs, TEST_NUMBER_OF_LEAFS);
	}
}
