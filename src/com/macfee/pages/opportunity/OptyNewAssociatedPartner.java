package com.macfee.pages.opportunity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.mcafee.framework.AutomationHelper;
import com.mcafee.framework.PropertiesReader;


public class OptyNewAssociatedPartner 
{
	private WebDriver driver;
	private PropertiesReader propObject;
	
	public OptyNewAssociatedPartner(WebDriver driver, PropertiesReader propObject) 
	{
		this.driver = driver;
		this.propObject=propObject;
	}
	
	public WebElement getRecordTypeDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfRecordTypeDDField")), 10);
	}
	
	public WebElement getContinueBtnField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfContinueBtnField")), 10);
	}
	
	public void selectAssociatedPartnerRecordType(String recordtype) throws Exception 
	{ 		
		Select dropdown= new Select(getRecordTypeDDField()); 
		dropdown.selectByVisibleText(recordtype); 
		System.out.println("Opty New Associated Partner Record Type is " + recordtype);
 	}
	 
	public OptyAssociatedPartnerEdit onClickContinue()
	{
		getContinueBtnField().click();
		return new OptyAssociatedPartnerEdit(driver, propObject);
	}
	
}