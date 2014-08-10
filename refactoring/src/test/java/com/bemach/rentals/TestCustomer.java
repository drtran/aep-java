package com.bemach.rentals;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCustomer {
	@Test
	public void CanCreateACustomerObject() {
		// AAA: Arrange, Act, Assert
		Customer customer = new Customer ("John Doe");
		assertNotNull(customer);
	}
	
	@Test 
	public void CanAddOneRental() {
		Customer customer = new Customer("John Doe");
		Movie goneWithTheWindMovie = new Movie("Gone With the Wind", Movie.NEW_RELEASE);
		Tape goneWithTheWindTape = new Tape("1234", goneWithTheWindMovie);
		Rental goneWithTheWindRental = new Rental (goneWithTheWindTape, 4);
		
		customer.addRental(goneWithTheWindRental);
		String rentalStatement = customer.getStatement();
		System.out.println(rentalStatement);
		assertFalse(rentalStatement.contains("Gone With the Wind 1"));
		assertTrue(rentalStatement.contains("Gone With the Wind"));
	}
	
	@Test 
	public void CanAddTwoRentals() {
		Customer customer = new Customer("John Doe");
		Movie goneWithTheWindMovie = new Movie("Gone With the Wind", Movie.NEW_RELEASE);
		Movie drZhivagoMovie = new Movie("Doctor Zhivago", Movie.REGULAR);
		Tape goneWithTheWindTape = new Tape("1234", goneWithTheWindMovie);
		Tape drZhivagoTape = new Tape("1235", drZhivagoMovie);
		Rental goneWithTheWindRental = new Rental (goneWithTheWindTape, 4);
		Rental drZhivagoRental = new Rental (drZhivagoTape, 4);
		
		customer.addRental(goneWithTheWindRental);
		customer.addRental(drZhivagoRental);
		String rentalStatement = customer.getStatement();
		System.out.println(rentalStatement);
		assertFalse(rentalStatement.contains("Gone With the Wind 1"));
		assertTrue(rentalStatement.contains("Gone With the Wind"));
		assertTrue(rentalStatement.contains("Doctor Zhivago"));
	}
}
