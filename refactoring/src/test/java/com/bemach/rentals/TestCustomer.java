package com.bemach.rentals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestCustomer {
	private Customer target;

	@Test
	public void shouldCreateInstance() {
		// AAA: Arrange, Act, Assert
		target = new Customer ("John Doe");
		assertNotNull(target);
	}
	
	@Test 
	public void shouldAddOneRental() {
		target = new Customer("John Doe");
		Movie goneWithTheWindMovie = new Movie("Gone With the Wind", Movie.NEW_RELEASE);
		Tape goneWithTheWindTape = new Tape("1234", goneWithTheWindMovie);
		Rental goneWithTheWindRental = new Rental (goneWithTheWindTape, 4);
		
		target.addRental(goneWithTheWindRental);
		String rentalStatement = target.getStatement();
		System.out.println(rentalStatement);
		assertFalse(rentalStatement.contains("Gone With the Wind 1"));
		assertTrue(rentalStatement.contains("Gone With the Wind"));
	}
	
	@Test 
	public void shouldAddTwoRentals() {
		target = new Customer("John Doe");
		Movie goneWithTheWindMovie = new Movie("Gone With the Wind", Movie.NEW_RELEASE);
		Movie drZhivagoMovie = new Movie("Doctor Zhivago", Movie.REGULAR);
		Tape goneWithTheWindTape = new Tape("1234", goneWithTheWindMovie);
		Tape drZhivagoTape = new Tape("1235", drZhivagoMovie);
		Rental goneWithTheWindRental = new Rental (goneWithTheWindTape, 4);
		Rental drZhivagoRental = new Rental (drZhivagoTape, 4);
		
		target.addRental(goneWithTheWindRental);
		target.addRental(drZhivagoRental);
		String rentalStatement = target.getStatement();
		System.out.println(rentalStatement);
		assertFalse(rentalStatement.contains("Gone With the Wind 1"));
		assertTrue(rentalStatement.contains("Gone With the Wind"));
		assertTrue(rentalStatement.contains("Doctor Zhivago"));
	}
}
