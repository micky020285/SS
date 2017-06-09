package com.macfee.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.mcafee.framework.AutomationHelper;
import com.mcafee.framework.PropertiesReader;

/**
*
* @author Balamurugan & Murali
*
*/

public class Profile 
{
	private WebDriver driver;
	private PropertiesReader propObject;
	private String sfProfileTabExpTitle ="Profile: Home ~ Salesforce - Unlimited Edition";
	
	Profile(WebDriver driver, PropertiesReader propObject)
	{
		this.driver = driver;
		this.propObject=propObject;
	}
	
	public void verifyIfProfileTab()
	{
		String sfActTitle = driver.getTitle();
		Assert.assertEquals(sfActTitle, sfProfileTabExpTitle);
	}
	
	public WebElement getUserDetailsMenuBtnFiled()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfUserActionMenuBtnField")), 10);
	}
	
	public WebElement getUserDetailsSubMenuFiled()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfUserDetailSubMenuField")), 10);
	}
	
	public WebElement getUserProfileSelection()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfProfileUserSelection")), 10);
	}
	
	public WebElement getUserProfileUserDetails()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfUserViewDetails")), 10);
	}
	
	public WebElement getUserSelect()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfUserSelect")), 10);
	}
	
	public boolean getUserProfileSelectchk()
	{
		 return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfProfileUserSelection")), 10).isDisplayed();
	}
	
	public void onClickUserProfile()
	{
		getUserProfileSelection().click();
	}
		
	public void onClickUserViewDetails()
	{
		getUserProfileUserDetails().click();
		
	}
	public void onClickUserLoginLink()
	{
		getUserSelect().click();
	}
	
	public void onClickUserActionMenu()
	{
		getUserDetailsMenuBtnFiled().click();
		getUserDetailsSubMenuFiled().click();
	}
}
