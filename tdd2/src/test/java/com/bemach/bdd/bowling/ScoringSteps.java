package com.bemach.bdd.bowling;

import static org.junit.Assert.assertEquals;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScoringSteps {
	private SuperScorer scorer;
	@Given("^I am on the first frame$")
	public void I_am_on_the_first_frame() throws Throwable {
	    scorer = new SuperScorer();
	    assertEquals(1,scorer.getFrame());
	}
	
	@When("^I bowl a strike$")
	public void I_bowl_a_strike() throws Throwable {
	    scorer.scoreFirstBall(10);
	}

	@Then("^I should see an \"([^\"]*)\" and a message that says \"([^\"]*)\"$")
	public void I_should_see_an_and_a_message_that_says(String score, String message) throws Throwable {
		assertEquals(message, scorer.getBowlerMessage());
		assertEquals(score, scorer.getScore());
	}

	@Then("^I should hear \"([^\"]*)\"$")
	public void I_should_hear(String song) throws Throwable {
	    assertEquals(song, scorer.getSongToPlay());
	}

	@When("^I bowl a gutter ball$")
	public void I_bowl_a_gutter_ball() throws Throwable {
	    scorer.scoreFirstBall(0);
	}

	@Given("^I have bowled a gutter ball already$")
	public void I_have_bowled_a_gutter_ball_already() throws Throwable {
	    scorer = new SuperScorer();
	    scorer.scoreFirstBall(0);
	}

	@When("^I bowl another gutter ball$")
	public void I_bowl_another_gutter_ball() throws Throwable {
	    scorer.scoreSecondBall(0);
	}

	@Given("^I bowled a gutter ball on every frame$")
	public void I_bowled_a_gutter_ball_on_every_frame() throws Throwable {
	    scorer = new SuperScorer();
	    for (int i = 0; i < 10; i++) {
	    	scorer.scoreFirstBall(0);
	    	scorer.scoreSecondBall(0);
	    }
	}


}
