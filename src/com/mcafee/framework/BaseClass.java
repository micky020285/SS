package com.mcafee.framework;

import java.io.File;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.macfee.pages.SalesHomePage;
import com.macfee.utility.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


/**
*
* @author Balamurugan
*
*/

public class BaseClass 
{
	public WebDriver driver;
	public CommonFunctions commonMethods;
	public static PropertiesReader configpropReaderObj;
	public static PropertiesReader locatorpropReaderObj;
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;
	
	@BeforeSuite
	public void beforeSuite()
	{
		extentReport = ExtentManager.Instance();		
	}
	
	@BeforeClass
	public void setup()
	{
		try 
		{
			WebdriverInitializer webinit = new WebdriverInitializer(configpropReaderObj.getData("browser"));
			driver = webinit.getWebDriver();
			commonMethods = new CommonFunctions(driver, locatorpropReaderObj);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		String className = this.getClass().getSimpleName();
		String browser=configpropReaderObj.getData("browser");
		extentReport.addSystemInfo("Browser", browser);
		extentTest=extentReport.startTest(className);
		extentTest.assignCategory("SalesForce Sanity Test on Browser - "+browser);
	}
	
	@BeforeTest
	public void beforeTest()
	{
		configpropReaderObj = new PropertiesReader(new File(".\\resources\\config.properties"));
		locatorpropReaderObj = new PropertiesReader(new File(".\\resources\\objects.properties"));
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		  {
			  System.out.println( result.getMethod().getMethodName() +" -- TEST SCENARIO FAILED");
			  //String screenshot_path=Utility.captureScreenshot(driver, result.getName());
			  try 
			  {
				  TakesScreenshot ts=(TakesScreenshot)driver;

				  File source=ts.getScreenshotAs(OutputType.FILE);

				  FileUtils.copyFile(source, new File(".\\test_output\\Screenshots\\"+result.getName()+".png"));

				  System.out.println("Screenshot taken");
			  } 
			  catch (Exception e)
			  {

				  System.out.println("Exception while taking screenshot "+e.getMessage());
			  } 
			  String image= extentTest.addScreenCapture(".\\Screenshots\\"+result.getName()+".png");
			  System.out.println("Screenshot attached");
			  extentTest.log(LogStatus.FAIL, result.getMethod().getMethodName() +" -- TEST SCENARIO FAILED", image);
		
		}
		  else if (result.getStatus() == ITestResult.SUCCESS)
		  {
			  System.out.println( result.getMethod().getMethodName() +" -- TEST SCENARIO PASSED");
			  extentTest.log(LogStatus.PASS, result.getMethod().getMethodName() +" -- TEST SCENARIO PASSED");			  
		  }
		  else if (result.getStatus() == ITestResult.SKIP)
		  {
			  System.out.println( result.getMethod().getMethodName() +" -- TEST SCENARIO SKIPED");
			  extentTest.log(LogStatus.SKIP, result.getMethod().getMethodName() +" -- TEST SCENARIO SKIPED");
		  }
	}
	
	@AfterClass
	public void teardown() 
	{	
		driver.close();
		driver.quit();
		extentReport.endTest(extentTest);
		extentReport.flush();
	}
	
	@AfterSuite
	public void afterSuite()
	{
		extentReport.close();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = ExtentManager.Path;
		driver.get(url);
	}
}
