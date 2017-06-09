package com.macfee.pages.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.mcafee.framework.AutomationHelper;
import com.mcafee.framework.PropertiesReader;

public class NewContact 
{
	private WebDriver driver;
	private PropertiesReader propObject;
	private String sfNewContactExpTitle = "Select Contact Record Type";
	
	public NewContact(WebDriver driver, PropertiesReader propObject) 
	{
		this.driver = driver;
		this.propObject=propObject;
	}
	
	public void verifyInNewContactPage()
	{		
		Assert.assertEquals(getRecordTypeDDField().isDisplayed(), true , sfNewContactExpTitle);
	}
	
	public WebElement getRecordTypeDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfRecordTypeDDField")), 10);
	}
	
	public WebElement getContinueBtnField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfContinueBtnField")), 10);
	}
	
	public void selectContactRecordType(String recordtype) 
	{ 		
		Select dropdown= new Select(getRecordTypeDDField()); 
		dropdown.selectByVisibleText(recordtype); 
		System.out.println("Contact Record Type is " + recordtype);
 	}
	 
	public ContactSearch onClickContinue()
	{
		getContinueBtnField().click();
		return new ContactSearch(driver, propObject);
	}
	
	public ContactsEdit onClickContinueBtn()
	{
		getContinueBtnField().click();
		return new ContactsEdit(driver, propObject);
	}
}
