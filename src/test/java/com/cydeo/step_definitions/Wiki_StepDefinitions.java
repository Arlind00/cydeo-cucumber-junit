package com.cydeo.step_definitions;

import com.cydeo.pages.WikiSearch_Page;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import javax.swing.*;

public class Wiki_StepDefinitions {

    WikiSearch_Page wikiSearch_page = new WikiSearch_Page();            // we call object of different class in order to be able to call its methods and variables




    @Given("User is on Wikipedia home page")
    public void is_on_wikipedia_home_page() {
        Driver.getDriver().get("https://www.wikipedia.org/");
    }



    @When("User types {string} in the wiki search box")
    public void user_types_in_the_wiki_search_box(String string) {
        wikiSearch_page.searchBox.sendKeys(string);
    }



    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        wikiSearch_page.searchButton.click();
    }



    @Then("User sees {string} is in the wiki title")
    public void user_sees_is_in_the_wiki_title(String string) {

        Assert.assertTrue(Driver.getDriver().getTitle().contains(string));
        System.out.println("first scenario is executed");
    }



    @Then("User sees {string} is in the main header")
    public void user_sees_is_in_the_main_header(String string) {

        Assert.assertTrue(wikiSearch_page.mainHeader.isDisplayed());
        Assert.assertTrue(wikiSearch_page.mainHeader.getText().equals(string));
        System.out.println("second scenario is executed");
    }


}
