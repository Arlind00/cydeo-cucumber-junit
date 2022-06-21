package com.cydeo.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)                              // we add this line for centralisation the structure
@CucumberOptions(                                     // we pass the path of files in order to be able to use them
        plugin = "html:target/cucumber-reports.html", // we first right the location where we want to open, then open cucumber-report.html
        features = "src/test/resources/features",     // we pass features directories content root path
        glue = "com/cydeo/step_definitions",          // we pass source root of step-definitions folder
        dryRun = false,                               // turns off running step_definitions, just check for missing snippet,  when true= ON, when false = OFF
        tags = "@wip"

)




public class Cukes_Runner {

}



/*
UNDERSTANDING HOW FEATURE FILES AND STEP DEFINITIONS WORK TOGETHER
TC#50: Create a new feature file and new scenarios
1. Create a new feature file named Login.feature
2. Create 3 new scenarios from the below provided user story.
3. User Story:
As a user, I should be able to login with correct credentials to different accounts.
And dashboard should be displayed.
Accounts are: librarian, student, admin
4. Create a new step definition class under step_definitions package
named: LoginStepDefs
5. Run the code. Get the step definitions from the console
6. No Java-selenium code implementation needed. Just add printing line in the
implementation regarding what should be happening when the code is ran.
Ex: “User is on the login page”
 */    // task

// 1. Create a feature file under file directory
// 2. Write feature and scenario inside newly created file
