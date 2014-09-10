package com.bemach.mocking;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import org.junit.Test;

public class SimpleStubbingTest {
	public static final int TEST_NUMBER_OF_LEAFS = 5;

	@Test
	public void shouldReturnGivenValue() {
		Flower flowerMock = mock(Flower.class);
		when(flowerMock.getNumberOfLeafs()).thenReturn(TEST_NUMBER_OF_LEAFS);
		int numberOfLeafs = flowerMock.getNumberOfLeafs();
		assertEquals(numberOfLeafs, TEST_NUMBER_OF_LEAFS);
	}


}
