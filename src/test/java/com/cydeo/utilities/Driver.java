package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {



    private  Driver() {
    }                                       // creating private constructor (closing access to object from outside)

    private static WebDriver driver;                          // private: because we want to control access from outside the class
    // static: because we will use it in static method


    public static WebDriver getDriver() {                     // create a re-usable utility method that return Webdriver

        if (driver == null) {

            String browserType = ConfigurationReader.getProperty("browser");     // read browser type from configuration.properties to be able to control easier

            switch (browserType) {                                               // depending on browser type selected from configuration.properties
                case "chrome":                                                   // will determine matching browser to open
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }
        }
        return driver;      // if driver is not null, return existing one
    }

    public static void closeDriver(){       // will make sure driver value is always null after using quit() method

        if (driver != null){
            driver.quit();                  // will terminate the existing session (it's not equal to null)
            driver = null;                  // after we quit the driver it will be null
        }
    }

    
}
