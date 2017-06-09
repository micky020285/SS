package com.macfee.pages.opportunity;

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

public class NewOpportunity 
{
	private WebDriver driver;
	private PropertiesReader propObject;
	private String sfNewOpportunityExpTitle = "Select a record type for the new opportunity";
	
	/*
	private By sfRecordTypeDDField=By.id("p3");
	private By sfContinueBtnField=By.xpath(".//input[@title = 'Continue']");
	*/
	
	public NewOpportunity(WebDriver driver, PropertiesReader propObject) 
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
	
	public void verifyInNewOpportunityPage()
	{		
		Assert.assertEquals(getRecordTypeDDField().isDisplayed(), true , sfNewOpportunityExpTitle);
	}
	
	public void selectOpportunityRecordType(String recordtype) throws Exception 
	{ 		
		Select dropdown= new Select(getRecordTypeDDField()); 
		dropdown.selectByVisibleText(recordtype); 
		System.out.println("Opportunity Record Type is " + recordtype);
 	}
	 
	public OpportunityEdit onClickContinue()
	{
		getContinueBtnField().click();
		return new OpportunityEdit(driver, propObject);
	}
}
