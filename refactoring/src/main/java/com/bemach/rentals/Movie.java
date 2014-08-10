package com.bemach.rentals;

public class Movie extends DomainObject {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	
	private int priceCode;
	public Movie(String name, int priceCode) {
		this.name = name;
		this.priceCode = priceCode;
	}
	
	public int getPriceCode() {
		return priceCode;
	}
}
