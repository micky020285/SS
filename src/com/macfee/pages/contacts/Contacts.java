package com.macfee.pages.contacts;

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

public class Contacts 
{
	private WebDriver driver;
	private PropertiesReader propObject;
	private String sfContactsTabExpTitle ="Contacts: Home ~ Salesforce - Unlimited Edition";
	
	/*
	private By sfNewAccountsBtnField=By.xpath(".//input[@title='New']");
	private By sfOpportunityStringField=By.id("opp3_ileinner");
	*/
	
	public Contacts(WebDriver driver, PropertiesReader propObject)
	{
		this.driver = driver;
		this.propObject=propObject;
	}
	
	public void verifyIfContactsTab()
	{
		String sfActTitle = driver.getTitle();
		Assert.assertEquals(sfActTitle, sfContactsTabExpTitle);
	}
	
	public WebElement getNewBtnField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfNewBtnField")), 10);
	}
	
	public WebElement getContactsStringField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfContactStringField")), 10);
	}
	
	public String verifyContactCreated()
	{	
		String sfContactName = getContactsStringField().getText();
		System.out.println(sfContactName + " Contacts created in SF Application");
		return sfContactName;
	}
	
	public NewContact onClickNewButton()
	{
		getNewBtnField().click();
		return new NewContact(driver, propObject);
	}

}
