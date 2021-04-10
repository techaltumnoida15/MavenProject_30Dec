package commonUtilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;

import basePack.BaseClass;
import basePack.BaseClassBuilder;

public class Listeners extends BaseClassBuilder implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		String testMethodName =result.getMethod().getMethodName();
		System.out.println("testMethodName = " + testMethodName);
		
		try {
			String s = getScreenShotPath(testMethodName);
			System.out.println("s is = " + s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
	}
	

}
