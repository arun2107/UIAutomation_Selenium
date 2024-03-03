package com.veeva.nba.draftcases;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.*;

public class TestCase1CP1 {

	public static void main(String[] args) throws InterruptedException {		
		
		
		  System.setProperty("webdriver.firefox.driver",
		  "/Users/macbook/eclipse-workspace-javaprograms/nba/geckodriver");
		  
		  WebDriver driver = new FirefoxDriver();
		  
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  
		  driver.manage().window().maximize();
		  
		  driver.get("https://www.nba.com/warriors");
		  
		  driver.findElement(By.
		  xpath("//div[@class='p-2 absolute right-3 hover:cursor-pointer']")).click();
		  
		  
		  driver.findElement(By.xpath("//button[text()='I Accept']")).click();
		  
		  Thread.sleep(5);
		  
		  Actions r = new Actions(driver);
		  
		  r.moveToElement(driver.findElement(By.xpath(
		  "//span[text()='Shop']/parent::a[@rel='noreferrer']"))).build().perform();
		  
		  System.out.println("moved to element");
		  
		  
		  
		  driver.findElement(RelativeLocator.with(By.xpath("//a[@title=\"Men's\"]")).
		  below(By.xpath("//span[text()='Shop']/parent::a[@rel='noreferrer']"))).click(
		  );
		 
		 
		System.out.println(driver.getTitle());  
		  
		Set<String> handles = driver.getWindowHandles();
		
		List<String> handlesList = new ArrayList<>(handles);
		
		String childWindow = handlesList.get(1);
		
		driver.switchTo().window(childWindow);
		
		System.out.println(driver.getTitle());  

		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(200));		
		
		WebElement img = driver.findElement(By.tagName("img"));
		
		boolean boo = wait.until(ExpectedConditions.invisibilityOf(img));


		if(boo)
		{
			driver.findElement(By.xpath("//div[@class='search-container']/div/div/form[@role='search']/input[@type='text']")).sendKeys("Jackets");

			driver.findElement(By.xpath("//div[@class='search-container']/div/div/form[@role='search']/input[@type='text']")).sendKeys(Keys.ENTER);

			
			
		}
		
		
		
	List<WebElement> allJackets =	driver.findElements(By.xpath("//div[@class='column']"));
	

	
	    WebElement jacket = allJackets.get(0);
	

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='price-row']")));
	
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='product-card-title']/a")));

		
		List<WebElement> prices = jacket.findElements(By.xpath("//div[@class='price-row']"));
		
		List<WebElement> titles = jacket.findElements(By.xpath("//div[@class='product-card-title']/a"));
		
		for(int i=0;i<prices.size();i++)
		{
			for(int j=0;j<titles.size();j++)
			{
				String price = prices.get(i).getText();
				System.out.println(price);
				String title = titles.get(i).getText();
				System.out.println(title);


			}
			
		}
		
			
			
		
	
	
		
	}

}
