package com.veeva.nba.runner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "features/"
		,glue={"com/veeva/nba/stepdefinition"}
		)

public class runner extends AbstractTestNGCucumberTests{

}
