package org.coa.listingPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import basePack.BaseClass;

public class NonStopFilter extends BaseClass{
	
	@Test
	public void nonStopFilterTest() throws Exception {
		extentTest = extentReport.createTest("COA Test", "Testing Non Stop Filters");   //Mandatory
		extentTest.assignCategory("Regression Test");
		
		driver.get("https://www.cheapoair.com/remotesearch?&from=NYC&to=LAS&fromDt=03/24/2021&toDt=03/30/2021&fromTm=1100&toTm=1100&rt=true&ad=1&se=1&ch=0&infl=0&infs=0&class=1&airpref=&preftyp=1&daan=&raan=&dst=&rst=&IsNS=false");
		//System.out.println("");
		Reporter.log("URL is entered.");
		extentTest.info("URL is entered.");
		
		
		extentTest.info("Waiting for locator => 'ul[class='filters__list'] > li > label'");
		//helper.waitFor(By.cssSelector("ul[class='filters__list'] > li > label"), 20, 1);
		//Thread.sleep(2000);
		
		
		//Apply Non Stop Filter
		WebElement nonStopFilter = driver.findElement(By.cssSelector("ul[class='filters__list'] > li > label"));
		nonStopFilter.click();
		extentTest.info("Click on NonStop Filter.");
		
		Assert.assertTrue(false);
	}
}
