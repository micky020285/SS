package com.macfee.pages.accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.mcafee.framework.AutomationHelper;
import com.mcafee.framework.PropertiesReader;

/**
*
* @author Balamurugan
*
*/

public class NewAccounts 
{
	private WebDriver driver;
	private PropertiesReader propObject;
	private String sfNewAccountExpTitle = "Select a record type for the new account";
	
	/*
	private By sfRecordTypeDDField=By.id("p3");
	private By sfContinueBtnField=By.xpath(".//input[@title = 'Continue']");
	*/
	
	public NewAccounts(WebDriver driver, PropertiesReader propObject) 
	{
		this.driver = driver;
		this.propObject=propObject;
	}
	
	public void verifyInNewAccountPage()
	{		
		Assert.assertEquals(getRecordTypeDDField().isDisplayed(), true , sfNewAccountExpTitle);
	}
	
	public WebElement getRecordTypeDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfRecordTypeDDField")), 10);
	}
	
	public WebElement getContinueBtnField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfContinueBtnField")), 10);
	}
	
	public void selectAccountRecordType(String recordtype) throws Exception 
	{ 		
		Select dropdown= new Select(getRecordTypeDDField()); 
		dropdown.selectByVisibleText(recordtype); 
		System.out.println("Account Record Type is " + recordtype);
 	}
	 
	public AccountSearch onClickContinue()
	{
		getContinueBtnField().click();
		return new AccountSearch(driver, propObject);
	}
}
