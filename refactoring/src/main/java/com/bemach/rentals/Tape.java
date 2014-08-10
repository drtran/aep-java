package com.bemach.rentals;

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


}
