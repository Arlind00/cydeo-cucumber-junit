package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchPage {

    public GoogleSearchPage() {                                      //initialize constructor, driver using PageFactory
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//input[@name=\"q\"]")
    public WebElement searchBox;




}
