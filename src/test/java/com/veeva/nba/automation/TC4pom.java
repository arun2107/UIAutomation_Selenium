package com.veeva.nba.automation;

import com.veeva.nba.pages.*;

public class TC4pom {
		
	public static void main(String[] args)
	{	
		BullsHomePage page = new BullsHomePage();

		page.launchBulls("firefox");
		
		page.scrolltoFooter();
		
		page.writeFooterElements("/footerATags.xlsx","footerHref");
		
		page.validateHyperLinks();
		
		page.closeFooterPages();
		
	}

}
