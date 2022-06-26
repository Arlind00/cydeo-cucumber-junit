package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTable_LoginPage {


    public WebTable_LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@name=\"username\"]")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@type=\"password\"]")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement loginButton;

    @FindBy(linkText = "Cydeo Web Table App")
    public WebElement actualTitle;



    // 1st method
    public void login(){          // no parameters given when we call this method, it will directly login
        this.usernameBox.sendKeys("Test");
        this.passwordBox.sendKeys("Tester");
        this.loginButton.click();
    }

    // 2nd method
    public void login(String username, String password){        // accepts 2 parameters, expects us to enter parameters in order to enter
            usernameBox.sendKeys(username);
            passwordBox.sendKeys(password);
            loginButton.click();
    }


    // 3rd method
    public void loginWithConfig(){              // will login using credentials from configuration.properties, NO Hardcoding
        usernameBox.sendKeys(ConfigurationReader.getProperty("usernameTable"));
        passwordBox.sendKeys(ConfigurationReader.getProperty("passwordTable"));
        loginButton.click();
    }

}
