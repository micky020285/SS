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

public class OptyOwnershipEdit 
{
	private WebDriver driver;
	private PropertiesReader propObject;
	
	public OptyOwnershipEdit(WebDriver driver, PropertiesReader propObject)
	{
		this.driver = driver;
		this.propObject=propObject;
	}
	
	public WebElement getOptyOwnerDDField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfOptyOwnerDDField")), 10);
	}
	
	public WebElement getOptyOwnerTxtField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfOptyOwnerTxtField")), 10);
	}
	
	public WebElement getSaveBtnField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfSaveBtnField")), 10);
	}
	
	
	public void selectOpportunityOwner(String owner)
	{
		Select dropdown= new Select(getOptyOwnerDDField()); 
		dropdown.selectByVisibleText(owner); 
		System.out.println("Opportunity owner type is " + owner);
	}
	
	public void putOptyOwnerTxtField(String OwnerName)
	{
		getOptyOwnerTxtField().sendKeys(OwnerName);
		System.out.println("Owner Name is " + OwnerName);
	}
	
	public Opportunity onClickSave() 
	{
		getSaveBtnField().click();
		System.out.println("Save button clicked");
		return new Opportunity(driver, propObject);
	}
}
