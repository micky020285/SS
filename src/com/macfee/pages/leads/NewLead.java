package com.macfee.pages.leads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.mcafee.framework.AutomationHelper;
import com.mcafee.framework.PropertiesReader;

/**
*
* @author Michael
*
*/

public class NewLead 
{
		private WebDriver driver;
		private PropertiesReader propObject;
		
		public NewLead (WebDriver driver, PropertiesReader propObject) 
		{
			this.driver = driver;
			this.propObject=propObject;
		}
		
		public WebElement getLeadRecordTypeDDField()
		{
			return AutomationHelper.findElement(driver, By.id(propObject.getData("sfRecordTypeDDField")), 10);
		}
		
		public void selectLeadRecordGroup(String leadRecordType) throws Exception 
		{
			Select dropdown= new Select(getLeadRecordTypeDDField()); 
			dropdown.selectByVisibleText(leadRecordType); 
			System.out.println("Lead Record Type " + leadRecordType);
		}
		
		public WebElement getContinueBtnField()
		{
			return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfContinueBtnField")), 10);
		}
		
		public LeadEdit onClickContinueBtn() throws InterruptedException
		{
			getContinueBtnField().click();
			
			Thread.sleep(3000);
		
			System.out.println("On Click Continue Button");
			return new LeadEdit(driver, propObject);
		}
}


