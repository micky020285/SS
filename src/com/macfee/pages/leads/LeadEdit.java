package com.macfee.pages.leads;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.mcafee.framework.AutomationHelper;
import com.mcafee.framework.PropertiesReader;

public class LeadEdit 
{
//Lead edit page
	private WebDriver driver;
	private PropertiesReader propObject;
	
	public LeadEdit (WebDriver driver, PropertiesReader propObject) 
	{
		this.driver = driver;
		this.propObject=propObject;
	}
	public WebElement getLeadCountryTypeDDLField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfLeadCountryTypeDDLField")), 10);
	}
	public void selectLeadCountryType(String Country)
	{
		Select dropdown= new Select(getLeadCountryTypeDDLField()); 
		dropdown.selectByVisibleText(Country); 
		System.out.println("Lead CountryType is " + Country);
	}
	public WebElement getLeadRoutingTypeDDLField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfLeadRoutingTypeDDLField")), 10);
	}
	public void selectLeadRoutingType(String Routingtype)
	{
		Select dropdown= new Select(getLeadRoutingTypeDDLField()); 
		dropdown.selectByVisibleText(Routingtype); 
		System.out.println("Lead RoutingType is " + Routingtype);
	}
	
	/*public WebElement getLeadTitleDDLField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfLeadTitleDDLField")), 10);
	}
	
	public void selectLeadTitle(String LeadTitle)
	{
		Select dropdown= new Select(getLeadTitleDDLField()); 
		dropdown.selectByVisibleText(LeadTitle); 
		System.out.println("Lead Type is " + LeadTitle);
	}
	*/
	public WebElement getLeadFirstNameTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfLeadFirstNameTxtField")), 10);
	}
	public void putLeadFirstName(String FirstName)
	{
		getLeadFirstNameTxtField().sendKeys(FirstName);
		System.out.println("First Name is " + FirstName);
	}
	public WebElement getLeadLastNameTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfLeadLastNameTxtField")), 10);
	}
	public void putLeadLastName()
	{
		getLeadLastNameTxtField().clear();
		String lastname = currentTimeVariable();
		getLeadLastNameTxtField().sendKeys(lastname);
		System.out.println("Last Name is " + lastname);
	}
	public String currentTimeVariable()
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(dtf.format(ldt));
		return dtf.format(ldt);
	}
	public WebElement getLeadCityTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfLeadCityTxtField")), 10);
	}
	public void putLeadCity(String City)
	{
		getLeadCityTxtField().sendKeys(City);
		System.out.println("City is " + City);
	}
	public WebElement getLeadEmailTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfLeadEmailTxtField")), 10);
	}	
	public void putLeadEmail()
	{
		getLeadEmailTxtField().clear();
		String firstName = getLeadFirstNameTxtField().getAttribute("value").toLowerCase();
		System.out.println("Lead First name is " + firstName);
		String lastName = getLeadLastNameTxtField().getAttribute("value");
		System.out.println("Lead Last name is " + lastName);
		String businessemail = firstName+""+lastName+"@mcafee.com";	
		getLeadEmailTxtField().sendKeys(businessemail);
		System.out.println("Lead E-Mail is " + businessemail);
	}
	public WebElement getLeadBusinessPhoneTextField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfLeadBusinessPhoneTextField")), 10);
	}
	public void putLeadBusinessPhone(String BusinessPhone)
	{
		getLeadBusinessPhoneTextField().sendKeys(BusinessPhone);
		System.out.println("BusinessPhone is " + BusinessPhone);
	}
	public WebElement getLeadProductInterestsUnselectedMSLField()
	{
		return AutomationHelper.findElement(driver, By.cssSelector(propObject.getData("sfLeadProductInterestsUnselectedMSLField")), 10);
	}
	public void selectLeadProductInterestsUnselected()
	{		
		Select multiselectlistbox = new Select(getLeadProductInterestsUnselectedMSLField());
		List<WebElement> elementCount = multiselectlistbox.getOptions();
		//int iSize = elementCount.size();
		for (int i = 0; i <=1; i++) 
		{
			multiselectlistbox.selectByVisibleText(elementCount.get(i).getText());
			System.out.println("Product Unselected Multi Select Listbox  is " + i);
		}
	}
	public WebElement getLeadProductInterestsRightArrowBtnField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfLeadProductInterestsRightArrowBtnField")), 10);
	}
	public void SelectLeadProductInterestsRightArrowBtnField()
	{
		getLeadProductInterestsRightArrowBtnField().click();
		/*WebElement ele=getLeadProductInterestsRightArrowBtnField();
		Capabilities cp = ((RemoteWebDriver) driver).getCapabilities();
        if (cp.getBrowserName().equals("chrome")) {
            try {
                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].scrollIntoView(true);",ele );
            } catch (Exception e) {

            }
        }
        ele.click();*/
	}
	public WebElement getLeadProductInterestsLeftArrowBtnField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfLeadProductInterestsLeftArrowBtnField")), 10);
	}
	public void SelectLeadProductInterestsLeftArrowBtnField()
	{
		getLeadProductInterestsLeftArrowBtnField().click();
	}	
	public WebElement getLeadContactTextField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfLeadContactTextField")), 10);
	}
	public void putLeadContactTextField(String Contact)
	{
		getLeadContactTextField().sendKeys(Contact);
		System.out.println("Contact is " + Contact);
	}
	public WebElement getLeadAccountTextField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfLeadAccountTextField")), 10);
	}
	public void putLeadAccountTextField(String Account)
	{
		getLeadAccountTextField().sendKeys(Account);
		System.out.println("Account is " + Account);
	}
	public WebElement getLeadCloseDateTxtField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfLeadCloseDateTxtField")), 10);
	}
	public void putLeadCloseDateTextField()
	{
		String leadCloseDateDate;
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        leadCloseDateDate = new SimpleDateFormat("MM/dd/yyyy").format(calendar.getTime());
        getLeadCloseDateTxtField().sendKeys(leadCloseDateDate);
		System.out.println("Lead Close Date is " + leadCloseDateDate);
				
	}
	
	public WebElement getLeadStatusDDLField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfLeadStatusDDLField")), 10);
	}
	public void selectLeadStatus(String LeadStatus)
	{
		Select dropdown= new Select(getLeadStatusDDLField()); 
		dropdown.selectByVisibleText(LeadStatus); 
		System.out.println("Lead Status is " + LeadStatus);
	}
	
	public WebElement getLeadStatusReasonDDLField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfLeadStatusReasonDDLField")), 10);
	}
	public void selectLeadStatusReason(String LeadStatusReason)
	{
		Select dropdown= new Select(getLeadStatusReasonDDLField()); 
		dropdown.selectByVisibleText(LeadStatusReason); 
		System.out.println("Lead Status Reason is " + LeadStatusReason);
	}
	
	public WebElement getLeadCompanyInfoTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfLeadCompanyInfoTxtField")), 10);
	}
	public void putLeadCompanyTextField(String Company)
	{
		getLeadCompanyInfoTxtField().sendKeys(Company);
		System.out.println("Company is " + Company);
	}
	
	public WebElement getLeadStreetTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfLeadStreetTxtField")), 10);
	}
	public void putLeadStreetTextField(String Street)
	{
		getLeadStreetTxtField().sendKeys(Street);
		System.out.println("Street is " + Street);
	}
		
	public WebElement getLeadZipTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfLeadZipTxtField")), 10);
	}
	public void putLeadZipTextField(String Zip)
	{
		getLeadZipTxtField().sendKeys(Zip);
		System.out.println("Zipcode is " + Zip);
	}
		
	public WebElement getLeadDealAmountTxtField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfLeadDealAmountTxtField")), 10);
	}
	public void putLeadDealAmount(String Amount)
	{
		getLeadDealAmountTxtField().sendKeys(Amount);
		System.out.println("Deal Amount is " + Amount);
	}
	
	public WebElement getLeadSaveBtnField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfLeadSaveBtnField")), 10);
	}
	public void SelectLeadSaveBtnField()
	{
		getLeadSaveBtnField().click();
		System.out.println("Lead Save Button Clicked");
		//return new LeadConvert(driver, propObject);
	}
	
	public WebElement getLeadNameField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfLeadCreatedName")), 10);
	}	
	public  String verifyLeadCreated()
	{	
		String leadName = getLeadNameField().getText();
		System.out.println(leadName + " Lead created in SF Application");
		return leadName;
	}
	
	public WebElement getLeadStateDDLField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfLeadStateDDLField")), 10);
	}
	public void selectLeadState(String LeadState)
	{
		Select dropdown= new Select(getLeadStateDDLField()); 
		dropdown.selectByVisibleText(LeadState); 
		System.out.println("Lead State is " + LeadState);
	}
	
	
	////////////////////////////////////////////////////////
	
	
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
	public void SelectLeadProductConvertBtn() 
	{
		getLeadProductConvertBtn().click();
		System.out.println("Convert Button Clicked");
		
	}
	///////////////////////////////////////////////////////////////////
	
	public WebElement getLeadAccNameDDLField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfLeadAccNameDDLField")), 10);
	}
	public void selectLeadAccName()
	{
		Select dropdown= new Select(getLeadAccNameDDLField()); 
		dropdown.selectByIndex(1); 
	}
	public WebElement getLeadOptyNameTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfLeadOptyNameTxtField")), 10);
	}
	public void putLeadOptyNameTextField(String OptyName)
	{
		getLeadOptyNameTxtField().clear();
		getLeadOptyNameTxtField().sendKeys(OptyName);
		System.out.println("OptyName is " + OptyName);
	}
	public WebElement getLeadStatusDDDLField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfLeadStatusDDDLField")), 10);
	}
	public void selectLeadStatus()
	{
		Select dropdown= new Select(getLeadStatusDDDLField()); 
		dropdown.selectByIndex(1); 
	}
	public WebElement getLeadSubjectTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfLeadSubjectTxtField")), 10);
	}
	public void putLeadSubjectTextField(String Subject)
	{
		getLeadSubjectTxtField().sendKeys(Subject);
		System.out.println("Subject is " + Subject);
	}
	public WebElement getOptyName()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfLeadOptyName")), 10);
	}	
	public  String verifyOptyCreated()
	{	
		String OptyName = getOptyName().getText();
		System.out.println(OptyName + " Opty created in SF Application");
		return OptyName;
	}
	public Leads driverreturn()
	{
	return new Leads(driver, propObject);
	}
}
