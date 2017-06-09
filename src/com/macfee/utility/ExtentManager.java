package com.macfee.utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

import com.mcafee.framework.PropertiesReader;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

/**
 * @author magesh
 *
 */
public class ExtentManager 
{
	private static ExtentReports extent;
	public static PropertiesReader configpropReaderObj;
	static Date date = new Date();  
	static SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");  
	static String strDate= formatter.format(date);  
	public static String Path =  System.getProperty("user.dir")+"\\test_output\\Automation_Report_"+strDate+".html";
	
	public static ExtentReports Instance()
	{
		extent = new ExtentReports(Path, true, DisplayOrder.NEWEST_FIRST);
		extent.addSystemInfo("Environment", "QA");
		//String browser=configpropReaderObj.getData("browser");
		//extent.addSystemInfo("Browser", browser);
        extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent_config.xml"));
		return extent;
	}
}