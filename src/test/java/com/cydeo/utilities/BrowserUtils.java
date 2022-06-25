package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {


    // Accepts int (as seconds) and execute Thread.sleep
    public static void sleep(int second){              // accepts int (seconds) and execute Thread.sleep for given duration
        second *= 1000;

        try {
            Thread.sleep(second);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    // Accepts Webdriver, expectedURL, expectedTitle and returns boolean if they are the same
    public static void switchWindowAndVerify(String expectedInUrl, String expectedTitle){

        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowHandles) {
            Driver.getDriver().switchTo().window(each);
            System.out.println("Current URL = " + Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)){                       // if current URL contains "etsy"  break
                break;
            }
        }

        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));


        /*TC #2: Create utility method
1. Create a new class called BrowserUtils
2. Create a method to make Task1 logic re-usable
3. When method is called, it should switch window and verify title.
Method info:
• Name: switchWindowAndVerify
• Return type: void
• Arg1: WebDriver
• Arg2: String expectedInUrl
• Arg3: String expectedTitle
         */
    }


    // Accepts String "expectedTitle" and Asserts if it's true
    public static void verifyTitle( String expectedTitle){

        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);


}


    // Accepts String as expected value and verifies if the current URL contains expected value
    public static void verifyUrlContains(String expectedInURL){

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInURL));

    }


    // Accepts dropdown as web element
    // returns all options as list of string
    public static List<String> dropdownOptionsAsString(WebElement dropdownElements){

        Select select = new Select(dropdownElements);               // constructor
        List<WebElement> actualOptionsAsWebElement = select.getOptions();

        List<String> actualOptions  = new ArrayList<>();           // in order to compare expected and actual we need Web elements to convert to List<String>


        for (WebElement each : actualOptionsAsWebElement) {        // runs through all list
            actualOptions.add(each.getText());                     // each element ass string adds to new string array
        }

        return actualOptions;


    }




    }