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
<<<<<<< HEAD
	public ExtentHtmlReporter htmlReporter;    //for look and feel of report
	public ExtentReports extentReport;         //To create entry of test in report
	public ExtentTest extentTest;              //To update status of test in report

	@Parameters({ "browserName" })
	@BeforeMethod
	public void openBrowser(String browserName) {
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else if (browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}

		else if (browserName.equalsIgnoreCase("edge")) {
			// EDGE
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();

		// implicit wait
		// driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		// driver.manage().timeouts().setScriptTimeout(2, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void quitBrowser(ITestResult result) throws Exception {
		try {
			if(result.getStatus() == ITestResult.FAILURE) {
				//FAIL
				extentTest.log(Status.FAIL, "Test case " + result.getMethod().getMethodName() + " is fail.");
				
				currentDateTime = new SimpleDateFormat("yyyyMMdd_hhmmss").format(new Date());
				
				String screenshotPath = System.getProperty("user.dir") + "//screenshots//" + result.getMethod().getMethodName() + "_" + currentDateTime + ".jpeg";
				
				Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
				ImageIO.write(fpScreenshot.getImage(),"JPEG",new File(screenshotPath));
				
				extentTest.addScreenCaptureFromPath(screenshotPath);
				extentTest.info("This test is fail.");
			}
			else if(result.getStatus() == ITestResult.SUCCESS) {
				//PASS
				
				extentTest.log(Status.PASS, "This test is pass.");
			}
			else if(result.getStatus() == ITestResult.SKIP){
				extentTest.log(Status.SKIP, "This test is skipped.");	
			}
		}




		catch(Exception ex) {
			extentTest.info("There is some error in test execution '" + result.getMethod().getMethodName() + "' => "+ ex.toString());
		}
		finally {
			driver.quit();
		}
	}
	
	@AfterClass
	public void afterClass() {
		extentReport.flush();



		//driver.quit();



=======
	
	@BeforeTest
	public void initialize() throws Exception {
		driver = init();
>>>>>>> 9a5b967d5d765a9697d3daf32baa00c420314d57
	}
	
	@AfterTest
	public void terminate() throws Exception {
		driver.quit();
	}
	
	
}
