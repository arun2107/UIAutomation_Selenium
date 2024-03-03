package com.veeva.nba.stepdefinition;

import com.veeva.nba.pages.BullsHomePage;
import com.veeva.nba.utils.ExtentReportDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class BullsLinksValidationSteps {
	
	BullsHomePage page = new BullsHomePage();
	
	ExtentReportDriver exDriver = new ExtentReportDriver();
	
	@Before
	public void reportInit()
	{
		exDriver.createExtent("bullsValidationSteps.html","validateHyperLinks");
	}
	
	@Given("Land on Bulls Home Page with {string}")
	public void land_on_bulls_home_page_with(String browser) {

		System.out.println(browser);
		page.launchBulls("fireFox");
		exDriver.logInExtent("pass", "Browser launched in" + browser);
	
	}

	@When("Scroll to Footer")
	public void scroll_to_footer() {

		page.scrolltoFooter();
		exDriver.logInExtent("pass", "Scrolled to Footer");


	}

	@When("Write Footer Links to Excel in {string}")
	public void write_footer_links_to_excel(String path) {
		
		page.writeFooterElements(path,"Sheet");
		exDriver.logInExtent("pass", "FooterElements written to excel");

		
	}

	@Then("Assert if any Link is a Duplicate")
	public void assert_if_any_link_is_a_duplicate() {
		

		if(page.validateHyperLinks().isEmpty())
		{
			exDriver.logInExtent("pass","We do not have duplicate Links in the Footer");

		}
		else
		{
			exDriver.logInExtent("fail","We  have duplicate Links in the Footer" + page.validateHyperLinks());

		}
		
		page.closeFooterPages();
		
		
	}
	
	@After
	public void closeExtent()
	{
		exDriver.flushReport();

	}


}
