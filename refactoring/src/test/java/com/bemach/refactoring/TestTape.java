package com.bemach.refactoring;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TestTape {
	@Test
	public void CanCreateATapeObject(){
		// AAA: Arrange, Act, Assert.
		Movie movie = Movie.newNewRelease("Gone with the Wind");
		Tape tape = new Tape("12345", movie);
		assertNotNull(tape);
	}
	
	@Test
	public void CanGetAMovie(){
		// AAA: Arrange, Act, Assert.
		Movie movie = Movie.newNewRelease("Gone with the Wind");
		Tape tape = new Tape("12345", movie);
		assertNotNull(tape.getName());
	}
}
