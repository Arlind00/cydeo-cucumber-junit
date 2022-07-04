package com.cydeo.tests_apache;

import com.cydeo.pages.VyTrackDashboardPage;
import com.cydeo.pages.VyTrackLoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class VyTrackLoginDDT {

    VyTrackLoginPage loginPage = new VyTrackLoginPage();
    VyTrackDashboardPage dashboardPage = new VyTrackDashboardPage();


    @Before
    public void setUp(){
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));
    }

    @Test
    public void loginDDTTest() throws IOException {
        String filePath = "VyTrackQa2Users.xlsx";               // file location
        FileInputStream in = new FileInputStream(filePath);     // give file location as argument for method to get that file
        XSSFWorkbook workbook = new XSSFWorkbook(in);           // initialize workbook give argument file reading methods name
        XSSFSheet sheet = workbook.getSheet("data");      // initialize sheet give as argument excel sheet name

        for (int i = 1; i <= sheet.getLastRowNum(); i++){
            String userName  = sheet.getRow(i).getCell(0).toString();
            String passWord = sheet.getRow(i).getCell(1).toString();
            String firsName = sheet.getRow(i).getCell(2).toString();
            String lastName = sheet.getRow(i).getCell(3).toString();

            loginPage.login(userName,passWord);

            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);         // initialize wait method

            // first we run the test it gave error that this element should be used
            WebElement loaderMask = Driver.getDriver().findElement(By.cssSelector("div[class='loader-mask shown']"));
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));                    // we tell what condition

            String actualFullName = dashboardPage.fullName.getText();
            XSSFCell resultCell = sheet.getRow(i).getCell(4);

            if(actualFullName.contains(firsName) && actualFullName.contains(lastName)){
                System.out.println("PASS");
                resultCell.setCellValue("PASS");
            }else {
                System.out.println("FAIL");
                resultCell.setCellValue("FAIL");
            }

            dashboardPage.logout();

        }

        FileOutputStream out = new FileOutputStream(filePath);
        workbook.write(out);

        in.close();
        out.close();
        workbook.close();

    }








    @After
    public void tearDown(){
        Driver.closeDriver();
    }
}
