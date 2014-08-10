package com.bemach.refactoring;

public class RegularPrice extends Price{
	
	public double charge(int daysRented){
		double result = 2;
		if (daysRented > 2)
			result += (daysRented - 2) * 1.5;
		return result;
	}
	
	@Override
	int getPriceCode() {
		return Movie.REGULAR;
	}
}
