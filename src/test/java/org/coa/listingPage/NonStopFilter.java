package org.coa.listingPage;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import basePack.BaseClass;
import pageObjects.ListingPage;

public class NonStopFilter extends BaseClass{
	
	@Test
	public void nonStopFilterTest() throws Exception {
		driver.get("https://www.cheapoair.com/remotesearch?&from=NYC&to=LAS&fromDt=04/24/2021&toDt=04/30/2021&fromTm=1100&toTm=1100&rt=true&ad=1&se=1&ch=0&infl=0&infs=0&class=1&airpref=&preftyp=1&daan=&raan=&dst=&rst=&IsNS=false");
		//System.out.println("");
		Reporter.log("URL is entered.");
		
		ListingPage lp = new ListingPage(driver);
		Assert.assertTrue(lp.isListingPageLoaded(), "Listing page is not loaded.");
		
		//Click on Non Stop Filter
		//lp.clickOnElement("");
		//Assert.assertTrue(lp.isListingPageLoaded(), "Listing page is not loaded.");
		
		//Check each and every contract should be nonstop
		//lp.checkContracts("Non stop");
		
	}
}
