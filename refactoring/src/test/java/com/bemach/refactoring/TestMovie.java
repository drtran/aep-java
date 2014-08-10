package com.bemach.refactoring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TestMovie {
	@Test
	public void CanCreateAMovieObject() {
		// AAA: Arrange, Act, and Assert
		Movie movie = Movie.newNewRelease("Gone With the Wind");
		assertNotNull(movie);
	}
	
	@Test 
	public void CanGetAMovieName() {
		Movie movie = Movie.newChildrens("Gone With the Wind - Blockbuster Release");
		String movieName = movie.getName();
		assertEquals("Gone With the Wind - Blockbuster Release", movieName);
	}
	
	@Test 
	public void CanGetAMoviePrice() {
		Movie movie = Movie.newRegular("Gone With the Wind - Blockbuster Release");
		int moviePrice = movie.getPriceCode();
		assertEquals(Movie.REGULAR, moviePrice);
	}

}
