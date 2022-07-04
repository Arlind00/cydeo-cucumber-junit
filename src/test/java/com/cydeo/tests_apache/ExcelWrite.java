package com.cydeo.tests_apache;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.*;

public class ExcelWrite {


    String filePath = "SampleData.xlsx";

    XSSFWorkbook workbook;
    XSSFSheet sheet;


    @Test
    public void excel_write() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filePath);         // we give as argument files path
        workbook = new XSSFWorkbook(fileInputStream);                            // first we create workbook
        sheet = workbook.getSheet("Employees");                           // then we open specific sheet

        XSSFCell salaryCell = sheet.getRow(0).createCell(3);        // we tell where we want to enter our new data
        salaryCell.setCellValue("Salary");                                              // we give the data to be entered

        XSSFCell salary1 = sheet.getRow(1).createCell(3);
        salary1.setCellValue(200000);

        XSSFCell salary2 = sheet.getRow(2).createCell(3);
        salary2.setCellValue(110000);

        XSSFCell salary3 = sheet.getRow(3).createCell(3);
        salary3.setCellValue(135000);

        XSSFCell salary4 = sheet.getRow(4).createCell(3);
        salary4.setCellValue(500000);


        //TODO: Change Mary's last name to Jones
        for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++){
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Mary")){                 // if value of cell in given coordinates is Mary
                sheet.getRow(rowNum).getCell(1).setCellValue("Jones");                      // change value of this cell to Jones
            }
        }


        // open file to write : FileInputStream    (we use for reading)
        // save changes       : FileOutputStream   (we use for writing)
        FileOutputStream outputStream = new FileOutputStream(filePath);

        // save/write changes in workbook
        workbook.write(outputStream);       // we write the data/changes that we want

        // close all
        workbook.close();
        workbook.close();
        fileInputStream.close();

    }
}
