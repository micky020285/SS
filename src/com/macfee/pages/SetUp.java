package com.macfee.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mcafee.framework.AutomationHelper;
import com.mcafee.framework.PropertiesReader;

/**
*
* @author Murali
*
*/

public class SetUp 
{
	private  WebDriver driver;
	private  PropertiesReader propObject;
	
	SetUp(WebDriver driver, PropertiesReader propObject)
	{
		this.driver = driver;
		this.propObject=propObject;
	}
	public WebElement getManageUsersLink()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfManageUser")), 20);
	}
	
	public WebElement getProfilesLink()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfProfileElement")), 10);
	}
	public void ClickOnManageUser()
	{
		getManageUsersLink().click();
	}
	
	public Profile ClickOnProfiles()
	{
		getProfilesLink().click();
		return new Profile(driver,propObject);
	}
}
