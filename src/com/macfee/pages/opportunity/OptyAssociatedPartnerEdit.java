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

public class OptyAssociatedPartnerEdit 
{
	private WebDriver driver;
	private PropertiesReader propObject;
	
	public OptyAssociatedPartnerEdit(WebDriver driver, PropertiesReader propObject)
	{
		this.driver = driver;
		this.propObject=propObject;
	}
	
	public WebElement getOptyPartnerAccountTxtField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfOptyPartnerAccountTxtField")), 10);
	}
	
	public void putOptyPartnerAccountTxtField(String OptyPartnerAccount)
	{
		getOptyPartnerAccountTxtField().sendKeys(OptyPartnerAccount);
		System.out.println("Opty Partner Account  is " + OptyPartnerAccount);
	}
	
	public WebElement getSaveBtnField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfSaveBtnField")), 10);
	}
	
	public OptyAssociatedPartner onClickSave()
	{
		getSaveBtnField().click();
		return new OptyAssociatedPartner(driver, propObject);
	}
	
}
