package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VyTrackLoginPage {



    public VyTrackLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id=\"prependedInput\"]")
    private WebElement loginUser;

    @FindBy(xpath = "//input[@id=\"prependedInput2\"]")
    private WebElement loginPass;

    @FindBy(xpath = "//button[@id=\"_submit\"]")
    private WebElement loginButton;

    public void login(String username, String password){        // we create login method in this class
       loginUser.sendKeys(username);
       loginPass.sendKeys(password);
       loginButton.click();
    }

}
