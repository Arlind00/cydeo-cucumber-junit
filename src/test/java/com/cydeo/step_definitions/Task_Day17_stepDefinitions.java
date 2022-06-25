package com.cydeo.step_definitions;

import com.cydeo.pages.Task_day17_TableApplication;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

public class Task_Day17_stepDefinitions {

    Task_day17_TableApplication task_day17_tableApplication = new Task_day17_TableApplication();


    @When("user is at user login page")
    public void user_is_at_user_login_page() {
        String url = ConfigurationReader.getProperty("webTable");
        Driver.getDriver().get(url);
    }


    @When("user enters username as {string}")
    public void user_enters_username_as(String string) {
        task_day17_tableApplication.usernameBox.sendKeys(string);
    }


    @When("user enters password as {string}")
    public void user_enters_password_as(String string) {
        task_day17_tableApplication.passwordBox.sendKeys(string);
    }


    @And("clicks to login button")
    public void clicksToLoginButton() {
        task_day17_tableApplication.loginButton.click();
    }


    @Then("user should see url contains orders")
    public void userShouldSeeUrlContainsOrders() {
        BrowserUtils.verifyUrlContains("orders");
    }

    @When("user enters username {string} password {string}and logins")                      // three anotation functions into one
    public void userEntersUsernamePasswordAndLogins(String username, String password) {

        task_day17_tableApplication.login(username, password);                              // we created a method on Page class
    }
}
