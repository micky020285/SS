package com.macfee.pages.accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.mcafee.framework.AutomationHelper;
import com.mcafee.framework.PropertiesReader;

/**
*
* @author Balamurugan
*
*/

public class Accounts 
{
	private WebDriver driver;
	private PropertiesReader propObject;
	private String sfAccountsTabExpTitle ="Accounts: Home ~ Salesforce - Unlimited Edition";
	
	public Accounts(WebDriver driver, PropertiesReader propObject)
	{
		this.driver = driver;
		this.propObject=propObject;
	}
	
	public void verifyIfAccountsTab()
	{
		String sfActTitle = driver.getTitle();
		Assert.assertEquals(sfActTitle, sfAccountsTabExpTitle);
	}
	
	public WebElement getNewAccountsBtnField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfNewBtnField")), 10);
	}
	
	public WebElement getAccountStringField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfAccountStringField")), 10);
	}
	
	public String verifyAccountCreated()
	{	
		String sfAccountName = getAccountStringField().getText();
		System.out.println(sfAccountName + " Account created in SF Application");
		return sfAccountName;
	}
	
	public NewAccounts onClickNewButton()
	{
		getNewAccountsBtnField().click();
		return new NewAccounts(driver, propObject);
	}
}
