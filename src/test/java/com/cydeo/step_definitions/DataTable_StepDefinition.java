package com.cydeo.step_definitions;

import com.cydeo.pages.DropdownsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

public class DataTable_StepDefinition {

    // we initialize object in order to be able to call methods in this class
    DropdownsPage dropdownsPage = new DropdownsPage();


    @Then("user should see fruits i like")
    public void user_should_see_fruits_i_like(List<String> fruits) {
        System.out.println();                                       // with this argument we can pass all the elements from according scenario in feature file
        System.out.println(fruits);
        System.out.println(fruits.get(2));
        System.out.println();
    }


    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");
    }


    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> expectedMonths) {

        List<String> actualMonths = BrowserUtils.dropdownOptionsAsString(dropdownsPage.monthDropdown);

        Assert.assertEquals(expectedMonths, actualMonths);         // checks size of lists, if they are same then it checks 1 by 1
    }


}

