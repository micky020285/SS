package com.macfee.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.macfee.pages.accounts.Accounts;
import com.macfee.pages.contacts.Contacts;
import com.macfee.pages.leads.Leads;
import com.macfee.pages.opportunity.Opportunity;
import com.mcafee.framework.AutomationHelper;
import com.mcafee.framework.PropertiesReader;

/**
*
* @author Balamurugan
*
*/

public class SalesHomePage 
{
	private WebDriver driver;
	private PropertiesReader propObject;
	private String sfHomePageExpTitle = "Consumer Contacts: Home ~ Salesforce - Unlimited Edition";

	public SalesHomePage(WebDriver driver, PropertiesReader propObject) 
	{
		this.driver=driver;
		this.propObject=propObject;
	}
	
	public void verifyIfHomeTab()
	{
		String sfActTitle = driver.getTitle();
		Assert.assertEquals(sfActTitle, sfHomePageExpTitle);
	}
	
	public boolean isHomePageLaunched()
	{		
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfHomeTabField")), 15).isDisplayed();
	}
	
	public WebElement getSearchTxtFiled()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfSearchTxtField")), 10);
	}
	
	public WebElement getSearchBtnFiled()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfSearchBtnField")), 10);
	}
	
	public WebElement getUserDetailsMenuBtnFiled()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfUserActionMenuBtnField")), 10);
	}
	
	public WebElement getUserDetailsSubMenuFiled()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfUserDetailSubMenuField")), 10);
	}
	
	public WebElement getEditBtnFiled()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfEditField")), 10);
	}
	
	public WebElement getRoleDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfroleDDField")), 10);
	}
	
	public WebElement getProfileDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfProfileDDField")), 10);
	}
	
	public WebElement getSaveBtnFiled()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfSaveBtnField")), 10);
	}
	
	public WebElement getLoginBtnFiled()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfLoginBtnField")), 10);
	}
	
	public WebElement getUserNameLinkFiled()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfUserNameLinkField")), 10);
	}
	
	public WebElement getOptyNameLinkField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfOptyNameLinkField")), 10);
	}
	
    public WebElement getTopRightCornerUserMenuField()
    {
    	return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfTopRightCornerUserMenu")), 50);   
    }
    
	public WebElement getTopRightCornerSetupSubMenuField()
    {
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfTopRightCornerSetupSubMenu")), 10);  
    }
    
    public WebElement getTopCenterUserMenuField()
    {
        return AutomationHelper.findElement(driver, By.id(propObject.getData("sfMenuButtonLabel")), 10);
    }
    
    public WebElement getTopRightCornerLogoutSubMenuField()
    {
        return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfLogoutLabel")), 20);
    }
	
	public void selectUserRole(String testUserRole)
	{
		Select dropdown= new Select(getRoleDDField()); 
		dropdown.selectByVisibleText(testUserRole); 
		System.out.println("User Role is " + testUserRole);
	}
	
	public void selectUserProfile(String testUserProfile)
	{
		Select dropdown= new Select(getProfileDDField()); 
		dropdown.selectByVisibleText(testUserProfile); 
		System.out.println("User Profile is " + testUserProfile);
	}
	
	public SalesHomePage onClickHomeTab()
	{
		AutomationHelper.findElement(driver, By.id(propObject.getData("sfHomeTabField")), 10).click();
		return new SalesHomePage(driver, propObject);
	}
	
	public Opportunity onClickChatterTab()
	{
		AutomationHelper.findElement(driver, By.id(propObject.getData("sfChatterTabField")), 10).click();
		return new Opportunity(driver, propObject);
	}
	
	public Profile onClickProfileTab()
	{
		AutomationHelper.findElement(driver, By.id(propObject.getData("sfProfileTabField")), 10).click();
		return new Profile(driver, propObject);
	}
	
	public Opportunity onClickGroupTab()
	{
		AutomationHelper.findElement(driver, By.id(propObject.getData("sfGroupTabField")), 10).click();
		return new Opportunity(driver, propObject);
	}
	
	public Opportunity onClickFileTab()
	{
		AutomationHelper.findElement(driver, By.id(propObject.getData("sfFileTabField")), 10).click();
		return new Opportunity(driver, propObject);
	}
	
	public Leads onClickLeadTab()
	{
		AutomationHelper.findElement(driver, By.id(propObject.getData("sfLeadTabField")), 10).click();
		return new Leads(driver, propObject);
	}
	
	public Accounts onClickAccountTab()
	{
		AutomationHelper.findElement(driver, By.id(propObject.getData("sfAccountTabField")), 10).click();
		return new Accounts(driver, propObject);
	}
	
	public Contacts onClickContactTab()
	{
		AutomationHelper.findElement(driver, By.id(propObject.getData("sfContactTabField")), 10).click();
		return new Contacts(driver, propObject);
	}
	
	public Opportunity onClickOpportunityTab()
	{
		AutomationHelper.findElement(driver, By.id(propObject.getData("sfOpportunityTabField")), 10).click();
		return new Opportunity(driver, propObject);
	}
	
	public Opportunity onClickReportsTab()
	{
		AutomationHelper.findElement(driver, By.id(propObject.getData("sfReportsTabField")), 10).click();
		return new Opportunity(driver, propObject);
	}
	
	public Opportunity onClickDashboardsTab()
	{
		AutomationHelper.findElement(driver, By.id(propObject.getData("sfDashboardsTabField")), 10).click();
		return new Opportunity(driver, propObject);
	}
	
	public Opportunity onClickProductsTab()
	{
		AutomationHelper.findElement(driver, By.id(propObject.getData("sfProductsTabField")), 10).click();
		return new Opportunity(driver, propObject);
	}
	
	public Opportunity onClickForecastsTab()
	{
		AutomationHelper.findElement(driver, By.id(propObject.getData("sfForecastsTabField")), 10).click();
		return new Opportunity(driver, propObject);
	}
	
	public Opportunity onClickPartnerProvisioningPermissionsTab()
	{
		AutomationHelper.findElement(driver, By.id(propObject.getData("sfPartnerProvisioningPermissionsTabField")), 10).click();
		return new Opportunity(driver, propObject);
	}
	
	public Opportunity onClickQuoteTab()
	{
		AutomationHelper.findElement(driver, By.id(propObject.getData("sfQuoteTabField")), 10).click();
		return new Opportunity(driver, propObject);
	}
	
	public void globalSearch(String testUserName)
	{
		getSearchTxtFiled().sendKeys(testUserName);
		getSearchBtnFiled().click();
	}
	
	public void selectUser()
	{
		getUserNameLinkFiled().click();
	}
	
	public void selectOpty()
	{
		getOptyNameLinkField().click();
	}
	
	public void onClickUserActionMenu()
	{
		getUserDetailsMenuBtnFiled().click();
		getUserDetailsSubMenuFiled().click();
	}
	
	public void editUserRoleProfile(String userRole, String userProfile)
	{
		getEditBtnFiled().click();
		selectUserRole(userRole);
		selectUserProfile(userProfile);
		getSaveBtnFiled().click();
	}
    
    public void SelectTopRightCornerUserMenu()
    {
    	getTopRightCornerUserMenuField().click();
    	System.out.println("Clicked Top Right Corner User Main Menu");
    }
    
    public SetUp SelectTopRightCornerSetupSubMenu()
    {
    	getTopRightCornerSetupSubMenuField().click();
        System.out.println("Clicked Top Right Corner User Setup Sub-Menu");
        return new SetUp(driver,propObject);
    }
    
	public SalesHomePage SelectTopRightCornerLogoutSubMenu()
	{
		getTopRightCornerLogoutSubMenuField().click();
		System.out.println("Clicked Top Right Corner User Logout Sub-Menu");
		return new SalesHomePage(driver, propObject);
	}

    public SalesHomePage onClickTopRightLogoutButton() throws InterruptedException
    {
    	//getTopCenterUserMenuField().click();
    	Thread.sleep(3000);
    	SelectTopRightCornerUserMenu();
    	Thread.sleep(3000);
    	SelectTopRightCornerLogoutSubMenu();
    	Thread.sleep(3000);
    	return new SalesHomePage(driver, propObject);
    }
    
	public SalesHomePage onClickLoginBtn()
	{
		getLoginBtnFiled().click();
		return new SalesHomePage(driver, propObject);
	}
}
