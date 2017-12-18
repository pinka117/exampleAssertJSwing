package com.attsw.example.assertjswing.bdd;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.Test;

@RunWith(Cucumber.class)
@CucumberOptions(
		format = { "junit:target/cucumberReports/cucumber.xml" }, 
		features = "classpath:cucumber",
		glue="com.attsw.example.assertjswing.bdd.steps"
				
		)

public class ITCucumberRunner{
	@Test
	public void test() {

	}

}
