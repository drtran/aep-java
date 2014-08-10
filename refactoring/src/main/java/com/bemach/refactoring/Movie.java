package com.bemach.refactoring;

public class Movie extends DomainObject {
	static final int CHILDRENS = 2;
	static final int REGULAR = 0;
	static final int NEW_RELEASE = 1;
	
	private Price price;
	
	public void beRegular() {
		price = Price.regular();
	}
	
	public void beNewRelease() {
		price = Price.newRelease();
	}
	
	public void beChildrens() {
		price = Price.childrens();
	}
	
	public static Movie newNewRelease(String name) {
		Movie result = new Movie(name);
		result.beNewRelease();
		return result;
	}
	
	public static Movie newRegular(String name) {
		Movie result = new Movie(name);
		result.beRegular();
		return result;
	}
	
	public static Movie newChildrens(String name) {
		Movie result = new Movie(name);
		result.beChildrens();
		return result;
	}
	
	private Movie(String name) {
		this.name = name;
	}
	
	public int getPriceCode() {
		return price.getPriceCode();
	}
	
	public double charge(int daysRented) {
		return price.charge(daysRented);
	}
	
	public int frequentRenterPoints(int daysRented) {
		return price.frequentRenterPoints(daysRented);
	}
}
