package commonUtilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class SelHelper{
	
	//https://www.tutorialspoint.com/design_pattern/singleton_pattern.htm
	
	private WebDriver driver;
	
	public SelHelper(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitFor(By byLocator, int totalTime, int pollingTime) {
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  .withMessage("I am waiting for suggestionBox.")
				  .withTimeout(Duration.ofSeconds(totalTime)) 
				  .pollingEvery(Duration.ofSeconds(pollingTime))
				  .ignoring(NoSuchElementException.class);
				  
				  fluentWait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
	}

}
