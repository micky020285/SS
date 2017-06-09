
package com.macfee.sampletest;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.macfee.pages.leads.LeadEdit;
import com.macfee.pages.leads.Leads;
import com.macfee.pages.leads.NewLead;
import com.macfee.pages.SalesHomePage;
import com.macfee.pages.SalesLoginPage;
import com.mcafee.framework.BaseClass;
import com.mcafee.framework.ConfigData;
import com.mcafee.framework.DataProviderClass;

public class trial extends BaseClass
{
	private static SalesLoginPage salesLoginPage;
	private static SalesHomePage salesHomePage;
	private static Leads LeadTab;
	private static NewLead leadRecordtype;
	private static LeadEdit leadEdit;
	private static DataProviderClass dataproviders;
	static int i;
	
	@Override
	@BeforeClass
	public void setup()
	{
		super.setup();
		i=1;
		System.out.println("Setup done");
		salesLoginPage=commonMethods.launchSFApplication();
		salesHomePage=salesLoginPage.doLogIn(ConfigData.SFUSERNAME, ConfigData.SFPASSWORD);
		Assert.assertTrue(salesHomePage.isHomePageLaunched(), "Sales home page launched successfully");
		System.out.println("Sales Lead Creation in Sales Application");
		salesHomePage.globalSearch(ConfigData.TESTUSERNAME);
		salesHomePage.selectUser();
		salesHomePage.onClickUserActionMenu();
		salesHomePage.editUserRoleProfile(ConfigData.TESTUSERROLES, ConfigData.TESTLDRUSERPROFILE);
		//sfTestUserRole=EMEA Geo Rep SEUR
		//PCTUserProfile=Custom: LDR
		salesHomePage.onClickLoginBtn();
	}
	
	@Test(dataProvider="LeadCreatorUsingRecordTypeSalesLead", dataProviderClass=DataProviderClass.class)
	public void test(String...testData) throws Exception
	{
		LeadTab = salesHomePage.onClickLeadTab();
		leadRecordtype = LeadTab.onClickNew();
		leadRecordtype.selectLeadRecordGroup(testData[0]);
		leadEdit = leadRecordtype.onClickContinueBtn();
		leadEdit.selectLeadCountryType(testData[1]);
		leadEdit.putLeadFirstName(testData[2]);
		leadEdit.putLeadLastName();
		leadEdit.putLeadCity(testData[3]);
		leadEdit.putLeadEmail();
		leadEdit.putLeadBusinessPhone(testData[4]);
		/*leadEdit.selectLeadProductInterestsUnselected();
		Thread.sleep(2000);
		leadEdit.getLeadProductInterestsRightArrowBtnField();
		Thread.sleep(2000);*/
		leadEdit.putLeadContactTextField(testData[5]);
		leadEdit.putLeadAccountTextField(testData[6]);
		leadEdit.putLeadCloseDateTextField();
		leadEdit.putLeadCompanyTextField(testData[7]);
		driver.findElement(By.xpath("//input[contains(@id,'DVq8I')]")).sendKeys("15000");
		
		leadEdit.SelectLeadSaveBtnField();
		String leadName = LeadTab.verifyLeadCreated();
		Assert.assertNotNull(leadName, "Sales Lead has been created in sales application");
		dataproviders.writeDataToExcel("./resources/TestData.xlsx", "LeadCreationBySalesLead", leadName, i ,testData.length);
		
		String mwindowID = driver.getWindowHandle();
		System.out.println(mwindowID);
		
		//clicking on add product
		WebElement element1 = driver.findElement(By.xpath("//table/tbody/tr/td[2]/div[@id='00No000000DVq8a_ileinner']"));
		Actions act = new Actions(driver);
		act.doubleClick(element1).perform();
		Thread.sleep(5000);
		//Selecting product Msl
		WebElement ele=driver.findElement(By.cssSelector("select[title='Product Interests - Available']"));
		Select multiselectlistbox = new Select(ele);
		List<WebElement> elementCount = multiselectlistbox.getOptions();
		int iSize = elementCount.size();
		for (int i = 0; i <=1; i++) 
		{
			multiselectlistbox.selectByVisibleText(elementCount.get(i).getText());
			System.out.println("Product Unselected Multi Select Listbox  is " + i);
		}
		Thread.sleep(2000);
		//clicking right arrow
	    WebElement ele1=driver.findElement(By.xpath("//a[contains(@href,'handleMSPSelect')]/img"));
	   
	    Capabilities cp = ((RemoteWebDriver) driver).getCapabilities();
        if (cp.getBrowserName().equals("chrome")) {
            try {
                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].scrollIntoView(true);", ele1);
            } catch (Exception e) {

            }
        }

        ele1.click();
        Thread.sleep(2000);
        //clicking ok btn
        driver.findElement(By.xpath("//*[@id='InlineEditDialog_buttons']/input[@value='OK']")).click();
        //clicking save btn
        driver.findElement(By.name("inlineEditSave")).click();
        Thread.sleep(10000);
       //clicking on convert
        driver.findElement(By.xpath("//table/tbody/tr/td[@id='topButtonRow']/input[contains(@value,'Convert')]")).click();
       /* clicking on convert
        WebElement element2 = driver.findElement(By.xpath(".//*[@id='lea13_ilecell']"));
		Actions act1 = new Actions(driver);
		act1.doubleClick(element2).perform();
		Thread.sleep(5000);
		WebElement DD=driver.findElement(By.id("lea13"));
		Select dropdown= new Select(DD); 
		dropdown.selectByVisibleText("Converted");
		driver.findElement(By.xpath("//*[@id='InlineEditDialog_buttons']/input[@value='OK']")).click();
		driver.findElement(By.name("inlineEditSave")).click();
		System.out.println("Lead is converted ");
		*/
		
        //driver.findElement(By.xpath("//td[@id='topButtonRow']/input[7]")).click();
        //WebElement element2=driver.findElement(By.xpath("//td[@id='topButtonRow']/input[7]"));
        /*WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(element2));
        element2.click();*/
		}   
		
	
	
	@AfterMethod
	public void colno()
    {
		i++;
	}
}
