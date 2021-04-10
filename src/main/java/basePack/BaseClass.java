package basePack;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseClass extends BaseClassBuilder{

	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws Exception {
		driver = init();
	}
	
	@AfterTest
	public void terminate() throws Exception {
		driver.quit();
	}
	
	
}
