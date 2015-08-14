package com.bemach.unittest;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.hamcrest.core.CombinableMatcher;
import org.junit.Assert;
import org.junit.Test;

public class AssertTests {
	@Test
	public void shouldAssertArrayOfBytes() {
		byte[] expected = "trial".getBytes();
		byte[] actual = "trial".getBytes();
		assertArrayEquals(expected, actual);
	}

	@Test
	public void shouldAssertArrayOfStrings() {
		String[] expected = {"String 1", "String 2"};
		String[] actual = {"String 1", "String 2"};
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testAssertTrue() {
		org.junit.Assert.assertTrue(true);
	}
	
	@Test
	public void shouldAssertFalse() {
		assertFalse(false);
	}

	@Test
	public void shouldAssertNotNull() {
		assertNotNull(new Object());
	}

	@Test
	public void testAssertNotSame() {
		String expected = "String 1";
		String actual = "String 2";
		org.junit.Assert.assertNotSame(expected, actual);
	}

	@Test
	public void shouldAssertNull() {
		assertNull(null);
	}

	@Test
	public void shouldAssertSame() {
		Integer expected = Integer.valueOf(768);
		Integer actual = Integer.valueOf(768);
		assertSame(expected, expected);
	}
	
	@Test
	public void shouldAssertNotSame() {
		Integer expected = Integer.valueOf(768);
		Integer actual = Integer.valueOf(768);
		assertNotSame(expected, actual);
	}
	
	// JUnit Matchers assertThat
	@Test
	public void shouldAssertThatBothContainsString() {
		String expected = "an element";
		Assert.assertThat(expected, CoreMatchers.both(CoreMatchers.containsString("an"))
												 .and(CoreMatchers.containsString("ment")));
	}

	@Test
	public void shouldAssertThathasItemsContainsString() {
		List<String> expected = Arrays.asList(new String[] {"String 1", "String 2", "String 3", "String 4"});;
		String[] actual = {"String 2", "String 4"};
		Assert.assertThat(expected, CoreMatchers.hasItems(actual));
	}

	@Test
	public void shouldAssertThatEveryItemContainsString() {
		List<String> expected = Arrays.asList(new String[] { "fun", "ban", "net" });
		assertThat(expected, CoreMatchers.everyItem(CoreMatchers.containsString("n")));
	}

	@Test
	public void shouldAssertCoreMatchersStrings() {
		String expected = "Good Morning!";
		assertThat(expected, allOf(equalTo("Good Morning!"), startsWith("Good")));
		assertThat(expected, not(allOf(equalTo("bad"), equalTo("Good"))));
		assertThat(expected, anyOf(equalTo("bad"), endsWith("Morning!")));
		
		String expectedString = new String("My String");
		String actualString = new String("My String");
		assertThat(expectedString, not(sameInstance(actualString)));
	}

	@Test
	public void shouldAssertCoreMatchersIntegers() {
		Integer expected = Integer.valueOf(7);
		assertThat(expected, not(CombinableMatcher.<Integer> either(equalTo(3)).or(equalTo(4))));
	}
	
	
}