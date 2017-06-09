package com.macfee.pages.opportunity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.mcafee.framework.AutomationHelper;
import com.mcafee.framework.PropertiesReader;


public class OpportunityAddProduct  
{
	private WebDriver driver;
	private PropertiesReader propObject;
	private String sfNewOpportunityExpTitle = "Select a record type for the new opportunity";
	
	/*
	private By sfRecordTypeDDField=By.id("p3");
	private By sfContinueBtnField=By.xpath(".//input[@title = 'Continue']");
	*/
	
	public OpportunityAddProduct(WebDriver driver, PropertiesReader propObject) 
	{
		this.driver = driver;
		this.propObject=propObject;
	}
	
	public WebElement getOptyAddProductUnitPriceTxtField1()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfOptyAddProductUnitPriceTxtField1")), 10);
	}
	
	public WebElement getOptyAddProductUnitPriceTxtField2()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfOptyAddProductUnitPriceTxtField2")), 10);
	}
	
	public WebElement getOptyAddProductQuantityTxtField1()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfOptyAddProductQuantityTxtField1")), 10);
	}
	
	public WebElement getOptyAddProductQuantityTxtField2()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfOptyAddProductQuantityTxtField2")), 10);
	}
	
	public WebElement getOptyAddProductDescriptionTxtField1()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfOptyAddProductDescriptionTxtField1")), 10);
	}
	
	public WebElement getOptyAddProductDescriptionTxtField2()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfOptyAddProductDescriptionTxtField2")), 10);
	}
	
	public WebElement getSaveBtnField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfSaveBtnField")), 10);
	}
	
	public void putOptyAddProductUnitPriceTxtField1(String OptyAddProductUnitPrice)
	{
		getOptyAddProductUnitPriceTxtField1().clear();
		getOptyAddProductUnitPriceTxtField1().sendKeys(OptyAddProductUnitPrice);
		System.out.println("Opty Add Product Unit Price1 is " + OptyAddProductUnitPrice);
	}
	
	public void putOptyAddProductUnitPriceTxtField2(String OptyAddProductUnitPrice)
	{
		getOptyAddProductUnitPriceTxtField2().clear();
		getOptyAddProductUnitPriceTxtField2().sendKeys(OptyAddProductUnitPrice);
		System.out.println("Opty Add Product Unit Price2 is " + OptyAddProductUnitPrice);
	}
	
	public void putOptyAddProductQuantityTxtField1(String OptyAddProductQuantity)
	{
		getOptyAddProductQuantityTxtField1().sendKeys(OptyAddProductQuantity);
		System.out.println("Opty Add Product Quantity1 is " + OptyAddProductQuantity);
	}
	
	public void putOptyAddProductQuantityTxtField2(String OptyAddProductQuantity)
	{
		getOptyAddProductQuantityTxtField2().sendKeys(OptyAddProductQuantity);
		System.out.println("Opty Add Product Quantity2 is " + OptyAddProductQuantity);
	}
	
	public void putOptyAddProductDescriptionTxtField1(String OptyAddProductDescription)
	{
		getOptyAddProductDescriptionTxtField1().sendKeys(OptyAddProductDescription);
		System.out.println("Opty Add Product Description is " + OptyAddProductDescription);
	}
	
	public void putOptyAddProductDescriptionTxtField2(String OptyAddProductDescription)
	{
		getOptyAddProductDescriptionTxtField2().sendKeys(OptyAddProductDescription);
		System.out.println("Opty Add Product Description is " + OptyAddProductDescription);
	}
	
	public Opportunity onClickSave() 
	{
		getSaveBtnField().click();
		return new Opportunity(driver, propObject);
	}
}