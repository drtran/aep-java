package com.bemach.rentals.fixtures;

import com.bemach.rentals.Customer;
import com.bemach.rentals.Movie;
import com.bemach.rentals.Rental;
import com.bemach.rentals.Tape;

public class TestCustomer {
	private Customer customer; 
	private Tape tape;
	private Movie movie;
	private Rental rental;
	
	public void execute() {
		customer = new Customer("John Doe");
	}
	
	public void setMovie(String name) {
		movie = new Movie(name, Movie.NEW_RELEASE);
		tape = new Tape ("",movie);
	}
	
	public void setDays(int daysRented) {
		rental = new Rental (tape, daysRented);
	}
	
	public boolean rented() {
		customer.addRental(rental);
		String statement = customer.getStatement();
		return statement.contains(movie.getName());
	}
}
