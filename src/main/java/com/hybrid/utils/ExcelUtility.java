package com.hybrid.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public static String getCellData(String sheetName, int row, int col) throws IOException
	{
		FileInputStream fis = new FileInputStream("testdata\\TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		String value = sheet.getRow(row).getCell(col).getStringCellValue();
		workbook.close();
		return value;
		
	}

}
