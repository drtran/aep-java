package com.bemach.refactoring;

public class NewReleasePrice extends Price {
	
	public double charge(int daysRented){
		return daysRented * 3;
	}
	
	@Override
	int getPriceCode() {
		return Movie.NEW_RELEASE;
	}
	
	public int frequentRenterPoints(int daysRented) {
		return (daysRented > 1) ? 2 : 1;
	}
	
}
