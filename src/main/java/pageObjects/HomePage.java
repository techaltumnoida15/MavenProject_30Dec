package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import commonUtilities.Utility;

public class HomePage extends Utility{
	
	private WebDriver driver;
	//Utility utility;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		//utility = new Utility();
	}
	
	public boolean isHomePageLoaded() {
		return isElementVisible(driver, 5, By.cssSelector("ul[aria-label='Search Widget Tabs']"));
	}
	
	
	public void enterFrom() {
		WebElement from = driver.findElement(By.cssSelector(""));
		from.sendKeys("NYC");
	}
	
	
	public void enterTo() {
		WebElement to = driver.findElement(By.cssSelector(""));
		to.sendKeys("NYC");
	}
	
	public void selectDepartDate() {
		
	}
	
	
	public void selectReturnDate() {
		
	}
	
	public String getTitle() {
		return getPageTitle(driver);
	}
	
	public String getPageURL() {
		return getPageCurrentURL(driver);
	}
	
	
}
