package com.bemach.refactoring;

public class Tape extends DomainObject {
	private String serialNumber;
	private Movie movie;
	
	public Movie getMovie() {
		return movie;
	}

	public Tape(String serialNumber, Movie movie) {
		this.serialNumber = serialNumber;
		this.movie = movie;
	}

	public double charge(int daysRented) {
		return movie.charge(daysRented);
	}
	
	public int frequentRenterPoints(int daysRented) {
		return movie.frequentRenterPoints(daysRented);
	}
}
