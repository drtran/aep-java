package com.bemach.java_cukes;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"html:target/cucumber-html","junit:target/cucumber-junit/Webpage.xml", "pretty"},
				 features = "src/test/resources/com/bemach/java_cukes",
				 tags = "@scenario-3")
public class RunCukesTest {

}
