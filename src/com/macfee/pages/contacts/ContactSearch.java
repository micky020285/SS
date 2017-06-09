package com.macfee.pages.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mcafee.framework.AutomationHelper;
import com.mcafee.framework.PropertiesReader;

/**
*
* @author Balamurugan
*
*/

public class ContactSearch 
{
	private WebDriver driver;
	private PropertiesReader propObject;
	//private String sfAccountSearchExpTitle ="Smart Account Search";
	
	ContactSearch(WebDriver driver, PropertiesReader propObject)
	{
		this.driver = driver;
		this.propObject=propObject;
	}
	
	public void verifyInContactSearchPage()
	{		
		//Assert.assertEquals(getRecordTypeDDField().isDisplayed(), true, sfAccountSearchExpTitle);
	}
	
	public WebElement getFirstNameTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfContactFirstNameTxtField")), 10);
	}
	
	public WebElement getLastNameTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfContactLastNameTxtField")), 10);
	}
	
	public WebElement getBusinessEmailTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfContactBusinessEmailTxtField")), 10);
	}
	
	public WebElement getAccountNameTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfContactAccountNameTxtField")), 10);
	}

	public WebElement getContactSearchBtnField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfContactSearchBtnField")), 10);
	}
	
	public WebElement getNewContactBtnField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfNewContactBtnField")), 10);
	}
	
	public void putFirstName(String firstname)
	{
		getFirstNameTxtField().sendKeys(firstname);
		System.out.println("First Name " + firstname);
	}
	
	public void putLastName(String lastname)
	{
		getLastNameTxtField().sendKeys(lastname);
		System.out.println("Last Name " + lastname);
	}
	
	public void putBusinessEmailTxtField(String businessemail)
	{
		getBusinessEmailTxtField().sendKeys(businessemail);
		System.out.println("Business Email " + businessemail);
	}
	
	public void putSearchEndCustomerAccountName(String accountname)
	{
		getAccountNameTxtField().sendKeys(accountname);
		System.out.println("Account Name " + accountname);
	}
	
	public void onClickContactSearchBtn()
	{
		getContactSearchBtnField().click();
	}
	
	public ContactsEdit onClickNewContactBtn()
	{
		boolean elementdisplayed=true;
		do{
			 try{
				 	getNewContactBtnField().click(); 
			 	}
			 catch(Exception ex)
			 {
				 elementdisplayed=false;
			 }
			 System.out.println("On Click Account New Button");
		}
		while(elementdisplayed);
		//getNewContactBtnField().click();
		return new ContactsEdit(driver, propObject);
	}
}
