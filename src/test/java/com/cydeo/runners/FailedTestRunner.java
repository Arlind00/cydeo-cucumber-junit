package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/cydeo/step_definitions",
        features = "@target/rerun.txt"              // we write this manually or (copy path with content) and add @ at beginning
)
        public class FailedTestRunner {

}
