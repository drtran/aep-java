package com.bemach.rentals;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TestMovie {
	@Test
	public void CanCreateAMovieObject() {
		// AAA: Arrange, Act, and Assert
		Movie movie = new Movie("Gone With the Wind", Movie.NEW_RELEASE);
		assertNotNull(movie);
	}
	
	@Test 
	public void CanGetAMovieName() {
		Movie movie = new Movie("Gone With the Wind - Blockbuster Release", Movie.CHILDRENS);
		String movieName = movie.getName();
		assertEquals("Gone With the Wind - Blockbuster Release", movieName);
	}
	
	@Test 
	public void CanGetAMoviePrice() {
		Movie movie = new Movie("Gone With the Wind - Blockbuster Release", Movie.REGULAR);
		int moviePrice = movie.getPriceCode();
		assertEquals(Movie.REGULAR, moviePrice);
	}

}
