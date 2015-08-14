package com.bemach.mocking;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import org.junit.Test;

public class BddMocking {
	public static final int TEST_NUMBER_OF_LEAFS = 5;
	@Test
	public void shouldReturnGivenValueUsingBDDSemantics() {
		// given
		Flower flowerMock = mock(Flower.class);
		given(flowerMock.getNumberOfLeafs()).willReturn(TEST_NUMBER_OF_LEAFS);
		// when
		int numberOfLeafs = flowerMock.getNumberOfLeafs();
		// then
		assertEquals(numberOfLeafs, TEST_NUMBER_OF_LEAFS);
	}
}
