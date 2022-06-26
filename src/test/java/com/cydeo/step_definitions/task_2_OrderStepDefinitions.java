package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.OrderPage;
import com.cydeo.pages.ViewAllOrdersPage;
import com.cydeo.pages.WebTable_LoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.BreakIterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class task_2_OrderStepDefinitions {

    WebTable_LoginPage webTable_loginPage = new WebTable_LoginPage();
    BasePage basePage = new BasePage();
    OrderPage orderPage = new OrderPage();
    ViewAllOrdersPage viewAllOrdersPage = new ViewAllOrdersPage();

    @Given("user is already logged in and on order page")
    public void user_is_already_logged_in_and_on_order_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("webTable"));
    webTable_loginPage.login();
    basePage.order.click();             // click on web element in order to enter to subpage
    }



    @When("user selects product type {string}")
    public void user_selects_product_type(String string) {

        Select select = new Select(orderPage.inputProduct);
        select.selectByVisibleText(string);
    }



   // @When("user enters quantity {int}")
   // public void user_enters_quantity(Integer int1) {
   // }

    @And("user enters quantity {int}")
    public void userEntersQuantity(int arg0) {

        orderPage.inputQuantity.clear();                            // deletes whatever is inside box
        //orderPage.inputQuantity.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE);       // deletes whatever is inside box

        //orderPage.inputQuantity.sendKeys(arg0 + "");          // concatinate int to string
        orderPage.inputQuantity.sendKeys(String.valueOf(arg0));             //
    }


    @When("user enters customer name {string}")
    public void user_enters_customer_name(String string) {

        orderPage.inputName.sendKeys(string);
    }



    @When("user enters street {string}")
    public void user_enters_street(String string) {
        orderPage.inputStreet.sendKeys(string);
    }



    @When("user enters city {string}")
    public void user_enters_city(String string) {
        orderPage.inputCity.sendKeys(string);
    }



    @When("user enters state {string}")
    public void user_enters_state(String string) {
        orderPage.inputState.sendKeys(string);
    }



    @When("user enters zipcode {string}")
    public void user_enters_zipcode(String string) {
        orderPage.inputZip.sendKeys(string);
    }



    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String expectedCardType) {
        BrowserUtils.clickRadioButton(orderPage.cardType, expectedCardType);        // our method that we created
    }



    @When("user enters credit card number {string}")
    public void user_enters_credit_card_number(String string) {
        orderPage.cardNoInput.sendKeys(string);

    }



    @When("user enters expiry date {string}")
    public void user_enters_expiry_date(String string) {
        orderPage.cardExpInput.sendKeys(string);
    }



    @When("user enters process order button")
    public void user_enters_process_order_button() {
        orderPage.processButton.click();
    }



    @Then("user should see {string} in first row of the web table")
    public void user_should_see_in_first_row_of_the_web_table(String expectedName) {

        String actualName = viewAllOrdersPage.newCustomerCell.getText();
        Assert.assertEquals(expectedName,actualName);
    }



}
