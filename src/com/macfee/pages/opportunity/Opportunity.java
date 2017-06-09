package com.macfee.pages.opportunity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.macfee.pages.SalesHomePage;
import com.mcafee.framework.AutomationHelper;
import com.mcafee.framework.PropertiesReader;

/**
*
* @author Balamurugan
*
*/

public class Opportunity 
{
	private WebDriver driver;
	private PropertiesReader propObject;
	private String sfOpportunityTabExpTitle ="Opportunities: Home ~ Salesforce - Unlimited Edition";
	
	public Opportunity(WebDriver driver, PropertiesReader propObject)
	{
		this.driver = driver;
		this.propObject=propObject;
	}
	
	public void verifyIfOpportunityTab()
	{
		String sfActTitle = driver.getTitle();
		Assert.assertEquals(sfActTitle, sfOpportunityTabExpTitle);
	}
	
	public WebElement getNewOpportunityBtnField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfNewBtnField")), 10);
	}
	
	public WebElement getOpportunityEditField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfEditField")), 10);
	}
	
	public WebElement getOpportunityStringField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfOpportunityStringField")), 10);
	}
	
	public WebElement getOpportunityOwnerLinkField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfOpportunityOwnerLinkField")), 10);
	}
	
	public WebElement getOpportunityOwnerChangeField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfOpportunityOwnerChangeField")), 10);
	}
	
	public WebElement getMenuButtonLabel()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfMenuButtonLabel")), 10);
	}
	
	public WebElement getLogoutLabel()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfLogoutLabel")), 10);
	}
	
	public WebElement getAddProductBtnField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfAddProductBtnField")), 10);
	}
	
	public WebElement getNewAssociatedPartnerBtnField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfNewAssociatedPartnerBtnField")), 10);
	}
	
	public WebElement getProductList()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfAddProductBtnField")), 10);
	}
	
	public String verifyOpportunityCreated()
	{	
		String sfOpportunityName = getOpportunityStringField().getText();
		System.out.println(sfOpportunityName + " Opportunity created in SF Application");
		return sfOpportunityName;
	}
	public String verifyProductAdded()
	{	
		String sfOpportunityString = getOpportunityStringField().getText();
		System.out.println(sfOpportunityString + " Opportunity created in SF Application");
		return sfOpportunityString;
	}
	
	public String fetchOpportunityOwnerName()
	{	
		String sfOpportunityOwnerLink = getOpportunityOwnerLinkField().getText();
		System.out.println("Opportunity owner is " +sfOpportunityOwnerLink);
		return sfOpportunityOwnerLink;
	}
	
	public SalesHomePage onClickLogoutButton() throws InterruptedException
	{
		getMenuButtonLabel().click();
		Thread.sleep(3000);
		getLogoutLabel().click();
		Thread.sleep(3000);
		return new SalesHomePage(driver, propObject);
	}
	
	public NewOpportunity onClickNewButton()
	{
		getNewOpportunityBtnField().click();
		return new NewOpportunity(driver, propObject);
	}
	
	public OpportunityEdit onClickNewButtonPCT()
	{
		getNewOpportunityBtnField().click();
		return new OpportunityEdit(driver, propObject);
	}
	
	public OptyOwnershipEdit onClickOwnerChange()
	{
		getOpportunityOwnerChangeField().click();
		return new OptyOwnershipEdit(driver, propObject);
	}
	
	public NewOpportunity clickEdit() 
	{
		getOpportunityEditField().click();
		return new NewOpportunity(driver, propObject);
	}
	
	public OpportunityProductSelection onClickAddProduct()
	{
		getAddProductBtnField().click();
		return new OpportunityProductSelection(driver, propObject);
	}
	
	public OptyAssociatedPartnerEdit onClickNewAssociatedPartner()
	{
		getNewAssociatedPartnerBtnField().click();
		return new OptyAssociatedPartnerEdit(driver, propObject);
	}
	
}
