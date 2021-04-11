package org.coa.listingPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import basePack.BaseClass;
import pageObjects.ListingPage;

public class CurrencyChange extends BaseClass {

	// change the currency into indian rupee
	@Test
	public void currency() throws InterruptedException {
		ListingPage lp = new ListingPage(driver);
		
		driver.get(
				"https://www.cheapoair.com/air/listing?&d1=NYC&r1=LAS&dt1=04/24/2021&d2=LAS&r2=NYC&dt2=04/30/2021&tripType=ROUNDTRIP&cl=ECONOMY&ad=1&se=0&ch=0&infs=0&infl=0");

		//Check if Listing page is loaded
		Assert.assertTrue(lp.isListingPageLoaded(), "Listing page is not loaded.");
		System.out.println("Listing page is loaded.");
		
		System.out.println("Listing page title is = " + lp.getPageTitle());
		System.out.println("Listing page current URL = " + lp.listingPageCurrentURL());
		
		String elText = lp.getTextOfElement("xpath##//*[@class='header-block__item currency-wrap']");
		Assert.assertNotNull(elText);
		System.out.println("elText = " + elText);
		
		lp.clickOnElement("xpath##//*[@class='header-block__item currency-wrap']");
		System.out.println("Click on Currency element.");
		
		//Change currenty to INR
		lp.clickOnElement("css##span[class='flag-INR']");
		
		lp.textChangeWait(By.xpath("//*[@class='header-block__item currency-wrap']"), "INR");
		
		//Verify that text is change to INR
		String changedCurrency = lp.getTextOfElement("xpath##//*[@class='header-block__item currency-wrap']");
		Assert.assertTrue(changedCurrency.contains("INR"), "Currency is not changed.");
		System.out.println("changedCurrency = " + changedCurrency);
		System.out.println("Currenct is changed successfully.");
	}

}
