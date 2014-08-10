package com.bemach.refactoring;

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
	
	public double charge() {
		return tape.charge(daysRented);
	}
	
	public int frequentRenterPoints() {
		return tape.frequentRenterPoints(daysRented);
	}
}
