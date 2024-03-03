package com.veeva.nba.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.veeva.nba.utils.Base;
import com.veeva.nba.utils.ExcelDriver;

public class BullsHomePage {
	
    Base obj = new Base();
    
    ExcelDriver exl = new ExcelDriver();
    
    WebElement footerElement;
    
    List<WebElement> hyperLinks;
    
	List<String> hrefduplicateList = new ArrayList<>();

	Map<String,Integer> hrefMap = new HashMap<>();
    

    public BullsHomePage launchBulls(String browser)
    {
    	obj.launchBrowser("https://www.nba.com/bulls/",browser);
		return this;
    }
    
    public BullsHomePage scrolltoFooter()
    {
       obj.scrollWindow(0, 120000);	 
        return this;
    }
    
    public BullsHomePage writeFooterElements(String path,String footerLinkssheet)
    {
    	path = System.getProperty("user.dir") + "/" + path;
    	
    	System.out.println("The path for the footer excel is" + path);
    	
    	footerElement = obj.getElementByTagName("footer");
	 		 
		  hyperLinks = obj.getElementsByTagName(footerElement,"a");
		 
		 try {
			 exl.createExcel(path, "footerLinkssheet");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 
		 int rowNumber = 0;
		 
		 
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
			  
			  try {
				  exl.writeToExcel(hrefLink, rowNumber);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			  
			  rowNumber++;	  

		 }
		 
		 try {
			exl.closeResources();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 
		 return this;
    }
    
    public List<String> validateHyperLinks()
    {
    

    	return hrefduplicateList;		
    	
    }
    
    public BullsHomePage closeFooterPages()
    {
    	
    	
    	try {
			obj.closeResources();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
		return this;
    	
    }
    
    
    
    
    

}
