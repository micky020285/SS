package com.macfee.pages.leads;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import com.mcafee.framework.AutomationHelper;
import com.mcafee.framework.PropertiesReader;

public class LeadConvert 
{
	private WebDriver driver;
	private PropertiesReader propObject;
	
	public LeadConvert (WebDriver driver, PropertiesReader propObject) 
	{
		this.driver = driver;
		this.propObject=propObject;
	}
	public WebElement getLeadNameField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfLeadName")), 10);
	}
	
	public String verifyLeadCreated()
	{	
		String leadName = getLeadNameField().getText();
		System.out.println(leadName + " Lead created in SF Application");
		return leadName;
	}
	public WebElement getLeadAddProductField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfLeadAddProductField")), 10);
	}
	public void SelectsfLeadAddProductField() throws InterruptedException
	{
		Actions act = new Actions(driver);
		act.doubleClick(getLeadAddProductField()).perform();
		Thread.sleep(5000);
	}
	
	public WebElement getLeadProductInterestMSL()
	{
		return AutomationHelper.findElement(driver, By.cssSelector(propObject.getData("sfLeadProductInterestMSL")), 10);
	}
	public void selectLeadProductInterest() throws InterruptedException
	{
	Select multiselectlistbox = new Select(getLeadProductInterestMSL());
	List<WebElement> elementCount = multiselectlistbox.getOptions();

	for (int i = 0; i <=1; i++) 
	{
	multiselectlistbox.selectByVisibleText(elementCount.get(i).getText());
	System.out.println("Product selected Multi Select Listbox  is " + i);
	}
	Thread.sleep(2000);
	}
	
	public WebElement getLeadProductRightArrowBtnField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfLeadProductRightArrowBtnField")), 10);
	}
	public void SelectLeadProductRightArrowBtnField() throws InterruptedException
	{
		WebElement ele1=getLeadProductRightArrowBtnField();
		   
	    Capabilities cp = ((RemoteWebDriver) driver).getCapabilities();
        if (cp.getBrowserName().equals("chrome")) {
            try {
                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].scrollIntoView(true);", ele1);
            } catch (Exception e) {

            }
        }

        ele1.click();
        System.out.println("RightArrow Button Clicked");
        Thread.sleep(2000);
	}
	public WebElement getLeadProductOkBtn()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfLeadProductOkBtn")), 10);
	}
	public void SelectLeadProductOkBtn()
	{
		getLeadProductOkBtn().click();
		System.out.println("Ok Button Clicked");
	}
	public WebElement getLeadProductSaveBtn()
	{
		return AutomationHelper.findElement(driver, By.name(propObject.getData("sfLeadProductSaveBtn")), 10);
	}
	public void SelectLeadProductSaveBtn() throws InterruptedException
	{
		getLeadProductSaveBtn().click();
		System.out.println("Save Button Clicked");
		Thread.sleep(10000);
	}
	public WebElement getLeadProductConvertBtn()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfLeadProductConvertBtn")), 10);
	}
	public Leads SelectLeadProductConvertBtn() 
	{
		getLeadProductConvertBtn().click();
		System.out.println("Convert Button Clicked");
		return new Leads(driver, propObject);
	}
}
