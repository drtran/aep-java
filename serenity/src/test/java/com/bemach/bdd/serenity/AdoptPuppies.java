package com.bemach.bdd.serenity;

import net.serenitybdd.cucumber.CucumberWithSerenity;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/com/bemach/bdd/serenity/features")
public class AdoptPuppies {

}
