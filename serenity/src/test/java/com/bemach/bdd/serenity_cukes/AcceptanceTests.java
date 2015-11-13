package com.bemach.bdd.serenity_cukes;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * mvn -Dtest=com.bemach.bdd.serenity_cukes.AcceptanceTests -Dcucumber.options="--tags @scenario-2,@scenario-1" verify
 * @author ktran
 *
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features", tags={"@scenario-1"})
public class AcceptanceTests {}
