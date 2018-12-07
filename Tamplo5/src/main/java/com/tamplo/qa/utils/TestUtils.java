package com.tamplo.qa.utils;

import java.io.BufferedInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.JavascriptExecutor;

public class TestUtils 
{
	public static int PAGELOAD = 20;
	public static int IMPLICIT = 10;

	public static String newtestfilename = "C:\\Users\\Admin\\git\\Tamplo.5.0\\Tamplo5\\src\\main\\java\\com\\tamplo\\qa\\testdata\\autoationtestdata.xlsx";

	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;
	public static BufferedInputStream bs;
	
	
	public static Object[][] getTestData(String sheetName) throws IOException {
	
		try {
					
	        bs = new BufferedInputStream(new FileInputStream(newtestfilename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(bs);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println("last row of sheet  " + sheet.getLastRowNum() + " last cell of sheet " +
		sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) 
		{
			Row row = sheet.getRow(i + 1);
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				
				 Cell cell = row.getCell(k);
				 String value;
	               try {
				  value = cell.getRichStringCellValue().toString();
	               } catch (Exception e) {
	                   
	            	   value = ((XSSFCell) cell).getRawValue();
	                }
				
				data[i][k] = value;
				System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	
}
