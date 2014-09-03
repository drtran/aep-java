package com.bemach.java_cukes;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"html:target/cucumber-html","junit:target/cucumber-junit/Webpage.xml"},
				 features = "src/test/resources/com/bemach/java_cukes")
public class RunCukesTest {

}
