package com.abhi.RAssured.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

/**
 * monochrome=true - console output from Cucumber in a readable format
 * When no glue is provided, Cucumber will use the package of the annotatedclass.
 * 				For example, if the annotated class is com.example.RunCucumber 
 * 				then glue is assumed to be located in com.example
 * 
 * @author Abhjit Awari
 * mention features path else it will consider parent package of runner to run feature file
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
					glue = "com.abhi.RAssured.stepdefs",
					plugin = { "pretty", "html:target/cucumber.html" },
					monochrome = true,
					tags = "@GetCheckWithGroovy"
				)
public class RunCucumberTest {

}
