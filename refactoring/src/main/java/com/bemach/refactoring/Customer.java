package com.bemach.refactoring;

import java.util.Enumeration;
import java.util.Vector;

public class Customer extends DomainObject {
	private Vector<Rental> rentals = new Vector<Rental>();
	
	public Customer(String name) {
		this.name = name;
	}

	public String getStatement() {
		Enumeration<Rental> theRentals = rentals.elements();
		String result = "Rental Record for " + name + "\n";
		while (theRentals.hasMoreElements()) {
			Rental each = (Rental) theRentals.nextElement();
			// show figures for this rental
			result += "\t" + each.getTape().getMovie().name + "\t"
					+ String.valueOf(each.charge()) + "\n";
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(charge()) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints())
				+ " frequent renter points";
		return result;
	}

	public String getHtmlStatement() {
		Enumeration<Rental> theRentals = rentals.elements();
		String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
		while (theRentals.hasMoreElements()) {
			Rental each = (Rental) theRentals.nextElement();
			// show figures for each rental
			result += each.getTape().getMovie().getName() + ": "
					+ String.valueOf(each.charge()) + "<BR>\n";
		}
		// add footer lines
		result += "<P>You owe <EM>" + String.valueOf(charge()) + "</EM><P>\n";
		result += "On this rental you earned <EM>"
				+ String.valueOf(frequentRenterPoints())
				+ "</EM> frequent renter points<P>";
		return result;
	}
	
	public void addRental(Rental arg) {
		rentals.addElement(arg);
	}
	
	private double charge() {
		double result = 0;
		Enumeration<Rental> theRentals = rentals.elements();
		while (theRentals.hasMoreElements()) {
			Rental each = (Rental) theRentals.nextElement();
			result += each.charge();
		}
		return result;
	}
	
	private int frequentRenterPoints() {
		int result = 0;
		Enumeration<Rental> theRentals = rentals.elements();
		while (theRentals.hasMoreElements()) {
			Rental each = (Rental) theRentals.nextElement();
			result += each.frequentRenterPoints();
		}
		return result;
	}
}
