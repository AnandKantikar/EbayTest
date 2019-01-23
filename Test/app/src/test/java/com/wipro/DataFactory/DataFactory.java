package com.wipro.DataFactory;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.IOException;

// This class is created to  read all external data from Excel Sheet

public class DataFactory {

    public String workingDir = System.getProperty("user.dir");
    public String excelFilePath = workingDir + "\\resources\\Ebay_TestData.xlsx";
    private static DataFactory dataFactory;
    public String getExcelData(String sheetName, int rownum, int celnum) throws NumberFormatException {

        String rtnVal = null;
        try {
            XSSFWorkbook wb = new XSSFWorkbook(excelFilePath);
            XSSFSheet sh = wb.getSheet(sheetName);
            XSSFRow rc = sh.getRow(rownum);
            XSSFCell cl = rc.getCell(celnum);
            DataFormatter formatter = new DataFormatter();
            rtnVal = formatter.formatCellValue(cl);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rtnVal;
    }


}
