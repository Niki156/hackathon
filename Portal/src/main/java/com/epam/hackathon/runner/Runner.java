package com.epam.hackathon.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        plugin = {"html:target/cucumber-reports/report.html"},
        glue = {"com.epam.programsportal.stepDefs"},
        features = {"src/test/resources/featurefiles/addingCollege.feature"},
        monochrome = true
)
public class Runner extends AbstractTestNGCucumberTests {

}

