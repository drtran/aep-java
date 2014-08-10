package com.bemach.rentals;

import java.util.Enumeration;
import java.util.Vector;

public class Customer extends DomainObject {
	public Customer(String name) {
		this.name = name;
	}

	public String getStatement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration<Rental> theRentals = rentals.elements();
		String result = "Rental Record for " + name + "\n";
		while (theRentals.hasMoreElements()) {
			double thisAmount = 0;
			Rental each = (Rental) theRentals.nextElement();
			// determine amounts for each line
			switch (each.getTape().getMovie().getPriceCode()) {
			case Movie.REGULAR:
				thisAmount += 2;
				if (each.getDaysRented() > 2)
					thisAmount += (each.getDaysRented() - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				thisAmount += each.getDaysRented() * 3;
				break;
			case Movie.CHILDRENS:
				thisAmount += 1.5;
				if (each.getDaysRented() > 3)
					thisAmount += (each.getDaysRented() - 3) * 1.5;
				break;
			}
			totalAmount += thisAmount;
			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if ((each.getTape().getMovie().getPriceCode() == Movie.NEW_RELEASE)
					&& each.getDaysRented() > 1)
				frequentRenterPoints++;
			// show figures for this rental
			result += "\t" + each.getTape().getMovie().name + "\t"
					+ String.valueOf(thisAmount) + "\n";
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
				+ " frequent renter points";
		return result;
	}

	public void addRental(Rental arg) {
		rentals.addElement(arg);
	}

	private Vector<Rental> rentals = new Vector<Rental>();
}
