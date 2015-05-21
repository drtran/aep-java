package com.bemach.bdd.serenity;

import net.thucydides.core.annotations.Step;

class TravellerSteps {

	@Step("Given a traveller has a frequent flyer account with {0} points")
	public void a_traveller_has_a_frequent_flyer_account_with_balance(
			int initialBalance) {

	}

	@Step("When the traveller flies {0} km")
	public void the_traveller_flies(int distance) {

	}

	@Step("Then the traveller should have a balance of {0} points")
	public void traveller_should_have_a_balance_of(int expectedBalance) {

	}
}
