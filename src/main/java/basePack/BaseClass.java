package basePack;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import commonUtilities.SelHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class BaseClass {

	public WebDriver driver;
	public SelHelper helper;
	public ExtentHtmlReporter htmlReporter;    //for look and feel of report
	public ExtentReports extentReport;         //To create entry of test in report
	public ExtentTest extentTest;              //To update status of test in report

	@BeforeSuite
	public void beforeSuite() {
		//helper = new SelHelper(driver);
	}
	
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

		//helper = SelHelper.getInstance(driver);
		// 2. Maximize it
		driver.manage().window().maximize();

		// implici wait
		// driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		// driver.manage().timeouts().setScriptTimeout(2, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void quitBrowser(ITestResult result) throws Exception {
		try {
			if(result.getStatus() == ITestResult.FAILURE) {
				//FAIL
				extentTest.log(Status.FAIL, "Test case " + result.getMethod().getMethodName() + " is fail.");
				
				currentDateTime = new SimpleDateFormat("yyyyMMdd_hhmmss").format(new Date());
				
				String screenshotPath = System.getProperty("user.dir") + "//screenshots//" + result.getMethod().getMethodName() + "_" + currentDateTime + ".jpeg";
				
				//Take Screenshot
				//File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				//File destScreenshot = new File(screenshotPath);
				
				Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
				ImageIO.write(fpScreenshot.getImage(),"JPEG",new File(screenshotPath));
				
				
				//FileUtils.moveFile(srcScreenshot, destScreenshot);
				
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
	}

	static Properties prop;
	String currentDateTime;

	@BeforeClass
	public void beforeClass() throws Exception {
		currentDateTime = new SimpleDateFormat("yyyyMMdd_hhmmss").format(new Date());
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "//extentReport//TestAutomationReport_" + currentDateTime + ".html");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("TechAltum Project");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReporter);
		extentReport.setSystemInfo("Reporter", "Amit Kumar");
		extentReport.setSystemInfo("HostName", System.getProperty("user.name"));
		extentReport.setSystemInfo("OS Name", System.getProperty("os.name"));
		extentReport.setSystemInfo("Environment", "LIVE");
		
		
		String filePath = System.getProperty("user.dir") + "//testData//data.properties";
		System.out.println("File path is = " + filePath);

		File file = new File(filePath);

		FileInputStream fIP = new FileInputStream(file);

		prop = new Properties();
		prop.load(fIP);
		
	}

	public static String getDataPropFile(String key) {

		return prop.getProperty(key);
	}

}
