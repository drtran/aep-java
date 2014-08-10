package com.bemach.tdd.helloworld;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class GoogleSearchStepDefinitions {

    WebDriver driver;

    @Given("^The search is Hello World$")
    public void theSearchIsHelloWorld() {
        driver = new HtmlUnitDriver();
        driver.get("http://www.google.co.uk");
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Hello World");
    }

    @When("^The Search is performed$")
    public void theSearchIsPerformed() {
        driver.findElement(By.xpath("//input[@name='btnG']")).click();
    }

    @Then("^The browser title should have Hello World$")
    public void theBrowserTitleShouldHaveHelloWorld() {
        assertThat ("Browser title:",driver.getTitle(), containsString("Hello World"));
        driver.quit();
    }

}
