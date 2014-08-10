package com.bemach.refactoring;

abstract public class Price {
	
	static Price regular() {
		return regular;
	}
	static Price childrens() {
		return childrens;
	}
	static Price newRelease() {
		return newRelease;
	}
	
	abstract int getPriceCode();
	abstract public double charge(int daysRented);
	
	public int frequentRenterPoints(int daysRented) {
		return 1;
	}
	
	private static Price childrens = new ChildrensPrice();
	private static Price newRelease = new NewReleasePrice();
	private static Price regular = new RegularPrice();
}
