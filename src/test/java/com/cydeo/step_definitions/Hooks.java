package com.cydeo.step_definitions;


import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {                // in this class we can pass pre & post-condition for scenario and step


    @Before(order = 0)                                      // import from  i.o. cucumber , java
    public void setupScenario(){
      //  System.out.println("======Setting up browser using cucumber @Before");
    }


    @Before (value = "@login", order = 1)
    public void setupScenarioForLogin(){
       // System.out.println("====will apply to scenarios with @login tag");
    }


    @Before (value = "@db", order = 2)
    public void setupForDatabaseScenarios(){
      //  System.out.println("====will apply to scenarios with @db tag");
    }


    @After                                       // import from  i.o. cucumber , java
    public void tearDown(Scenario scenario){


        if (scenario.isFailed()){                       // if scenario fails take screenshot and store it
            byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);        // takes screenshot
            scenario.attach(screenshot,"image/png", scenario.getName());

        }

       // BrowserUtils.sleep(5);

        Driver.closeDriver();
        // System.out.println("======Closing browser using cucumber @After");
        // System.out.println("======Scenario ended, take screenshot if scenario failed");
    }


    @BeforeStep
    public void setupStep(){
      // System.out.println("--------- Applying setup using @BeforeStep--------");
    }


    @AfterStep
    public void afterStep(){
       // System.out.println("--------- applying teardown using @AfterStep-----");
    }


}
