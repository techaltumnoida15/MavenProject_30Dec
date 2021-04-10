package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	
	public void clickOnElement(String locator) {    
		clickOn(driver, locator);
	}
	
	public String getTextOfElement(String locator) {
		return getText(driver, locator);
	}
	
	public boolean isListingPageLoaded() {
		//Check contract Select button state
		boolean selectButtonState = getElementState(driver, By.cssSelector("//button[class*='btn btn-cta-1st']"), 15);
		System.out.println("selectButtonState = " + selectButtonState);
		
		int flightMatrixCellCount = getCountOfElements(driver, By.cssSelector("div[class='slick-list'] > div"), "div", 30);
		System.out.println("flightMatrixCellCount = " + flightMatrixCellCount);
		
		int contractsCount = getCountOfElements(driver, By.cssSelector("section[class='listing__contracts row contracts']"), "article", 15);
		System.out.println("contractsCount = " + contractsCount);
		
		if(selectButtonState == true && flightMatrixCellCount > 1 && contractsCount > 1) {
			return true;
		}
		else {
			return false;
		}
		
		//driver.findElement(By.cssSelector("div[class='slick-list'] > div")).findElements(By.tagName("div")).size();  //> 1
		//driver.findElement(By.cssSelector("section[class='listing__contracts row contracts']")).findElements(By.tagName("article")).size();  // > 1
	}
	
	public void textChangeWait(By byLocator, String textToMatch) {
		waitForTextChange(driver, byLocator, textToMatch, 3);
	}

	public void checkContracts(String contractType) {
		
		List<WebElement> contracts = driver.findElement(By.cssSelector("section[class='listing__contracts row contracts']")).findElements(By.tagName("article"));
		
		for(int i = 0; i<contracts.size(); i++) {
			//gettext of contracts
			if(contracts.get(i).getText().contains(contractType));
		}
	}
}
