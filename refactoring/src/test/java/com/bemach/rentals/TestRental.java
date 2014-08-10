package com.bemach.rentals;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TestRental {
	@Test
	public void CanCreateARentalObject() {
		// AAA: Arrange, Act, Assert.
		Movie movie = new Movie("Gone with the Wind", Movie.NEW_RELEASE);
		Tape tape = new Tape ("1234", movie);
		Rental rental = new Rental(tape, 5);
		assertNotNull(rental);
	}
	
	@Test
	public void CanGetATape() {
		Movie movie = new Movie("Gone with the Wind", Movie.NEW_RELEASE);
		Tape tape = new Tape ("1234", movie);
		Rental rental = new Rental(tape, 5);
		
		assertNotNull(rental.getTape());
	}

	@Test
	public void CanGetANumberOfDaysRented() {
		Movie movie = new Movie("Gone with the Wind", Movie.NEW_RELEASE);
		Tape tape = new Tape ("1234", movie);
		Rental rental = new Rental(tape, 5);
		
		assertEquals(5, rental.getDaysRented());
	}

}
