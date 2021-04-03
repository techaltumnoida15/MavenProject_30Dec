package org.coa.homePage;

import org.testng.Assert;
import org.testng.annotations.Test;

import basePack.BaseClass;
import pageObjects.HomePage;

public class HomePage_SearchInitiate extends BaseClass{

	@Test
	public void homePageInitiateSearchTest() {
		HomePage hp = new HomePage(driver);
		
		driver.get("http://www.cheapoair.com");
		System.out.println("Url is entered.");
		
		//Check if Home Page is loaded.
		Assert.assertTrue(hp.isHomePageLoaded(), "Home page is not loaded.");
		System.out.println("Home page is loaded.");
		
		//Get Page title 
		System.out.println("Page title is = " + hp.getTitle());
		
		//Get page url
		System.out.println("Home page current URL = " + hp.getPageURL());
	}
}
