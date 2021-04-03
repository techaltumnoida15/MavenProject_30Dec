package pageObjects;

import org.openqa.selenium.WebDriver;

import commonUtilities.Utility;


public class ListingPage extends Utility{

	private WebDriver driver;
	
	public ListingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void currencyChangeTest() {
		
	}
	
	
	public void oneStopFilterTest() {
		
	}
	
	public String getPageTitle() {
		
		return getPageTitle(driver);
	}
	
	
	public String listingPageCurrentURL() {
		return getPageCurrentURL(driver);
	}
	
	
}
