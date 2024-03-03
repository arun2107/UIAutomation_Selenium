package com.veeva.nba.draftcases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCase2CP1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
  WebDriver driver = new FirefoxDriver();
		  
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  
		  driver.manage().window().maximize();
		  
		  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(200));		

		  
		  
		  driver.get("https://www.nba.com/warriors");
		  
		  driver.findElement(By.
		  xpath("//div[@class='p-2 absolute right-3 hover:cursor-pointer']")).click();
		  
		  
		  driver.findElement(By.xpath("//button[text()='I Accept']")).click();
		  

					
		  WebElement menu =   driver.findElement(By.xpath("//span[text()='Shop']/parent::a[@rel='noreferrer']/../../../following-sibling::nav[@aria-label='header-secondary-menu']/ul/li/a"));
		  
		  wait.until(ExpectedConditions.visibilityOf(menu));

		  
		  Actions r = new Actions(driver);
		  
		  
		  r.moveToElement(menu).build().perform();
		  		  
		  
		  System.out.println("moved to element");
		  		  
		  
		  WebElement ele = driver.findElement(By.xpath("//a[@title='News & Features']"));
		  
		  wait.until(ExpectedConditions.visibilityOf(ele));

		  
		  ele.click();

	  
		  List<WebElement> videosFoundNow = driver.findElements(By.xpath("//h3[text()='VIDEOS']/parent::div/following-sibling::div/div/ul/li"));
		  
		  System.out.println("the current vidoes found now are" + videosFoundNow.size());
		  
		  List<WebElement> videosFoundTotal = new ArrayList<WebElement>();

		  
		  while(videosFoundNow.size()>0){
			  
			  videosFoundTotal.addAll(videosFoundNow);
			  
			  WebElement lastVideo = videosFoundNow.get(videosFoundNow.size()-1);
			  
			  
			  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", lastVideo);
			  
			  
			   videosFoundNow = driver.findElements(By.xpath("//h3[text()='VIDEOS']/parent::div/following-sibling::div/div/ul/li"));

			   System.out.println(videosFoundNow.size());
			  
			 }
		  
		  System.out.println("the total videos found are" + videosFoundTotal.size());
		  
			
		  
	}

}
