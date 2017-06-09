package com.macfee.pages.accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.mcafee.framework.AutomationHelper;
import com.mcafee.framework.PropertiesReader;

/**
*
* @author Balamurugan
*
*/

public class AccountSearch 
{
	private WebDriver driver;
	private PropertiesReader propObject;
	//private String sfAccountSearchExpTitle ="Smart Account Search";
	
	AccountSearch(WebDriver driver, PropertiesReader propObject)
	{
		this.driver = driver;
		this.propObject=propObject;
	}
	
	public void verifyInAccountSearchPage()
	{		
		//Assert.assertEquals(getRecordTypeDDField().isDisplayed(), true, sfAccountSearchExpTitle);
	}
	
	public WebElement getAccountNameTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfAccountSearchAccountNameTxtField")), 10);
	}
	
	public WebElement getAccountNameLocalTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfAccountNameLocalTxtField")), 10);
	}
	
	public WebElement getStreetNameTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfStreetNameTxtField")), 10);
	}
	
	public WebElement getCityNameTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfCityNameTxtField")), 10);
	}
	
	public WebElement getStateNameTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfStateNameTxtField")), 10);
	}
	
	public WebElement getZipCodeNameTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfZipCodeNameTxtField")), 10);
	}
	
	public WebElement getCountryNameDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfCountryNameDDField")), 10);
	}
	
	public WebElement getAccountSearchBtnField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfAccountSearchBtnField")), 10);
	}
	
	public WebElement getNewAccountsBtnField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfNewAccountsBtnField")), 10);
	}
	
	public void putAccountName(String accountname)
	{
		getAccountNameTxtField().sendKeys(accountname);
		System.out.println("Account Name " + accountname);
	}
	
	public void putAccountNameLocal(String accountnamelocal)
	{
		getAccountNameLocalTxtField().sendKeys(accountnamelocal);
		System.out.println("Account Localname " + accountnamelocal);
	}
	
	public void selectCountryName(String countryname) throws Exception 
	{ 		
		Select dropdown= new Select(getCountryNameDDField()); 
		dropdown.selectByVisibleText(countryname); 
		System.out.println("Country Name is " + countryname);
 	}
	
	public void onClickAccountSearchBtn()
	{
		getAccountSearchBtnField().click();
	    WebDriverWait wait = new WebDriverWait(driver, 90);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='pbHeader']//input[@name='pg:frm:j_id63:searchlistcomponent:pageBlock:j_id68:j_id69']")));
	    System.out.println("On Click Account Search Button");
	}
	
	public AccountsEdit onClickNewAccountsBtn()
	{
		/*
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", getNewAccountsBtnField());
		*/
		
		/*
		while(getNewAccountsBtnField().isDisplayed()) 
		{
			 getNewAccountsBtnField().click();
			 System.out.println("On Click Account New Button");
		}
		*/
		boolean elementdisplayed=true;
		do{
			 try{
				 	getNewAccountsBtnField().click(); 
			 	}
			 catch(Exception ex)
			 {
				 elementdisplayed=false;
			 }
			 System.out.println("On Click Account New Button");
		}
		while(elementdisplayed);
		return new AccountsEdit(driver, propObject);
	}
}
