package com.cydeo.step_definitions;

import com.cydeo.pages.WebTable_LoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class Task_Day17_stepDefinitions {

    WebTable_LoginPage web_tableLoginPage = new WebTable_LoginPage();


    @When("user is at user login page")
    public void user_is_at_user_login_page() {
        String url = ConfigurationReader.getProperty("webTable");
        Driver.getDriver().get(url);
    }


    @When("user enters username as {string}")
    public void user_enters_username_as(String string) {
        web_tableLoginPage.usernameBox.sendKeys(string);
    }


    @When("user enters password as {string}")
    public void user_enters_password_as(String string) {
        web_tableLoginPage.passwordBox.sendKeys(string);
    }


    @And("clicks to login button")
    public void clicksToLoginButton() {
        web_tableLoginPage.loginButton.click();
    }


    @Then("user should see url contains orders")
    public void userShouldSeeUrlContainsOrders() {
        BrowserUtils.verifyUrlContains("orders");
    }

    @When("user enters username {string} password {string}and logins")                      // three annotation functions into one
    public void userEntersUsernamePasswordAndLogins(String username, String password) {

        web_tableLoginPage.login(username, password);                              // we created a method on Page class
    }




    @When("User enters below credentials")
    public void user_enters_below_credentials(Map<String,String> credentials) {

        web_tableLoginPage.login(credentials.get("username"), credentials.get("password"));        // login method that we created
    }
}
