package commonUtilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility{
	
	//https://www.tutorialspoint.com/design_pattern/singleton_pattern.htm
	
	
	protected void waitFor(WebDriver driver, By byLocator, int totalTime, int pollingTime) {
		
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  .withMessage("I am waiting for suggestionBox.")
				  .withTimeout(Duration.ofSeconds(totalTime)) 
				  .pollingEvery(Duration.ofSeconds(pollingTime))
				  .ignoring(NoSuchElementException.class);
				  
				  fluentWait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
	}
	
	protected boolean isElementVisible(WebDriver driver, int timeOutInSeconds, By byLocator) {
		try {
			Wait<WebDriver> wait = new WebDriverWait(driver, 7);   //timeOutInSeconds
			wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
			return true;
		} catch (Exception ex) {
			System.out.println(ex.toString());
			return false;
		}
	}

	protected void sendKeys() {
		
	}
	
	protected void clickOn() {
		
	}
	
	protected String getText() {
		
		return "";
	}
	
	protected String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	protected String getPageCurrentURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}
}
