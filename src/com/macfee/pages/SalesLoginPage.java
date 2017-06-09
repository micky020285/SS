package com.macfee.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.mcafee.framework.AutomationHelper;
import com.mcafee.framework.PassEncryptCipher;
import com.mcafee.framework.PropertiesReader;

/**
*
* @author Balamurugan
*
*/

public class SalesLoginPage 
{
	private WebDriver driver;
	private PropertiesReader propObject;
	private static PassEncryptCipher passEncryptCipher;
	
	public SalesLoginPage(WebDriver driver, PropertiesReader propObject) 
	{	
		this.driver=driver;	
		this.propObject=propObject;
	}
	
	public WebElement getUserNameField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("userNameField")), 30);
	}
	
	public WebElement getpasswordField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("passwordField")), 30);
	}
	
	public WebElement getloginButton()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("loginButton")), 30);
	}
	
	public SalesHomePage doLogIn(String userName, String password)
	{
		PassEncryptCipher td=null;
		try 
		{
			td = new PassEncryptCipher();
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		getUserNameField().sendKeys(userName);
		String decrypted = td.decrypt(password);  
		getpasswordField().sendKeys(decrypted);
		getloginButton().click();
		return new SalesHomePage(driver, propObject);
	}
}
