package com.cydeo.tests_apache;

import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelRead {


    @Test
    public void read_from_excel_file() throws IOException {

        String path = "SampleData.xlsx";                                // Document name we assign to a variable for easier use

        FileInputStream fileInputStream = new FileInputStream(path);    // we load fileInput stream to read from excel


        // workbook>sheet>row>cell
        // 1. Create workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        // 2. We need to get specific sheet from currently opened workbook
        XSSFSheet sheet = workbook.getSheet("Employees");

        // 3. Select row and cell           Starts from index 0
        System.out.println("second row, first column: " + sheet.getRow(1).getCell(0));          // we give coordinates first row (x-axis) then column (y-axis)
        System.out.println("third row, third column: " + sheet.getRow(2).getCell(2));

        // Returns count of used cells only (ignores empty cells)         Starts from index 1
        int usedRows = sheet.getPhysicalNumberOfRows();
        System.out.println(usedRows);

        // Returns number from top cell to bottom cell (empty cells too)    Starts counting index 0
        int lastUsedRow = sheet.getLastRowNum();
        System.out.println(lastUsedRow);


        // TODO: Create a logic to print Vinods name
        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Vinod")) {           // goes through each row and looks for only cell at collumn 0
                System.out.println(sheet.getRow(rowNum).getCell(0));
            }
            }


        // TODO: Create a logic to print Linda's job ID
        // Check if name is Linda and then Linda's job
        for (int rowNum = 0; rowNum<usedRows; rowNum++){
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Linda")){                // goes through list, when it finds Linda
                System.out.println("Linda's Job ID: " + sheet.getRow(rowNum).getCell(2));    // print cell with Job
            }


        }
        }
    }

