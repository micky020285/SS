package com.macfee.pages.contacts;

import org.apache.commons.lang3.RandomStringUtils;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.mcafee.framework.AutomationHelper;
import com.mcafee.framework.PropertiesReader;

/**
*
* @author Balamurugan
*
*/

public class ContactsEdit 
{
	private WebDriver driver;
	private PropertiesReader propObject;
	//private String sfAccountEditExpTitle ="Accounts: Home ~ Salesforce - Unlimited Edition";
	
	ContactsEdit(WebDriver driver, PropertiesReader propObject)
	{
		this.driver = driver;
		this.propObject=propObject;
	}
	
	public void verifyIfContactsEditPage() 
	{
		Assert.assertEquals(getSaveBtnField().isDisplayed(), true, "Contacts Edit");
	}
	
	public WebElement getTitleDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfTitleDDField")), 10);
	}
	
	public WebElement getFirstNameTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfFirstNameTxtField")), 10);
	}
	
	public WebElement getLastNameTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfLastNameTxtField")), 10);
	}
	
	public WebElement getJobTitleTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfJobTitleTxtField")), 10);
	}
	
	public WebElement getJobLevelDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfJobLevelDDField")), 10);
	}
	
	public WebElement getAccountNameTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfAccountNameTxtField")), 10);
	}
	
	public WebElement getBusinessPhoneTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfBusinessPhoneTxtField")), 10);
	}
	
	public WebElement getJobFunctionDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfJobFunctionDDField")), 10);
	}
	
	public WebElement getBusinessPhoneExtensionTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfBusinessPhoneExtensionTxtField")), 10);
	}
	
	public WebElement getDesignationUnselectedMSLField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfDesignationUnselectedMSLField")), 10);
	}
	
	public WebElement getDesignationsFWDBtnField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfDesignationsFWDBtnField")), 10);
	}
	
	public WebElement getDesignationsBWDBtnField() 
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfDesignationsBWDBtnField")), 10);
	}
	
	public WebElement getDesignationsSelectedMSLField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfDesignationsSelectedMSLField")), 10);
	}
	
	public WebElement getMobileTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfMobileTxtField")), 10);
	}
	
	public WebElement getBusinessFaxTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfBusinessFaxTxtField")), 10);
	}
	
	public WebElement getLinkedInProfileTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfLinkedInProfileTxtField")), 10);
	}
	
	public WebElement getBusinessEmailTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfBusinessEmailTxtField")), 10);
	}
	
	public WebElement getContactDescriptionTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfContactDescriptionTxtField")), 10);
	}
	
	public WebElement getMailingCountryDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfMailingCountryDDField")), 10);
	}
	
	public WebElement getOtherCountryDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfOtherCountryDDField")), 10);
	}
	
	public WebElement getMailingStreetTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfMailingStreetTxtField")), 10);
	}
	
	public WebElement getOtherStreetTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfOtherStreetTxtField")), 10);
	}
	
	public WebElement getMailingCityTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfMailingCityTxtField")), 10);
	}
	
	public WebElement getOtherCityTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfOtherCityTxtField")), 10);
	}
	
	public WebElement getMailingStateProvinceDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfMailingStateProvinceDDField")), 10);
	}
	
	public WebElement getOtherStateProvinceDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfOtherStateProvinceDDField")), 10);
	}
	
	public WebElement getMailingZipPostalCodeTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfMailingZipPostalCodeTxtField")), 10);
	}
	
	public WebElement getOtherZipPostalCodeTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfOtherZipPostalCodeTxtField")), 10);
	}
	
	public WebElement getDoNotCallChkBoxField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfDoNotCallChkBoxField")), 10);
	}
	
	public WebElement getLatticeScoreTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfLatticeScoreTxtField")), 10);
	}
	
	public WebElement getDoNotMailChkBoxField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfDoNotMailChkBoxField")), 10);
	}
	
	public WebElement getEloquaPhoneTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfEloquaPhoneTxtField")), 10);
	}
	
	public WebElement getWithholdMarketingChkBoxField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfWithholdMarketingChkBoxField")), 10);
	}
	
	public WebElement getMarketingPersonaUnselectedMSLField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfMarketingPersonaUnselectedMSLField")), 10);
	}
	
	public WebElement getMarketingPersonaFWDBtnField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfMarketingPersonaFWDBtnField")), 10);
	}
	
	public WebElement getMarketingPersonaBWDBtnField() 
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfMarketingPersonaBWDtnField")), 10);
	}
	
	public WebElement getMarketingPersonaSelectedMSLField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfMarketingPersonaSelectedMSLField")), 10);
	}
	
	public WebElement getEmailOptOutChkBoxField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfEmailOptOutChkBoxField")), 10);
	}
	
	public WebElement getContactStatusDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfContactStatusDDField")), 10);
	}
	
	public WebElement getPreferredLanguageDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfPreferredLanguageDDField")), 10);
	}
	
	public WebElement getStatusReasonDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfStatusReasonDDField")), 10);
	}
	
	public WebElement getLegacyIdTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfLegacyIdTxtField")), 10);
	}
	
	public WebElement getContactSAPIDTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfContactSAPIDTxtField")), 10);
	}
	
	public WebElement getLegacyCreatedTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfLegacyCreatedTxtField")), 10);
	}
	
	public WebElement getLegacyCreatedDateLinkField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfLegacyCreatedDateLinkField")), 10);
	}
	
	public WebElement getMDMContactIDTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfMDMContactIDTxtField")), 10);
	}
	
	public WebElement getEloquaContactIDTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfEloquaContactIdTxtField")), 10);
	}
	
	public WebElement getRelatedUserDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfRelatedUserDDField")), 10);
	}
	
	public WebElement getRelatedUserTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfRelatedUserTxtField")), 10);
	}
	
	public WebElement getSourceSystemTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfSourceSystemTxtField")), 10);
	}
	
	public WebElement getProspectContactIdentifierTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfProspectContactIdentifierTxtField")), 10);
	}
	
	public WebElement getContactsEditAccountNameTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfContactsEditAccountNameTxtField")), 10);
	}
	
	public WebElement getPartnerContactStatusDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfPartnerContactStatusDDField")), 10);
	}
	
	public WebElement getPartnerRoleDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfPartnerRoleDDField")), 10);
	}
	
	public WebElement getPartnerPersonaUnselectedMSLField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfPartnerPersonaUnselectedMSLField")), 10);
	}
	
	public WebElement getPartnerPersonaFWDBtnField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfPartnerPersonaFWDBtnField")), 10);
	}
	
	public WebElement getPartnerPersonaBWDBtnField() 
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfPartnerPersonaBWDBtnField")), 10);
	}
	
	public WebElement getPartnerPersonaSelectedMSLField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfPartnerPersonaSelectedMSLField")), 10);
	}
	
	public WebElement getContactCurrencyDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfContactCurrencyDDField")), 10);
	}
	
	public WebElement getPartnerContactLevelDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfPartnerContactLevelDDField")), 10);
	}
	
	public WebElement getPreferredContactMethodDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfPreferredContactMethodDDField")), 10);
	}
	
	public WebElement getPartnerPortalAccessRequestChkBoxField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfPartnerPortalAccessRequestChkBoxField")), 10);
	}
	
	public WebElement getPartnerPortalRequestStatusDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfPartnerPortalRequestStatusDDField")), 10);
	}
	
	public WebElement get360DashboardAccessRequestChkBoxField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sf360DashboardAccessRequestChkBoxField")), 10);
	}
	
	public WebElement get360DashboardRequestStatusDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sf360DashboardRequestStatusDDField")), 10);
	}
	
	public WebElement getMcAfeeSolutionsCenterAccessRequestChkBoxField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfMcAfeeSolutionsCenterAccessRequestChkBoxField")), 10);
	}
	
	public WebElement getMcAfeeSolutionsCenterRequestStatusDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfMcAfeeSolutionsCenterRequestStatusDDField")), 10);
	}
	
	public WebElement getMDFAccessRequestChkBoxField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfMDFAccessRequestChkBoxField")), 10);
	}
	
	public WebElement getMDFRequestStatusDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfMDFRequestStatusDDField")), 10);
	}
	
	public WebElement getPartnerLearningCenterAccessRequestChkBoxField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfPartnerLearningCenterAccessRequestChkBoxField")), 10);
	}
	
	public WebElement getPartnerLearningCenterRequestStatusDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfPartnerLearningCenterRequestStatusDDField")), 10);
	}
	
	public WebElement getRebatesAccessRequestChkBoxField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfRebatesAccessRequestChkBoxField")), 10);
	}
	
	public WebElement getRebatesRequestStatusDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfRebatesRequestStatusDDField")), 10);
	}
	
	public WebElement getSalesforcecomAccessRequestChkBoxField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfSalesforcecomAccessRequestChkBoxField")), 10);
	}
	
	public WebElement getSalesforcecomRequestStatusDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfSalesforcecomRequestStatusDDField")), 10);
	}
	
	public WebElement getServicePortalAccessRequestChkBoxField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfServicePortalAccessRequestChkBoxField")), 10);
	}
	
	public WebElement getServicePortalRequestStatusDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfServicePortalRequestStatusDDField")), 10);
	}
	
	public WebElement getAbilitytoExportPermissionRequestChkBoxField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfAbilitytoExportPermissionRequestChkBoxField")), 10);
	}
	
	public WebElement getAbilitytoExportRequestStatusDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfAbilitytoExportRequestStatusDDField")), 10);
	}
	
	public WebElement getMakePartnerAdminPermissionRequestChkBoxField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfMakePartnerAdminPermissionRequestChkBoxField")), 10);
	}
	
	public WebElement getMakePartnerAdminRequestStatusDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfMakePartnerAdminRequestStatusDDField")), 10);
	}
	
	public WebElement getiAssetMSRoyaltyToolAdminRequestChkBoxField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfiAssetMSRoyaltyToolAdminRequestChkBoxField")), 10);
	}
	
	public WebElement getiAssetMSPRoyaltyToolAdminStatusDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfiAssetMSPRoyaltyToolAdminStatusDDField")), 10);
	}
	
	public WebElement getiAssetMSPRoyaltyToolReadOnlyRequestChkBoxField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfiAssetMSPRoyaltyToolReadOnlyRequestChkBoxField")), 10);
	}
	
	public WebElement getiAssetMSPRoyaltyToolReadOnlyStatusDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfiAssetMSPRoyaltyToolReadOnlyStatusDDField")), 10);
	}
	
	public WebElement getTCAcceptanceDateTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfTCAcceptanceDateTxtField")), 10);
	}
	
	public WebElement getSaveBtnField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfSaveBtnField")), 10);
	}
	
	public WebElement getCancelBtnField() 
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfCancelBtnField")), 10);
	}
	
	//Creating a date/time variable for appending while creating a unique items
	public String currentTimeVariable()
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(dtf.format(ldt));
		return dtf.format(ldt);
	}
	
	public void selectTitle(String title)
	{
		Select dropdown= new Select(getTitleDDField()); 
		dropdown.selectByVisibleText(title); 
		System.out.println("Title is " + title);
	}
	
	public void putFirstName(String firstName)
	{
		getFirstNameTxtField().clear();
		getFirstNameTxtField().sendKeys(firstName);
		System.out.println("First Name is " + firstName);
	}
	
	public void putJobTitle(String jobTitle)
	{
		getJobTitleTxtField().sendKeys(jobTitle);
		System.out.println("Job Title is " + jobTitle);
	}
	
	public void putLastName()
	{
		getLastNameTxtField().clear();
		String lastname = currentTimeVariable();
		getLastNameTxtField().sendKeys(lastname);
		System.out.println("Last Name is " + lastname);
	}
	
	public void selectJobLevel(String jobLevel)
	{
		Select dropdown= new Select(getJobLevelDDField()); 
		dropdown.selectByVisibleText(jobLevel); 
		System.out.println("Job Level is " + jobLevel);
	}
	
	public void putEndCustomerContactsEditAccountName(String accountName)
	{
		getAccountNameTxtField().sendKeys(accountName);
		System.out.println("End Customer Contact Account Name is " + accountName);
	}
	
	public void putBusinessPhone(String businessPhone)
	{
		getBusinessPhoneTxtField().clear();
		getBusinessPhoneTxtField().sendKeys(businessPhone);
		System.out.println("Business Phone is " + businessPhone);
	}
	
	public void selectJobFunction(String jobFunction)
	{
		Select dropdown= new Select(getJobFunctionDDField()); 
		dropdown.selectByVisibleText(jobFunction); 
		System.out.println("Job Function is " + jobFunction);
	}
	
	public void putBusinessPhoneExtension(String businessPhoneExtension)
	{
		getBusinessPhoneExtensionTxtField().sendKeys(businessPhoneExtension);
		System.out.println("Business Phone Extension is " + businessPhoneExtension);
	}
	
	public void putBusinessEmail()
	{
		getBusinessEmailTxtField().clear();
		String firstName = getFirstNameTxtField().getAttribute("value").toLowerCase();
		System.out.println("First name is " + firstName);
		String lastName = getLastNameTxtField().getAttribute("value");
		System.out.println("Last name is " + lastName);
		String businessemail = firstName+"."+lastName+"@mcafee.com";
		getBusinessEmailTxtField().sendKeys(businessemail);
		System.out.println("Business E-Mail is " + businessemail);
	}
	
	public void selectDesignationUnselected()
	{		
		Select multiselectlistbox = new Select(getDesignationUnselectedMSLField());
		List<WebElement> elementCount = multiselectlistbox.getOptions();
		int iSize = elementCount.size();
		for (int i = 0; i < iSize; i++) 
		{
			multiselectlistbox.selectByVisibleText(elementCount.get(i).getText());
			System.out.println("Designation Unselected Multi Select Listbox Value is " + i);
		}
	}
	
	public void selectDesignationsSelected(String designationsSelected)
	{
		Select dropdown= new Select(getDesignationsSelectedMSLField()); 
		dropdown.selectByVisibleText(designationsSelected); 
		System.out.println("Designation Selected Multi Select Listbox Value is " + designationsSelected);
	}
	
	public void SelectDesignationsFWDBtn() 
	{
		getDesignationsFWDBtnField().click();
	}
	
	public void SelectDesignationsBWDBtn() 
	{
		getDesignationsBWDBtnField().click();
	}
	
	public void putMobile(String mobile)
	{
		getMobileTxtField().sendKeys(mobile);
		System.out.println("Mobile number is " + mobile);
	}
	
	public void putBusinessFax(String businessFax)
	{
		getBusinessFaxTxtField().sendKeys(businessFax);
		System.out.println("Business Fax is " + businessFax);
	}
	
	public void putLinkedInProfile(String linkedInProfile)
	{
		getLinkedInProfileTxtField().sendKeys(linkedInProfile);
		System.out.println("LinkedIn Profile is " + linkedInProfile);
	}
	
	public void putPartnerBusinessEmail(String businessEmail)
	{
		getBusinessEmailTxtField().clear();
		getBusinessEmailTxtField().sendKeys(businessEmail);
		System.out.println("Business Email is " + businessEmail);
	}
	
	public void putContactDescription(String contactDescription)
	{
		getContactDescriptionTxtField().sendKeys(contactDescription);
		System.out.println("Contact Description is " + contactDescription);
	}

	public void selectMailingCountry(String mailingCountry)
	{
		Select dropdown= new Select(getMailingCountryDDField()); 
		dropdown.selectByVisibleText(mailingCountry); 
		System.out.println("Mailing Country is " + mailingCountry);
	}
	
	public void selectOtherCountry(String otherCountry)
	{
		Select dropdown= new Select(getOtherCountryDDField()); 
		dropdown.selectByVisibleText(otherCountry); 
		System.out.println("Other Country is " + otherCountry);
	}
	
	public void putMailingStreet(String mailingStreet)
	{
		getMailingStreetTxtField().sendKeys(mailingStreet);
		System.out.println("Mailing Street is " + mailingStreet);
	}
	
	public void putOtherStreet(String otherStreet)
	{
		getOtherStreetTxtField().sendKeys(otherStreet);
		System.out.println("Other Street is " + otherStreet);
	}

	public void putMailingCity(String mailingCity)
	{
		getMailingCityTxtField().sendKeys(mailingCity);
		System.out.println("Mailing City is " + mailingCity);
	}
	
	public void putOtherCity(String otherCity)
	{
		getOtherCityTxtField().sendKeys(otherCity);
		System.out.println("Other City is " + otherCity);
	}
	
	public void selectMailingStateProvince(String mailingStateProvince)
	{
		Select dropdown= new Select(getMailingStateProvinceDDField()); 
		dropdown.selectByVisibleText(mailingStateProvince); 
		System.out.println("MailingState  Province is " + mailingStateProvince);
	}
	
	public void selectOtherStateProvince(String otherStateProvince)
	{
		Select dropdown= new Select(getOtherStateProvinceDDField()); 
		dropdown.selectByVisibleText(otherStateProvince); 
		System.out.println("Other State Province is " + otherStateProvince);
	}

	public void putMailingZipPostalCode(String mailingZipPostalCode)
	{
		getMailingZipPostalCodeTxtField().sendKeys(mailingZipPostalCode);
		System.out.println("Mailing Zip/Postal Code is " + mailingZipPostalCode);
	}
	
	public void putOtherZipPostalCode(String otherZipPostalCode)
	{
		getOtherZipPostalCodeTxtField().sendKeys(otherZipPostalCode);
		System.out.println("Other Zip/Postal Code is " + otherZipPostalCode);
	}

	public void SelectDoNotCallChkBox(String doNotCall) 
	{		
        if (Boolean.valueOf(doNotCall) && !getDoNotCallChkBoxField().isSelected())
        {
        	getDoNotCallChkBoxField().click();
        }
	}
	
	public void putLatticeScore()
	{
		String latticeScore = RandomStringUtils.randomNumeric(3);
		getLatticeScoreTxtField().sendKeys(latticeScore);
		System.out.println("Lattice Score is " + latticeScore);
	}
	
	public void SelectDoNotMailChkBox(String doNotMail) 
	{
        if (Boolean.valueOf(doNotMail) && !getDoNotMailChkBoxField().isSelected())
        {
        	getDoNotMailChkBoxField().click();
        }
	}
	
	public void putEloquaPhone(String eloquaPhone)
	{
		getEloquaPhoneTxtField().sendKeys(eloquaPhone);
		System.out.println("Eloqua Phone is " + eloquaPhone);
	}
	
	public void SelectWithholdMarketingChkBox(String withHoldMarketing) 
	{		
		if (Boolean.valueOf(withHoldMarketing) && !getWithholdMarketingChkBoxField().isSelected())
		{
			getWithholdMarketingChkBoxField().click();
		}
	}
	
	public void selectMarketingPersonaUnselectedMSL()
	{
		Select multiselectlistbox = new Select(getMarketingPersonaUnselectedMSLField());
		List<WebElement> elementCount = multiselectlistbox.getOptions();
		int iSize = elementCount.size();
		for (int i = 0; i < iSize; i++) 
		{
			multiselectlistbox.selectByVisibleText(elementCount.get(i).getText());
			System.out.println("Marketing Persona Unselected Multi Select Listbox Value is " + i);
		}
	}
	
	public void SelectMarketingPersonaFWDBtn() 
	{
		getMarketingPersonaFWDBtnField().click();
	}
	
	public void SelectMarketingPersonaBWDBtn() 
	{
		getMarketingPersonaBWDBtnField().click();
	}
	
	public void selectMarketingPersonaSelected(String marketingPersonaSelected)
	{
		Select dropdown= new Select(getMarketingPersonaSelectedMSLField()); 
		dropdown.selectByVisibleText(marketingPersonaSelected); 
		System.out.println("Marketing Persona Selected Multi Select Listbox Value is " + marketingPersonaSelected);
	}
	
	public void SelectEmailOptOutChkBox(String emailOptOut) 
	{
		if (Boolean.valueOf(emailOptOut) && !getEmailOptOutChkBoxField().isSelected())
		{
			getEmailOptOutChkBoxField().click();
		}
	}
	
	public void selectContactStatus(String contactStatus)
	{
		Select dropdown= new Select(getContactStatusDDField()); 
		dropdown.selectByVisibleText(contactStatus); 
		System.out.println("Contact Status is " + contactStatus);
	}
	
	public void selectPreferredLanguage(String preferredLanguage)
	{
		Select dropdown= new Select(getPreferredLanguageDDField()); 
		dropdown.selectByVisibleText(preferredLanguage); 
		System.out.println("Preferred Language is " + preferredLanguage);
	}
	
	public void selectStatusReason(String statusReason)
	{
		Select dropdown= new Select(getStatusReasonDDField()); 
		dropdown.selectByVisibleText(statusReason); 
		System.out.println("Status Reason is " + statusReason);
	}
	
	public void putLegacyId()
	{
		String legacyId = RandomStringUtils.randomAlphanumeric(15);
		getLegacyIdTxtField().sendKeys(legacyId);
		System.out.println("Legacy ID is " + legacyId);
	}
	
	public void putContactSAPID(String contactSAPID)
	{
		getContactSAPIDTxtField().sendKeys(contactSAPID);
		System.out.println("Contact SAP ID is " + contactSAPID);
	}
	
	public void putLegacyCreated()
	{
		/*
		String legacyCreated = getLegacyCreatedTxtField().getText();
		System.out.println("Legacy Created On " + legacyCreated);
		*/
		String legacyCreatedDate;
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        legacyCreatedDate = new SimpleDateFormat("MM/dd/yyyy hh:mm a").format(calendar.getTime());
        getLegacyCreatedTxtField().sendKeys(legacyCreatedDate);
        System.out.println("Legacy Created On " + legacyCreatedDate);
	}
	
	public void putMDMContactID(String MDMContactID)
	{
		getMDMContactIDTxtField().sendKeys(MDMContactID);
		System.out.println("MDM Contact ID is " + MDMContactID);
	}
	
	public void putEloquaContactID(String eloquaContactID)
	{
		getEloquaContactIDTxtField().sendKeys(eloquaContactID);
		System.out.println("Eloqua Contact ID is " + eloquaContactID);
	}
	
	public void selectRelatedUser(String relatedUser)
	{
		Select dropdown= new Select(getRelatedUserDDField()); 
		dropdown.selectByVisibleText(relatedUser); 
		System.out.println("Related User is " + relatedUser);
	}
	
	public void putRelatedUser(String relatedUser)
	{
		getRelatedUserTxtField().sendKeys(relatedUser);
		System.out.println("Related User is " + relatedUser);
	}
	
	public void putSourceSystem(String sourceSystem)
	{
		getSourceSystemTxtField().sendKeys(sourceSystem);
		System.out.println("Source System is " + sourceSystem);
	}
	
	public void putProspectContactIdentifier(String prospectContactIdentifier)
	{
		getProspectContactIdentifierTxtField().sendKeys(prospectContactIdentifier);
		System.out.println("Prospect Contact Identifier is " + prospectContactIdentifier);
	}
	
	public void putPartnerContactAccountName(String contactsEditAccountName)
	{
		getContactsEditAccountNameTxtField().sendKeys(contactsEditAccountName);
		System.out.println("Partner Contact Account Name is " + contactsEditAccountName);
	}
	
	public void selectPartnerContactStatus(String partnerContactStatus)
	{
		Select dropdown= new Select(getPartnerContactStatusDDField()); 
		dropdown.selectByVisibleText(partnerContactStatus); 
		System.out.println("Partner Contact Status is " + partnerContactStatus);
	}
	
	public void selectPartnerRole(String partnerRole)
	{
		Select dropdown= new Select(getPartnerRoleDDField()); 
		dropdown.selectByVisibleText(partnerRole); 
		System.out.println("Partner Role is " + partnerRole);
	}
	
	public void selectPartnerPersonaUnselectedMSL()
	{		
		Select multiselectlistbox = new Select(getPartnerPersonaUnselectedMSLField());
		List<WebElement> elementCount = multiselectlistbox.getOptions();
		int iSize = elementCount.size();
		for (int i = 0; i < iSize; i++) 
		{
			multiselectlistbox.selectByVisibleText(elementCount.get(i).getText());
			System.out.println("Partner Persona Unselected Multi Select Listbox Value is " + i);
		}
	}
	
	public void SelectPartnerPersonaFWDBtn() 
	{
		getPartnerPersonaFWDBtnField().click();
	}
	
	public void SelectPartnerPersonaBWDBtn() 
	{
		getPartnerPersonaBWDBtnField().click();
	}
	
	public void selectPartnerPersonaSelectedMSL(String partnerPersonaSelectedMSL)
	{
		Select dropdown= new Select(getPartnerPersonaSelectedMSLField()); 
		dropdown.selectByVisibleText(partnerPersonaSelectedMSL); 
		System.out.println("Partner Persona Selected Multi Select Listbox Value is " + partnerPersonaSelectedMSL);
	}
	
	public void selectContactCurrencyDD(String contactCurrency)
	{
		Select dropdown= new Select(getContactCurrencyDDField()); 
		dropdown.selectByVisibleText(contactCurrency); 
		System.out.println("Contact Currency Value is " + contactCurrency);
	}
	
	public void selectPartnerContactLevelDD(String partnerContact)
	{
		Select dropdown= new Select(getPartnerContactLevelDDField()); 
		dropdown.selectByVisibleText(partnerContact); 
		System.out.println("Partner Contact Level Value is " + partnerContact);
	}
	
	public void selectPreferredContactMethodDD(String preferredContactMethod)
	{
		Select dropdown= new Select(getPreferredContactMethodDDField()); 
		dropdown.selectByVisibleText(preferredContactMethod); 
		System.out.println("Preferred Contact Method Value is " + preferredContactMethod);
	}
	
	public void SelectPartnerPortalAccessRequestChkBox(String partnerPortalAccessRequest) 
	{
		if (Boolean.valueOf(partnerPortalAccessRequest) && !getPartnerPortalAccessRequestChkBoxField().isSelected())
		{
			getPartnerPortalAccessRequestChkBoxField().click();
		}
	}
	
	public void selectPartnerPortalRequestStatusDD(String partnerPortalRequestStatus)
	{
		Select dropdown= new Select(getPartnerPortalRequestStatusDDField()); 
		dropdown.selectByVisibleText(partnerPortalRequestStatus); 
		System.out.println("Partner Portal Request Status is " + partnerPortalRequestStatus);
	}
	
	public void Select360DashboardAccessRequestChkBoxField(String dashboardAccessRequest) 
	{
		if (Boolean.valueOf(dashboardAccessRequest) && !get360DashboardAccessRequestChkBoxField().isSelected())
		{
			get360DashboardAccessRequestChkBoxField().click();
		}
	}
	
	public void select360dashboardRequestStatusDD(String dashboardRequestStatus)
	{
		Select dropdown= new Select(getPartnerPortalRequestStatusDDField()); 
		dropdown.selectByVisibleText(dashboardRequestStatus); 
		System.out.println("360 Dashboard Request Status is " + dashboardRequestStatus);
	}
	
	public void SelectMcAfeeSolutionsCenterAccessRequestChkBox(String mcAfeeSolutionsCenterAccessRequest) 
	{
		if (Boolean.valueOf(mcAfeeSolutionsCenterAccessRequest) && !getMcAfeeSolutionsCenterAccessRequestChkBoxField().isSelected())
		{
			getMcAfeeSolutionsCenterAccessRequestChkBoxField().click();
		}
	}
	
	public void selectMcAfeeSolutionsCenterRequestStatusDD(String mcafeeSolutionsCenterRequestStatus)
	{
		Select dropdown= new Select(getMcAfeeSolutionsCenterRequestStatusDDField()); 
		dropdown.selectByVisibleText(mcafeeSolutionsCenterRequestStatus); 
		System.out.println("McAfee Solutions Center Request Status is " + mcafeeSolutionsCenterRequestStatus);
	}
	
	public void SelectMDFAccessRequestChkBox(String mdfAccessRequest) 
	{
		if (Boolean.valueOf(mdfAccessRequest) && !getMDFAccessRequestChkBoxField().isSelected())
		{
			getMDFAccessRequestChkBoxField().click();
		}
	}
	
	public void selectMDFRequestStatusDD(String MDFRequestStatus)
	{
		Select dropdown= new Select(getMDFRequestStatusDDField()); 
		dropdown.selectByVisibleText(MDFRequestStatus); 
		System.out.println("MDF Request Status is " + MDFRequestStatus);
	}
	
	public void SelectPartnerLearningCenterAccessRequestChkBoxField(String partnerLearningCenterAccessRequest) 
	{
		if (Boolean.valueOf(partnerLearningCenterAccessRequest) && !getPartnerLearningCenterAccessRequestChkBoxField().isSelected())
		{
			getPartnerLearningCenterAccessRequestChkBoxField().click();
		}
	}
	
	public void selectPartnerLearningCenterRequestStatusDD(String partnerLearningCenterRequestStatus)
	{
		Select dropdown= new Select(getPartnerLearningCenterRequestStatusDDField()); 
		dropdown.selectByVisibleText(partnerLearningCenterRequestStatus); 
		System.out.println("Partner Learning Center Request Status is " + partnerLearningCenterRequestStatus);
	}
	
	public void SelectRebatesAccessRequestChkBox(String rebatesAccessRequest) 
	{
		if (Boolean.valueOf(rebatesAccessRequest) && !getRebatesAccessRequestChkBoxField().isSelected())
		{
			getRebatesAccessRequestChkBoxField().click();
		}
	}
	
	public void selectRebatesRequestStatusDD(String rebatesRequestStatus)
	{
		Select dropdown= new Select(getRebatesRequestStatusDDField()); 
		dropdown.selectByVisibleText(rebatesRequestStatus); 
		System.out.println("Rebates Request Status is " + rebatesRequestStatus);
	}
	
	public void SelectSalesforcecomAccessRequestChkBox(String salesforcecomAccessRequest) 
	{		
		if (Boolean.valueOf(salesforcecomAccessRequest) && !getSalesforcecomAccessRequestChkBoxField().isSelected())
		{
			getSalesforcecomAccessRequestChkBoxField().click();
		}
	}
	
	public void selectSalesforcecomRequestStatusDD(String salesforcecomRequestStatus)
	{
		Select dropdown= new Select(getSalesforcecomRequestStatusDDField()); 
		dropdown.selectByVisibleText(salesforcecomRequestStatus); 
		System.out.println("Salesforce.com Request Status is " + salesforcecomRequestStatus);
	}
	
	public void SelectServicePortalAccessRequestChkBox(String servicePortalAccessRequest) 
	{
		if (Boolean.valueOf(servicePortalAccessRequest) && !getServicePortalAccessRequestChkBoxField().isSelected())
		{
			getServicePortalAccessRequestChkBoxField().click();
		}
	}
	
	public void selectServicePortalRequestStatusDD(String servicePortalRequestStatus)
	{
		Select dropdown= new Select(getServicePortalRequestStatusDDField()); 
		dropdown.selectByVisibleText(servicePortalRequestStatus); 
		System.out.println("Service Portal Request Status is " + servicePortalRequestStatus);
	}
	
	public void SelectAbilitytoExportPermissionRequestChkBox(String abilitytoExportPermissionRequest) 
	{
		if (Boolean.valueOf(abilitytoExportPermissionRequest) && !getAbilitytoExportPermissionRequestChkBoxField().isSelected())
		{
			getAbilitytoExportPermissionRequestChkBoxField().click();
		}
	}
	
	public void selectAbilitytoExportRequestStatusDD(String abilitytoExportRequestStatus)
	{
		Select dropdown= new Select(getAbilitytoExportRequestStatusDDField()); 
		dropdown.selectByVisibleText(abilitytoExportRequestStatus); 
		System.out.println("Ability to Export Request Status is " + abilitytoExportRequestStatus);
	}
	
	public void SelectMakePartnerAdminPermissionRequestChkBox(String makePartnerAdminPermissionRequest) 
	{
		if (Boolean.valueOf(makePartnerAdminPermissionRequest) && !getMakePartnerAdminPermissionRequestChkBoxField().isSelected())
		{
			getMakePartnerAdminPermissionRequestChkBoxField().click();
		}
	}
	
	public void selectMakePartnerAdminRequestStatusDD(String makePartnerAdminRequestStatus)
	{
		Select dropdown= new Select(getMakePartnerAdminRequestStatusDDField()); 
		dropdown.selectByVisibleText(makePartnerAdminRequestStatus); 
		System.out.println("Make Partner Admin Request Status is " + makePartnerAdminRequestStatus);
	}
	
	public void SelectiAssetMSRoyaltyToolAdminRequestChkBox(String iAssetMSRoyaltyToolAdminRequest) 
	{
		if (Boolean.valueOf(iAssetMSRoyaltyToolAdminRequest) && !getiAssetMSRoyaltyToolAdminRequestChkBoxField().isSelected())
		{
			getiAssetMSRoyaltyToolAdminRequestChkBoxField().click();
		}
	}
	
	public void selectiAssetMSPRoyaltyToolAdminStatus(String iAssetMSPRoyaltyToolAdminStatus)
	{
		Select dropdown= new Select(getiAssetMSPRoyaltyToolAdminStatusDDField()); 
		dropdown.selectByVisibleText(iAssetMSPRoyaltyToolAdminStatus); 
		System.out.println("i Asset MSP Royalty Tool Admin Status is " + iAssetMSPRoyaltyToolAdminStatus);
	}
	
	public void SelectiAssetMSPRoyaltyToolReadOnlyRequestChkBox(String abilitytoExportPermissionRequest) 
	{
		if (Boolean.valueOf(abilitytoExportPermissionRequest) && !getiAssetMSPRoyaltyToolReadOnlyRequestChkBoxField().isSelected())
		{
			getiAssetMSPRoyaltyToolReadOnlyRequestChkBoxField().click();
		}
	}
	
	public void selectiAssetMSPRoyaltyToolReadOnlyStatusDD(String iAssetMSPRoyaltyToolReadOnlyStatus)
	{
		Select dropdown= new Select(getiAssetMSPRoyaltyToolReadOnlyStatusDDField()); 
		dropdown.selectByVisibleText(iAssetMSPRoyaltyToolReadOnlyStatus); 
		System.out.println("i Asset MSP Royalty Tool Read Only Status is " + iAssetMSPRoyaltyToolReadOnlyStatus);
	}
	
	public void putsfTCAcceptanceDateTxt()
	{
		/*
		//Read current date from page  assign to target
		String target="5/23/2017 4:31 AM";
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.ENGLISH);
		Date result = df.parse(target);
		//Current date from page
		System.out.println(result);
		Calendar c = Calendar.getInstance();
		c.setTime(result);
		// add one month
		c.add(Calendar.MONTH,1);
		Date currentDatePlusOne = c.getTime();
		String tcAcceptanceDate = df.format(currentDatePlusOne);
		*/
		
		String tcAcceptanceDate;
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        tcAcceptanceDate = new SimpleDateFormat("MM/dd/yyyy hh:mm a").format(calendar.getTime());
        getTCAcceptanceDateTxtField().sendKeys(tcAcceptanceDate);
        System.out.println("T & C Acceptance Date  is " + tcAcceptanceDate); 
	}	
	
	public ContactsEdit clickCancel() 
	{
		getCancelBtnField().click();
		return new ContactsEdit(driver, propObject);
	}
	
	public Contacts onClickSave() 
	{
		getSaveBtnField().click();
		System.out.println("Save Button Clicked");
		return new Contacts(driver, propObject);
	}
}
