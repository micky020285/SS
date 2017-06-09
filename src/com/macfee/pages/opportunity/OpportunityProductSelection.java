package com.macfee.pages.opportunity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mcafee.framework.AutomationHelper;
import com.mcafee.framework.PropertiesReader;


public class OpportunityProductSelection 
{
	private WebDriver driver;
	private PropertiesReader propObject;
	
	public OpportunityProductSelection(WebDriver driver, PropertiesReader propObject) 
	{
		this.driver = driver;
		this.propObject=propObject;
	}
	
	public WebElement getOptyProductSelect1ChkBoxField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfOptyProductSelect1ChkBoxField")), 10);
	}
	
	public WebElement getOptyProductSelect2ChkBoxField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfOptyProductSelect2ChkBoxField")), 10);
	}
	
	public WebElement getOptyProductSelectBtnField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfOptyProductSelectBtnField")), 10);
	}
	
	public void selectOptyProductSelect1ChkBoxField()
	{		
		if (!getOptyProductSelect1ChkBoxField().isSelected())
		{
			getOptyProductSelect1ChkBoxField().click();
			System.out.println("Opty Product Select1 CheckBox Field is Selected");
		}
		else
		{
			System.out.println("Opty Product Select1 CheckBox Field is already Selected");
		}
	}
	
	public void selectOptyProductSelect2ChkBoxField()
	{		
		if (!getOptyProductSelect2ChkBoxField().isSelected())
		{
			getOptyProductSelect2ChkBoxField().click();
			System.out.println("Opty Product Select2 CheckBox Field is Selected");
		}
		else
		{
			System.out.println("Opty Product Select2 CheckBox Field is already Selected");
		}
	}
	
	public OpportunityAddProduct onClickSelect() 
	{
		getOptyProductSelectBtnField().click();
		return new OpportunityAddProduct(driver, propObject);
	}
	
	
}