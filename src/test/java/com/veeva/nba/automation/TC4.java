package com.veeva.nba.automation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.veeva.nba.utils.Base;

public class TC4 {
	
	

	public static void main(String[] args) throws IOException {
		
		
         Base obj = new Base();
		 
		 obj.launchBrowser("https://www.nba.com/bulls/","firefox");
		
		 obj.scrollWindow(0, 120000);
		 
		 WebElement footerElement = obj.getElementByTagName("footer");
		 		 		 		 		 
		 List<WebElement> hyperLinks = obj.getElementsByTagName(footerElement,"a");
		 
		 obj.createExcel("/Users/macbook/eclipse-workspace-javaprograms/nba.automation/footerLinks.xlsx", "footerLinkssheet");
		 
		 int rowNumber = 0;
		 
		 List<String> hrefduplicateList = new ArrayList<>();
		 
		 Map<String,Integer> hrefMap= new HashMap();

		 
		 for(WebElement link:hyperLinks)
		 {
			  String hrefLink = link.getAttribute("href"); 

							  
			  if(hrefMap.containsKey(hrefLink))
			  {
				  hrefduplicateList.add(hrefLink);

			  }
			  else
			  {
				  hrefMap.put(hrefLink, 1);
			  }
			  
			  obj.writeToExcel(hrefLink, rowNumber);
			  
			  rowNumber++;	  

		 }
		 
		 if(hrefduplicateList.isEmpty())
			{

				System.out.println("There are no duplicates");

			}
			else
			{
				System.out.println("Found few duplicates");

			}
		 
		 obj.closeResources();

	}

}
