package com.mcafee.framework;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

/**
*
* @author Balamurugan
*
*/

public class TestListener implements ITestListener 
{
	WebDriver driver=null;
	String filepath="./test-output/screenshots/";

	@Override
	public void onTestStart(ITestResult result) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		//takeScreenShot(result.getTestClass().getName()+result.getStartMillis(), result);
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{	
		takeScreenShot(result.getTestClass().getName()+result.getStartMillis(), result);
	}
	
	public void takeScreenShot(String methodName,ITestResult result) 
	{
	   	//get the driver
		if(!new File(filepath).exists())
		{
			new File(filepath).mkdirs();
		}
	    driver=WebdriverInitializer.webDriver;
	    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    //The below method will save the screen shot in d drive with test method name 
	    try {
				File file = new File(filepath+methodName+".png");
				FileUtils.copyFile(scrFile, file);
				Reporter.setCurrentTestResult(result); 
				Reporter.log("<br> <img src='"+file.getAbsolutePath()+"'/> <br>");
				Reporter.setCurrentTestResult(null); 
				System.out.println("***Placed screen shot in "+filepath+" ***");
			} catch (IOException e) 
	    		{
					e.printStackTrace();
				}
	  }

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		// TODO Auto-generated method stub
	}
}
