package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.safari.SafariDriver;

public class GoogleStepDefinitions {

    @When("user is on Google search")
    public void user_is_on_google_search() {

        Driver.getDriver().get("https://www.google.com");        // this part is changeable
    }
    @Then("user should see title is Google")
    public void user_should_see_title_is_google() {
        String expectedTitle = "Google";                         // this part is changeable
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);

        Driver.closeDriver();
    }
}