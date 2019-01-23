package com.tamplo.qa.excelreadcode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.formula.SheetNameFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelOperations 
{
	String srcpath = System.getProperty("user.dir");
	//String filename = srcpath +"/src/main/java/com/tamplo/qa/testdata/demo.xlsx";
	//String sheetName ="TestData";
	
	@Test(dataProvider = "getExcelData")
	public void sampleTest(String name,String email,String password,String cty,String state,String code,String runmode) throws IOException
	{
		System.out.println("name is "+ name);
		System.out.println("email is "+ email);
		System.out.println("password " +password);
		System.out.println("city " + cty);
		System.out.println("state " + state);
		System.out.println("code "+ code);
		System.out.println("runmode "+ runmode);
		
		/*ExcelOperations excelOperations = new ExcelOperations();
		Object[][] data = excelOperations.getExcelData(filename, sheetname);
		System.out.println(data);*/
	}
	
	
	@DataProvider
	public String[][] getExcelData() {
		try {
			String excellocation = srcpath +"/src/main/java/com/tamplo/qa/testdata/demo.xlsx";
			String sheetName ="TestData";
			String dataSets[][] = null;
			FileInputStream file = new FileInputStream(new File(excellocation));

			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheet(sheetName);
			// count number of active rows
			int totalRow = sheet.getLastRowNum();
			// count number of active columns in row
			int totalColumn = sheet.getRow(0).getLastCellNum();
			// Create array of rows and column
			dataSets = new String[totalRow][totalColumn];
			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			int i = 0;
			while (rowIterator.hasNext()) {
				System.out.println(i);

				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();
				int j = 0;
				while (cellIterator.hasNext()) {

					Cell cell = cellIterator.next();
					if (cell.getStringCellValue().contains("email")) {
						break;
					}

					// Check the cell type and format accordingly
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						dataSets[i - 1][j++] = cell.getStringCellValue();
						//System.out.println(cell.getNumericCellValue());
						break;
					case Cell.CELL_TYPE_STRING:
						dataSets[i - 1][j++] = cell.getStringCellValue();
						//System.out.println(cell.getStringCellValue());
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						dataSets[i - 1][j++] = cell.getStringCellValue();
						//System.out.println(cell.getStringCellValue());
						break;
					case Cell.CELL_TYPE_FORMULA:
						dataSets[i - 1][j++] = cell.getStringCellValue();
						//System.out.println(cell.getStringCellValue());
						break;
					}

				}

				System.out.println("");
				i++;
			}
			file.close();
			return dataSets;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
