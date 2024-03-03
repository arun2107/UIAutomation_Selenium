package com.veeva.nba.utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportDriver {
	
	ExtentReports reports;
	
	ExtentTest test;
	
	 	public void createExtent(String path, String reportName)
	 	{
	 		path = System.getProperty("user.dir") +"/" +path;
	 		
	 		System.out.println("The path of the report is" +path);
	 		
	 		 reports = new ExtentReports(path, true);

	 		 test = reports.startTest(reportName);
	 	}
	 	
	 	
	 	public void flushReport()
	 	{
	 		reports.flush();
	 	}
	 	
	 	public void logInExtent(String choice,String message)
		{
			if(choice.equalsIgnoreCase("info"))
			{
				test.log(LogStatus.INFO, message);
			}
			else if(choice.equalsIgnoreCase("pass"))
			{
				test.log(LogStatus.PASS, message);
			}
			else if(choice.equalsIgnoreCase("fail"))
			{
				test.log(LogStatus.FAIL, message);
			}
			
		}
	 	
	 	
	 	
	 	

}
