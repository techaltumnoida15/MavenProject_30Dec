package commonUtilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

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
	
	protected void waitFor(WebDriver driver, WebElement el, int totalTime, int pollingTime) {
		
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				  .withMessage("I am waiting for suggestionBox.")
				  .withTimeout(Duration.ofSeconds(totalTime)) 
				  .pollingEvery(Duration.ofSeconds(pollingTime))
				  .ignoring(NoSuchElementException.class);
				  
				  fluentWait.until(ExpectedConditions.visibilityOf(el));
	}
	
	
	protected int getCountOfElements(WebDriver driver, final By by, final String tagName, int timeOutInSeconds) {
			
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				       .withTimeout(Duration.ofSeconds(timeOutInSeconds))
				       .pollingEvery(Duration.ofMillis(500));
				       //.ignoring(NoSuchElementException.class, TimeoutException.class);

				   try {
					   return wait.until(new Function<WebDriver, Integer>() {
							public Integer apply(WebDriver driver) {
								return driver.findElement(by).findElements(By.tagName(tagName)).size();
							}
						   });
				} catch (Exception e) {
					return 0;
				}
	}
	
	protected boolean getElementState(WebDriver driver, final By byLocator, int timeOutInSeconds) {  
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofSeconds(timeOutInSeconds))
			       .pollingEvery(Duration.ofMillis(500));
			       //.ignoring(NoSuchElementException.class, TimeoutException.class);

			   try {
				   return wait.until(new Function<WebDriver, Boolean>() {
						public Boolean apply(WebDriver driver) {
							return driver.findElement(byLocator).isEnabled();
						}
					   });
			} catch (Exception e) {
				return false;
			}
	}
	
	protected void waitForTextChange(WebDriver driver, By locator, String textToMatch, int timeoutInSec) {
		Wait<WebDriver> wait = new WebDriverWait(driver, timeoutInSec);
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(locator), textToMatch));
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
	
	protected void clickOn(WebDriver driver, String locator) {      //id##abc, css##a[class='abc'], xpath##//a[@class='abc']
		WebElement element = getLocator(driver, locator);
		element.click();
	}
	
	protected String getText(WebDriver driver, String locator) {
		WebElement el = getLocator(driver, locator);
		return el.getText();
	}
	
	protected String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	protected String getPageCurrentURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	private WebElement getLocator(WebDriver driver, String locator) {
		WebElement el = null;
		
		if(locator.contains("id")) {
			String locatorValue = locator.split("##")[1];
			el = driver.findElement(By.id(locatorValue));
		}
		else if(locator.contains("xpath")) {
			String locatorValue = locator.split("##")[1];
			el = driver.findElement(By.xpath(locatorValue));
		}
		else if(locator.contains("css")) {
			String locatorValue = locator.split("##")[1];
			el = driver.findElement(By.cssSelector(locatorValue));
		}
		return el;
	}
}
