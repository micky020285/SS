package com.macfee.pages.leads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.mcafee.framework.AutomationHelper;
import com.mcafee.framework.PropertiesReader;

public class Leads {

	private WebDriver driver;
	private PropertiesReader propObject;
	//private String sfAccountsTabExpTitle ="Accounts: Home ~ Salesforce - Unlimited Edition";
	
	public Leads(WebDriver driver, PropertiesReader propObject)
	{
		this.driver = driver;
		this.propObject=propObject;
	}
	
	/*public void verifyIfAccountsTab()
	{
		String sfActTitle = driver.getTitle();
		Assert.assertEquals(sfActTitle, sfAccountsTabExpTitle);
	}
	*/
	public WebElement getNewLeadsBtnField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfNewBtnField")), 10);
	}
	public NewLead onClickNew() throws InterruptedException 
	{
		getNewLeadsBtnField().click();
		
		System.out.println("New button clicked");
		Thread.sleep(3000);
		return new NewLead(driver, propObject);
	}
	
	public WebElement getLeadNameField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfLeadNameField")), 10);
	}
	
	public String verifyLeadCreated()
	{	
		String leadName = getLeadNameField().getText();
		System.out.println(leadName + " Lead created in SF Application");
		return leadName;
	}
	
	public void onClickContinueButton()
	{
		getNewLeadsBtnField().click();
		//return new LeadRecordType(driver, propObject);
	}
}

