package basePack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.stream.FileImageInputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import commonUtilities.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassBuilder {

	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver init() throws Exception {
		
		 prop= new Properties();
		 prop.load(new FileInputStream(new File(System.getProperty("user.dir") + "//testData//data.properties")));
		
		//mvn test -Dbrowser=chrome
		//String browserName = System.getProperty("browser");  // Uncomment this line if you are sending parameter from Maven
		String browserName = prop.getProperty("browserName");// comment this line if you are sending parameter from Maven
		System.out.println(browserName);
		
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
		return driver;
	}

	public String getScreenShotPath(String testCaseName) throws IOException
	{
		String currentDateTime = new SimpleDateFormat("yyyyMMdd_hhmmss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\screenshots\\"+ testCaseName  + "_" + currentDateTime +".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;


	}
}
