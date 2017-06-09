package com.mcafee.framework;

import org.openqa.selenium.WebDriver;
import com.macfee.pages.SalesLoginPage;

/**
*
* @author Balamurugan
*
*/

public class CommonFunctions 
{
	private WebDriver driver;
	private PropertiesReader locatorPropReaderObj;

	public CommonFunctions(WebDriver driver, PropertiesReader proObject) 
	{	
		this.driver=driver;
		this.locatorPropReaderObj=proObject;
	}
	
	public SalesLoginPage launchSFApplication()
	{
		driver.get(ConfigData.SFURL);
		return new SalesLoginPage(driver, locatorPropReaderObj);
	}
	
	public WebDriver switchFrame(String id)
	{
		return driver.switchTo().frame(id);
	}
}
