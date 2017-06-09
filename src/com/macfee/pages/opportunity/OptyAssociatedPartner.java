package com.macfee.pages.opportunity;
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

public class OptyAssociatedPartner 
{
	private WebDriver driver;
	private PropertiesReader propObject;
	
	public OptyAssociatedPartner(WebDriver driver, PropertiesReader propObject)
	{
		this.driver = driver;
		this.propObject=propObject;
	}
	
	public WebElement getOpportunityNameLabel()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfOpportunityNameLabel")), 10);
	}
	
	public String fetchOpportunityName()
	{	
		String OpportunityName = getOpportunityNameLabel().getText();
		System.out.println("Opportunity name linked with Partner  is " +OpportunityName);
		return OpportunityName;
	}
}
