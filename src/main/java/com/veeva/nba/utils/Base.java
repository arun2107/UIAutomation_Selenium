package com.veeva.nba.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	WebDriver driver;
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	
	FileOutputStream file;	
	
	HSSFWorkbook wbook;
	
	HSSFSheet sheet;

	
	public void launchBrowser(String url,String browser)
	{
		if(browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			driver.manage().window().maximize();
			
			driver.get(url);	
		}
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver();
		}

		if(browser.equalsIgnoreCase("safari"))
		{
			WebDriverManager.safaridriver().setup();
			
			driver = new SafariDriver();
		}
		
			
	}
	
	
	public void moveToElement(String xpath)
	{
		Actions r = new Actions(driver);
		
		r.moveToElement(driver.findElement(By.xpath(xpath))).build().perform();
		
	}
	
	public void click(String xpath)
	{
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		
		driver.findElement(By.xpath("xpath")).click();
	}
	
	public void clickWithRelative(String xpath,String belowXpath)
	{
	    driver.findElement(RelativeLocator.with(By.xpath(xpath)).below(By.xpath(belowXpath))).click();

	}
	
	public void scrollWindow(int start,int end)
	{
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		  
		  js.executeScript("window.scrollBy(0,120000)","");
		  
	}
	
	public List<WebElement> getElementsByTagName(String tagName)
	{						
		 return driver.findElements(By.tagName(tagName));
		  
	}
	
	public WebElement getElementByTagName(String tagName)
	{						
		 return driver.findElement(By.tagName(tagName));
		
	}
	
	public List<WebElement> getElementsByTagName(WebElement ele,String tagName)
	{						
		
		return ele.findElements(By.tagName(tagName));
		
	}
	
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
		driver.quit();
	}
	
}
