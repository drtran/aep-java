package com.bemach.mocking;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class FlowerTest2 {
	public static final int TEST_NUMBER_OF_LEAFS = 5;

	@Test
	public void shouldReturnGivenValue() {
		Flower flowerMock = mock(Flower.class);
		when(flowerMock.getNumberOfLeafs()).thenReturn(TEST_NUMBER_OF_LEAFS);
		int numberOfLeafs = flowerMock.getNumberOfLeafs();
		assertEquals(numberOfLeafs, TEST_NUMBER_OF_LEAFS);
	}


}
