package com.veeva.nba.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelDriver {
	
	FileOutputStream file;	
	
	HSSFWorkbook wbook;
	
	HSSFSheet sheet;
	
	public void writeToExcel(String cellValue,int rowNumber) throws FileNotFoundException
	{
		
			HSSFRow headerRow = sheet.createRow(rowNumber);
	        
	        HSSFCell cell = headerRow.createCell(0);
	        
	        cell.setCellValue(cellValue);
		
	}
	
	public void createExcel(String location,String sheetName) throws FileNotFoundException
	{
		
		 file = new FileOutputStream(location);		
		
		 wbook = new HSSFWorkbook();
		
		 sheet = wbook.createSheet(sheetName);
		
	}
	
	public void closeResources() throws IOException
	{
		wbook.write(file);

	}
	

}
