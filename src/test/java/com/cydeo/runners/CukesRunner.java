package com.cydeo.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)                              // we add this line for centralisation the structure
@CucumberOptions(                                     // we pass the path of files in order to be able to use them
        plugin = {
                "html:target/cucumber-reports.html", // we first right the location where we want to open, then open cucumber-report.html
                "rerun:target/rerun.txt",            // for failed tests we provide a new page in order those test to be retested
                 "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "src/test/resources/features",     // we pass features directories content root path
        glue = "com/cydeo/step_definitions",          // we pass source root of step-definitions folder
        dryRun = false,                               // turns off running step_definitions, just check for missing snippet,  when true= ON, when false = OFF
        tags = "@smoke"

)




public class CukesRunner {
}



