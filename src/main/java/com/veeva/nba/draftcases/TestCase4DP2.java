package com.veeva.nba.draftcases;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


import org.apache.poi.hssf.usermodel.*;

public class TestCase4DP2 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		  WebDriver driver = new FirefoxDriver();
		  
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  
		  driver.manage().window().maximize();
		  
		  driver.get("https://www.nba.com/bulls/");
		  
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		  
		  js.executeScript("window.scrollBy(0,120000)","");
		  
		  Thread.sleep(10);
		  
				  
		WebElement ele = driver.findElement(By.tagName("footer"));  
		  

		List<WebElement> aElements = ele.findElements(By.tagName("a"));
		
		FileOutputStream file = new FileOutputStream("/Users/macbook/eclipse-workspace-javaprograms/nba.automation/footerLinks.xlsx");		

		
		HSSFWorkbook wbook = new HSSFWorkbook();
		
		HSSFSheet sheet = wbook.createSheet("href");
		
		int counter = 0;
		
		Map<String,Integer> hrefMap= new HashMap<String,Integer>();
		
		List<String> hrefduplicateList = new ArrayList<String>();
		
		for(WebElement aElement:aElements) {
			 
			  String cellvalue = aElement.getAttribute("href"); 
			  
			  
			  if(hrefMap.containsKey(cellvalue))
			  {
				  hrefduplicateList.add(cellvalue);

			  }
			  else
			  {
				  hrefMap.put(cellvalue, 1);
			  }
				  
			  
			  System.out.println(cellvalue);
			  
			  
		        HSSFRow headerRow = sheet.createRow(counter);
		        
		        HSSFCell cell = headerRow.createCell(0);
		        
		        cell.setCellValue(cellvalue);
		        
		        counter ++;
		        

		}
		
		wbook.write(file);
		
		driver.quit();
		
		if(hrefduplicateList.isEmpty())
		{
			System.out.println("The following are the duplicates");

			System.out.println("There are no duplicates");

		}
		else
		{
			System.out.println(hrefduplicateList);

		}
		
			  
			  }
	
	
	
	
	
		  
	}


