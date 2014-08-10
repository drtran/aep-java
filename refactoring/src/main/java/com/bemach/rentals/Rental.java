package com.bemach.rentals;

public class Rental extends DomainObject {
	private Tape tape;
	private int daysRented;

	public int getDaysRented() {
		return daysRented;
	}

	public Tape getTape() {
		return tape;
	}

	public Rental(Tape tape, int daysRented) {
		this.tape = tape;
		this.daysRented = daysRented;
	}
}
