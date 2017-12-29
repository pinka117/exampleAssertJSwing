package com.attsw.example.assertjswing.bdd;

import org.junit.Test;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = {
		"junit:target/cucumberReports/cucumber.xml" }, features = "classpath:cucumber/Delete.feature", glue = "com.attsw.example.assertjswing.bdd.steps.delete")
public class ITCucumberRunnerDelete {

	@Test
	public void test() {
	}

}
