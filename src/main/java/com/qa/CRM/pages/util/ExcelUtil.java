package com.qa.CRM.pages.util;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ExcelUtil {

    private static Workbook book;
    private static Sheet sheet;
    public static String TEST_DATA_SHEET_PATH = "src/main/java/testdata/CRM(SignUp).xlsx";

    public static Object [][] getTestData(String sheetName){
        Object data[] [] = null ;
        try {
            FileInputStream ip = new FileInputStream(TEST_DATA_SHEET_PATH);
            book = WorkbookFactory.create(ip);
            sheet = book.getSheet(sheetName);

            data = new Object[sheet.getLastRowNum()][sheet.getRow(1).getLastCellNum()];
            //columns stays teh same so from 0 only rows changes

//            to fill the data we have to traverse
            for(int i=1; i<sheet.getLastRowNum();i++){
                for(int j=0; j<sheet.getRow(1).getLastCellNum(); j++){
                    data[i][j] = sheet.getRow(i+1).getCell(j).toString();
                }
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
//        public static Object[][] getTestData(String sheetName) {
//            try {
//                FileInputStream file = new FileInputStream(TEST_DATA_SHEET_PATH);
//                book = WorkbookFactory.create(file);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            sheet = book.getSheet(sheetName);
//
//            Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(1).getLastCellNum()];
//
//            for (int i=1; i<sheet.getLastRowNum(); i++) {
//                for (int j=0; j<sheet.getRow(1).getLastCellNum(); j++) {
//                    data[i][j] = sheet.getRow(i+1).getCell(j).toString();
//                }
//            }
//            return data;
//}

}
