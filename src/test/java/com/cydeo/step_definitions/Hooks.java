package com.cydeo.step_definitions;


import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class Hooks {                // in this class we can pass pre & post-conditions to scenario and step


    @Before(order = 0)                                      // import from  i.o. cucumber , java
    public void setupScenario(){
        System.out.println("======Setting up browser using cucumber @Before");
    }


    @Before (value = "@login", order = 1)
    public void setupScenarioForLogin(){
        System.out.println("====will apply to scenarios with @login tag");
    }


    @Before (value = "@db", order = -1)
    public void setupForDatabaseScenarios(){
        System.out.println("====will apply to scenarios with @db tag");
    }


    @After                                       // import from  i.o. cucumber , java
    public void tearDown(){
        System.out.println("======Closing browser using cucumber @After");
        System.out.println("======Scenario ended, take screenshot if scenario failed");
    }


    @BeforeStep
    public void setupStep(){
        System.out.println("--------- Applying setup using @BeforeStep--------");
    }



    @AfterStep
    public void afterStep(){
        System.out.println("--------- applying teardown using @AfterStep-----");
    }


}
