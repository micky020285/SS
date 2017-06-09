package com.macfee.pages.accounts;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

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

public class AccountsEdit 
{
	private WebDriver driver;
	private PropertiesReader propObject;
	//private String sfAccountEditExpTitle ="Accounts: Home ~ Salesforce - Unlimited Edition";
	
	AccountsEdit(WebDriver driver, PropertiesReader propObject)
	{
		this.driver = driver;
		this.propObject=propObject;
	}
	
	public void verifyIfCaseEditPage() 
	{
		Assert.assertEquals(getSaveBtnField().isDisplayed(), true, "Account Edit");
	}
	
	public WebElement getAccountNameTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfAccountEditAccountNameTxtField")), 10);
	}
	
	public WebElement getAccountCurrencyDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfAccountCurrencyDDField")), 10);
	}
	
	public WebElement getParentAccountLookupIconField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfParentAccountLookupIcon")), 10);
	}
	
	public WebElement getSearchLookupTxtField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfSearchLookup")), 10);
	}
	
	public WebElement getGoBtnField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfGoBtnLookup")), 10);
	}
	
	public WebElement getSelectResultLinkField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfSelectResultLink")), 10);
	}
	
	public WebElement getParentAccountTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfParentAccountTxtField")), 10);
	}
	
	public WebElement getAccountSegmentTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfAccountSegmentTxtField")), 10);
	}
	
	public WebElement getDescriptionTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfDescriptionTxtField")), 10);
	}
	
	public WebElement getSiteDesignationDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfSiteDesignationDDField")), 10);
	}
	
	public WebElement getPlanningOwnerDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfPlanningOwnerDDField")), 10);
	}
	
	public WebElement getPlanningOwnerTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfPlanningOwnerTxtField")), 10);
	}
	
	public WebElement getCountryDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfCountryDDField")), 10);
	}
	
	public WebElement getStreetTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfStreetTxtField")), 10);
	}
	
	public WebElement getCityTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfCityTxtField")), 10);
	}
	
	public WebElement getStateDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfStateDDField")), 10);
	}
	
	public WebElement getZipTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfZipTxtField")), 10);
	}
	
	public WebElement getPartnerTypeDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfPartnerTypeDDField")), 10);
	}
	
	public WebElement getWebsiteTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfWebsiteTxtField")), 10);
	}
	
	public WebElement getPhoneTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfPhoneTxtField")), 10);
	}
	
	public WebElement getZipAssignmentsTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfZipAssignmentsTxtField")), 10);
	}
	
	public WebElement getAccountUCNTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfAccountUCNTxtField")), 10);
	}
	
	public WebElement getVerticalIndustryDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfVerticalIndustryDDField")), 10);
	}
	
	public WebElement getSAPCustomerNumberTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfSAPCustomerNumberTxtField")), 10);
	}
	
	public WebElement getCustomerAccountGroupDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfCustomerAccountGroupDDField")), 10);
	}
	
	public WebElement getPriceBandAgreementTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfPriceBandAgreementTxtField")), 10);
	}
	
	public WebElement getSiteDesignationCalculatedDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfSiteDesignationCalculatedDDField")), 10);
	}
	
	public WebElement getEvalYearEndCalcChkBoxField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfEvalYearEndCalcChkBox")), 10);
	}
	
	public WebElement getSICCodeTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfSICCodeTxtField")), 10);
	}
	
	public WebElement getGeoDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfGeoDDField")), 10);
	}
	
	public WebElement getRegionDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfRegionDDField")), 10);
	}
	
	public WebElement getSubRegionDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfSubRegionDDField")), 10);
	}
	
	public WebElement getSICDescriptionTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfSICDescriptionTxtField")), 10);
	}
	
	public WebElement getTotalSiteEmployeeTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfTotalSiteEmployeeTxtField")), 10);
	}
	
	public WebElement getTotalAVAccountNodesTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfTotalAVAccountNodesTxtField")), 10);
	}
	
	public WebElement getTotalGlobalEmployeesTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfTotalGlobalEmployeesTxtField")), 10);
	}
	
	public WebElement getGlobalTotalAVAccountNodesTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfGlobalTotalAVAccountNodesTxtField")), 10);
	}
	
	public WebElement getTypeDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfTypeDDField")), 10);
	}
	
	public WebElement getG2kAccountChkBoxField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfG2kAccountChkBox")), 10);
	}
	
	public WebElement getFaxTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfFaxTxtField")), 10);
	}
	
	public WebElement getGlobalUCNTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfGlobalUCNTxtField")), 10);
	}
	
	public WebElement getAccountDUNSTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfAccountDUNSTxtField")), 10);
	}
	
	public WebElement getGrandParentAccountTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfGrandParentAccountTxtField")), 10);
	}
	
	public WebElement getDomesticUltimateDUNSTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfDomesticUltimateDUNSTxtField")), 10);
	}
	
	public WebElement getParentUCNTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfParentUCNTxtField")), 10);
	}
	
	public WebElement getParentDUNSTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfParentDUNSTxtField")), 10);
	}
	
	public WebElement getGlobalUltimateDUNSTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfGlobalUltimateDUNSTxtField")), 10);
	}
	
	public WebElement getLegacyMDMIDTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfLegacyMDMIDTxtField")), 10);
	}
	
	public WebElement getSourceSystemDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfSourceSystemDDField")), 10);
	}
	
	public WebElement getCurrentYrTrainingCreditsTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfCurrentYrTrainingCreditsTxtField")), 10);
	}
	
	public WebElement getAliasPreferredNameTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfAliasPreferredNameTxtField")), 10);
	}
	
	public WebElement getStatusReasonDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfStatusReasonDDField")), 10);
	}
	
	public WebElement getNamedPartnerDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfNamedPartnerDDField")), 10);
	}
	
	public WebElement getPurchasingAgreementDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfPurchasingAgreementDDField")), 10);
	}
	
	public WebElement getMSPPricingBandDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfMSPPricingBandDDField")), 10);
	}
	
	public WebElement getPartnerClassificationUnselectedMSLField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfPartnerClassificationUnselectedMSLField")), 10);
	}
	
	public WebElement getPartnerClassificationFWDBtnField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfPartnerClassificationRightArrowBtnField")), 10);
	}
	
	public WebElement getPartnerClassificationBWDBtnField() 
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfPartnerClassificationLeftArrowBtnField")), 10);
	}
	
	public WebElement getPartnerClassificationSelectedMSLField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfPartnerClassificationSelectedMSLField")), 10);
	}
	
	public WebElement getVerticalMarketFocusUnselectedMSLField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfVerticalMarketFocusUnselectedMSLField")), 10);
	}
	
	public WebElement getVerticalMarketFocusFWDBtnField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfVerticalMarketFocusRightArrowBtnField")), 10);
	}
	
	public WebElement getVerticalMarketFocusBWDBtnField() 
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfVerticalMarketFocusLeftArrowBtnField")), 10);
	}
	
	public WebElement getVerticalMarketFocusSelectedMSLField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfVerticalMarketFocusSelectedMSLField")), 10);
	}
	
	public WebElement getCompanyDomainTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfCompanyDomainTxtField")), 10);
	}
	
	public WebElement getCountriesAuthorizedToSellInUnselectedMSLField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfCountriesAuthorizedToSellInUnselectedMSLField")), 10);
	}
	
	public WebElement getCountriesAuthorizedToSellInFWDBtnField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfCountriesAuthorizedToSellInRightArrowBtnField")), 10);
	}
	
	public WebElement getCountriesAuthorizedToSellInBWDBtnField() 
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfCountriesAuthorizedToSellInLeftArrowBtnField")), 10);
	}
	
	public WebElement getCountriesAuthorizedToSellInSelectedMSLField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfCountriesAuthorizedToSellInSelectedMSLField")), 10);
	}
	
	public WebElement getOwnerChangeFailureReasonTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfOwnerChangeFailureReasonTxtField")), 10);
	}
	
	public WebElement getPartnershipStatusDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfPartnershipStatusDDField")), 10);
	}
	
	public WebElement getPartnerHierarchyLevelDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfPartnerHierarchyLevelDDField")), 10);
	}
	
	public WebElement getWWPartnerParentUCNTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfWWPartnerParentUCNTxtField")), 10);
	}
	
	public WebElement getPartnerParentUCNTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfPartnerParentUCNTxtField")), 10);
	}
	
	public WebElement getHQFlagChkBoxField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfHQFlagChkBoxField")), 10);
	}
	
	public WebElement getSystemResellLevelDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfSystemResellLevelDDField")), 10);
	}
	
	public WebElement getPartnerLocatorChkBoxField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfPartnerLocatorChkBoxField")), 10);
	}
	
	public WebElement getAccountNameLocalTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfAccountEditAccountNameLocalTxtField")), 10);
	}
	
	public WebElement getTotalSiteEmployeesTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfTotalSiteEmployeesTxtField")), 10);
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
	
	public void putAccountName()
	{
		getAccountNameTxtField().clear();
		//Date datetime = new Date();
		//getAccountNameTxtField().sendKeys("AutomationAccount"+datetime.toString());
		String datetime = currentTimeVariable();
		getAccountNameTxtField().sendKeys("AutomationAccount"+datetime);
		System.out.println("Account Name Created");
	}
	
	public void selectAccountCurrency(String accountcurrency)
	{
		Select dropdown= new Select(getAccountCurrencyDDField()); 
		dropdown.selectByVisibleText(accountcurrency); 
		System.out.println("Account Currency is " + accountcurrency);
	}
	
	public void putParentAccount(String parentaccount)
	{
		/*
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
				
		// Perform the click operation that opens new window
		getParentAccountLookupIconField().click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles())
			{
		    	driver.switchTo().window(winHandle);
			}

		// Perform the actions on new window
		getSearchLookupTxtField().sendKeys(parentaccount);
		getGoBtnField().click();
		getSelectResultLinkField().click();

		// Close the new window, if that window no more required
		//driver.close();

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

		// Continue with original browser (first window)
		String parentaccountvalue = getParentAccountTxtField().getAttribute("value");
		*/
		getParentAccountTxtField().sendKeys(parentaccount);
		System.out.println("Parent Account " + parentaccount);
	}
	
	public void putAccountSegment(String accountsegment)
	{
		getAccountSegmentTxtField().sendKeys(accountsegment);
		System.out.println("Account Segment " + accountsegment);
	}
	
	public void putDescription(String description)
	{
		getDescriptionTxtField().sendKeys(description);
		System.out.println("Description " + description);
	}
	
	public void selectSiteDesignation(String sitedesignation)
	{
		Select dropdown= new Select(getSiteDesignationDDField()); 
		dropdown.selectByVisibleText(sitedesignation); 
		System.out.println("Site Designation is " + sitedesignation);
	}
	
	public void selectPlanningOwnerDD(String planningownerdd)
	{
		Select dropdown= new Select(getPlanningOwnerDDField()); 
		dropdown.selectByVisibleText(planningownerdd); 
		System.out.println("Planning Owner DD is " + planningownerdd);
	}
	
	public void putPlanningOwnerTxt(String planningownertxt)
	{
		getPlanningOwnerTxtField().sendKeys(planningownertxt);
		System.out.println("Planning Owner Text is " + planningownertxt);
	}
	
	public void selectCountry(String country)
	{
		Select dropdown= new Select(getCountryDDField()); 
		dropdown.selectByVisibleText(country); 
		System.out.println("Country is " + country);
	}
	
	public void putStreet(String street)
	{
		getStreetTxtField().sendKeys(street);
		System.out.println("Street is " + street);
	}
	
	public void putCity(String city)
	{
		getCityTxtField().sendKeys(city);
		System.out.println("City is " + city);
	}
	
	public void selectState(String state)
	{
		Select dropdown= new Select(getStateDDField()); 
		dropdown.selectByVisibleText(state); 
		System.out.println("State is " + state);
	}
	
	public void putZip(String zip)
	{
		getZipTxtField().sendKeys(zip);
		System.out.println("Zip is " + zip);
	}
	
	public void selectPartnerType(String partnertype)
	{
		Select dropdown= new Select(getPartnerTypeDDField()); 
		dropdown.selectByVisibleText(partnertype); 
		System.out.println("Partner Type " + partnertype);
	}
	
	public void putWebsite(String website)
	{
		getWebsiteTxtField().sendKeys(website);
		System.out.println("Website is " + website);
	}
	
	public void putPhone(String phone)
	{
		getPhoneTxtField().sendKeys(phone);
		System.out.println("Phone " + phone);
	}
	
	public void putZipAssignments(String zipassignments)
	{
		getZipAssignmentsTxtField().sendKeys(zipassignments);
		System.out.println("Zip Assignments " + zipassignments);
	}
	
	public void putAccountUCN(String accountUCN)
	{
		getAccountUCNTxtField().sendKeys(accountUCN);
		System.out.println("Account UCN " + accountUCN);
	}
	
	public void selectVerticalIndustry(String verticalIndustry)
	{
		Select dropdown= new Select(getVerticalIndustryDDField()); 
		dropdown.selectByVisibleText(verticalIndustry); 
		System.out.println("Vertical Industry " + verticalIndustry);
	}
	
	public void putSAPCustomerNumber(String SAPCustomerNumber)
	{
		getSAPCustomerNumberTxtField().sendKeys(SAPCustomerNumber);
		System.out.println("SAP Customer Number " + SAPCustomerNumber);
	}
	
	public void selectCustomerAccountGroup(String customeraccountgroup)
	{
		Select dropdown= new Select(getCustomerAccountGroupDDField()); 
		dropdown.selectByVisibleText(customeraccountgroup); 
		System.out.println("Customer Account Group " + customeraccountgroup);
	}
	
	public void putPriceBandAgreement(String pricebandagreement)
	{
		getPriceBandAgreementTxtField().sendKeys(pricebandagreement);
		System.out.println("Price Band Agreement is " + pricebandagreement);
	}
	
	public void putSICCode(String siccode)
	{
		getSICCodeTxtField().sendKeys(siccode);
		System.out.println("SIC Code is " + siccode);
	}
	
	public void selectSiteDesignationCalculated(String sitedesignationcalculated)
	{
		Select dropdown= new Select(getSiteDesignationCalculatedDDField()); 
		dropdown.selectByVisibleText(sitedesignationcalculated); 
		System.out.println("Site Designation Calculated " + sitedesignationcalculated);
	}
	
	public void selectGeo(String geo)
	{
		Select dropdown= new Select(getGeoDDField()); 
		dropdown.selectByVisibleText(geo); 
		System.out.println("Geo is " + geo);
	}
	
	public void selectRegion(String region)
	{
		Select dropdown= new Select(getRegionDDField()); 
		dropdown.selectByVisibleText(region); 
		System.out.println("Region is " + region);
	}
	
	public void selectSubRegion(String subRegion)
	{
		Select dropdown= new Select(getSubRegionDDField()); 
		dropdown.selectByVisibleText(subRegion); 
		System.out.println("Sub Region is " + subRegion);
	}
	
	public void putSICDescription(String sicdescription)
	{
		getSICDescriptionTxtField().sendKeys(sicdescription);
		System.out.println("SIC Description is " + sicdescription);
	}
	
	public void putTotalSiteEmployee(String totalsiteemployee)
	{
		getTotalSiteEmployeeTxtField().sendKeys(totalsiteemployee);
		System.out.println("Total Site Employee is " + totalsiteemployee);
	}
	
	public void putTotalAVAccountNodes(String totalAVAccountNodes)
	{
		getTotalAVAccountNodesTxtField().sendKeys(totalAVAccountNodes);
		System.out.println("Total AV Account Nodes is " + totalAVAccountNodes);
	}
	
	public void putTotalGlobalEmployees(String totalGlobalEmployees)
	{
		getTotalGlobalEmployeesTxtField().sendKeys(totalGlobalEmployees);
		System.out.println("Total Global Employees is " + totalGlobalEmployees);
	}
	
	public void putGlobalTotalAVAccountNodes(String globalTotalAVAccountNodes)
	{
		getGlobalTotalAVAccountNodesTxtField().sendKeys(globalTotalAVAccountNodes);
		System.out.println("Global Total AV Account Nodes is " + globalTotalAVAccountNodes);
	}
	
	public void selectType(String type)
	{
		Select dropdown= new Select(getTypeDDField()); 
		dropdown.selectByVisibleText(type); 
		System.out.println("Type is " + type);
	}
	
	public void putFax(String fax)
	{
		getFaxTxtField().sendKeys(fax);
		System.out.println("Fax is " + fax);
	}
	
	public void putGlobalUCN(String globalUCN)
	{
		getGlobalUCNTxtField().sendKeys(globalUCN);
		System.out.println("Global UCN is " + globalUCN);
	}
	
	public void putAccountDUNS(String accountDUNS)
	{
		getAccountDUNSTxtField().sendKeys(accountDUNS);
		System.out.println("Account DUN S is " + accountDUNS);
	}
	
	public void putGrandParentAccount(String grandParentAccount)
	{
		getGrandParentAccountTxtField().sendKeys(grandParentAccount);
		System.out.println("Grand Parent Account is " + grandParentAccount);
	}
	
	public void putDomesticUltimateDUNS(String domesticUltimateDUNS)
	{
		getDomesticUltimateDUNSTxtField().sendKeys(domesticUltimateDUNS);
		System.out.println("Domestic Ultimate DUN S is " + domesticUltimateDUNS);
	}
	
	public void putParentUCN(String parentUCN)
	{
		getGlobalTotalAVAccountNodesTxtField().sendKeys(parentUCN);
		System.out.println("Parent UCN is " + parentUCN);
	}
	
	public void putParentDUNS(String parentDUNS)
	{
		getParentDUNSTxtField().sendKeys(parentDUNS);
		System.out.println("Parent DUN S is " + parentDUNS);
	}
	
	public void putGlobalUltimateDUNS(String globalUltimateDUNS)
	{
		getGlobalUltimateDUNSTxtField().sendKeys(globalUltimateDUNS);
		System.out.println("Global Ultimate DUN S is " + globalUltimateDUNS);
	}
	
	public void putLegacyMDMID(String legacyMDMID)
	{
		getGlobalTotalAVAccountNodesTxtField().sendKeys(legacyMDMID);
		System.out.println("Legacy MDM ID is " + legacyMDMID);
	}
	
	public void selectSourceSystem(String sourceSystem)
	{
		Select dropdown= new Select(getSourceSystemDDField()); 
		dropdown.selectByVisibleText(sourceSystem); 
		System.out.println("Source System is " + sourceSystem);
	}
	
	public void putCurrentYrTrainingCredits(String currentYrTrainingCredits)
	{
		getCurrentYrTrainingCreditsTxtField().sendKeys(currentYrTrainingCredits);
		System.out.println("Current Yr Training Credits is " + currentYrTrainingCredits);
	}
	
	public void putAliasPreferredName(String aliasPreferredName)
	{
		getAliasPreferredNameTxtField().sendKeys(aliasPreferredName);
		System.out.println("Alias Preferred Name is " + aliasPreferredName);
	}
	
	public void selectStatusReason(String statusReason)
	{
		Select dropdown= new Select(getStatusReasonDDField()); 
		dropdown.selectByVisibleText(statusReason); 
		System.out.println("Status Reason is " + statusReason);
	}
	
	public void selectNamedPartner(String namedPartner)
	{
		Select dropdown= new Select(getNamedPartnerDDField()); 
		dropdown.selectByVisibleText(namedPartner); 
		System.out.println("Named Partner is " + namedPartner);
	}
	
	public void selectPurchasingAgreement(String purchasingAgreement)
	{
		Select dropdown= new Select(getPurchasingAgreementDDField()); 
		dropdown.selectByVisibleText(purchasingAgreement); 
		System.out.println("Purchasing Agreement is " + purchasingAgreement);
	}
	
	public void selectMSPPricingBand(String mspPricingBand)
	{
		Select dropdown= new Select(getMSPPricingBandDDField()); 
		dropdown.selectByVisibleText(mspPricingBand); 
		System.out.println("Source System is " + mspPricingBand);
	}
	
	public void selectPartnerClassificationUnselected()
	{		
		Select multiselectlistbox = new Select(getPartnerClassificationUnselectedMSLField());
		List<WebElement> elementCount = multiselectlistbox.getOptions();
		//int iSize = elementCount.size();
		for (int i = 0; i <=1; i++) 
		{
			multiselectlistbox.selectByVisibleText(elementCount.get(i).getText());
			System.out.println("Partner Classification Left list box " + i);
		}
	}
	
	public void SelectPartnerClassificationFWDBtn() 
	{
		getPartnerClassificationFWDBtnField().click();
	}
	
	public void SelectPartnerClassificationBWDBtn() 
	{
		getPartnerClassificationBWDBtnField().click();
	}
	
	public void selectPartnerClassificationSelected()
	{
		Select multiselectlistbox = new Select(getPartnerClassificationSelectedMSLField());
		List<WebElement> elementCount = multiselectlistbox.getOptions();
		int iSize = elementCount.size();
		for (int i = 0; i < iSize; i++) 
		{
			multiselectlistbox.selectByVisibleText(elementCount.get(i).getText());
			System.out.println("Partner Classification Right List box " + i);
		}
	}
	
	public void selectVerticalMarketFocusUnselected()
	{
		Select multiselectlistbox = new Select(getVerticalMarketFocusUnselectedMSLField());
		List<WebElement> elementCount = multiselectlistbox.getOptions();
		//int iSize = elementCount.size();
		for (int i = 0; i <=1; i++) 
		{
			multiselectlistbox.selectByVisibleText(elementCount.get(i).getText());
			System.out.println("Vertical Market Focus Left List Box Value is " + i);
		}
	}
	
	public void SelectVerticalMarketFocusFWDBtn() 
	{
		getVerticalMarketFocusFWDBtnField().click();
	}
	
	public void SelectVerticalMarketFocusBWDBtn() 
	{
		getVerticalMarketFocusBWDBtnField().click();
	}
	
	public void selectVerticalMarketFocusSelected()
	{
		Select multiselectlistbox = new Select(getVerticalMarketFocusSelectedMSLField());
		List<WebElement> elementCount = multiselectlistbox.getOptions();
		int iSize = elementCount.size();
		for (int i = 0; i < iSize; i++) 
		{
			multiselectlistbox.selectByVisibleText(elementCount.get(i).getText());
			System.out.println("Vertical Market Focus Right List Box Value is " + i);
		}
	}
	
	public void putCompanyDomain(String companyDomain)
	{
		getCompanyDomainTxtField().sendKeys(companyDomain);
		System.out.println("Company Domain is " + companyDomain);
	}
	
	public void selectCountriesAuthorizedToSellInUnselected()
	{
		Select multiselectlistbox = new Select(getCountriesAuthorizedToSellInUnselectedMSLField());
		List<WebElement> elementCount = multiselectlistbox.getOptions();
		//int iSize = elementCount.size();
		for (int i = 0; i <=1; i++) 
		{
			multiselectlistbox.selectByVisibleText(elementCount.get(i).getText());
			System.out.println("Countries Authorized To Sell Left List Box Value is " + i);
		}
	}
	
	public void SelectCountriesAuthorizedToSellInFWDBtn() 
	{
		getCountriesAuthorizedToSellInFWDBtnField().click();
	}
	
	public void SelectCountriesAuthorizedToSellInBWDBtn() 
	{
		getCountriesAuthorizedToSellInBWDBtnField().click();
	}
	
	public void selectCountriesAuthorizedToSellInSelected()
	{	
		Select multiselectlistbox = new Select(getCountriesAuthorizedToSellInSelectedMSLField());
		List<WebElement> elementCount = multiselectlistbox.getOptions();
		int iSize = elementCount.size();
		for (int i = 0; i < iSize; i++) 
		{
			multiselectlistbox.selectByVisibleText(elementCount.get(i).getText());
			System.out.println("Countries Authorized To Sell Right List Box Value is " + i);
		}
	}
	
	public void putOwnerChangeFailureReason(String ownerChangeFailureReason)
	{
		getOwnerChangeFailureReasonTxtField().sendKeys(ownerChangeFailureReason);
		System.out.println("Owner Change Failure Reason is " + ownerChangeFailureReason);
	}
	
	public void selectPartnershipStatus(String partnershipStatus)
	{
		Select dropdown= new Select(getPartnershipStatusDDField()); 
		dropdown.selectByVisibleText(partnershipStatus); 
		System.out.println("Partnership Status is " + partnershipStatus);
	}
	
	public void selectPartnerHierarchyLevel(String partnerHierarchyLevel)
	{
		Select dropdown= new Select(getPartnerHierarchyLevelDDField()); 
		dropdown.selectByVisibleText(partnerHierarchyLevel); 
		System.out.println("Partner Hierarchy Level is " + partnerHierarchyLevel);
	}
	
	public void putWWPartnerParentUCN(String wwPartnerParentUCN)
	{
		getWWPartnerParentUCNTxtField().sendKeys(wwPartnerParentUCN);
		System.out.println("WW Partner Parent UCN is " + wwPartnerParentUCN);
	}
	
	public void putPartnerParentUCN(String partnerParentUCN)
	{
		getPartnerParentUCNTxtField().sendKeys(partnerParentUCN);
		System.out.println("Partner Parent UCN is " + partnerParentUCN);
	}
	
	public void selectSystemResellLevel(String systemResellLevel)
	{
		Select dropdown= new Select(getSystemResellLevelDDField()); 
		dropdown.selectByVisibleText(systemResellLevel); 
		System.out.println("System Resell Level is " + systemResellLevel);
	}
	
	public void SelectPartnerLocatorChkBox(String doNotMail) 
	{
        if (Boolean.valueOf(doNotMail) && !getPartnerLocatorChkBoxField().isSelected())
        {
        	getPartnerLocatorChkBoxField().click();
        }
	}
	
	public void putAccountNameLocal(String accountNameLocal)
	{
		getAccountNameLocalTxtField().clear();
		getAccountNameLocalTxtField().sendKeys(accountNameLocal);
		System.out.println("Account Name Local " + accountNameLocal);
	}
	
	public void putTotalSiteEmployees(String totalSiteEmployees)
	{
		getTotalSiteEmployeesTxtField().sendKeys(totalSiteEmployees);
		System.out.println("Total Site Employees " + totalSiteEmployees);
	}
	
	public AccountsEdit onClickCancel() 
	{
		getCancelBtnField().click();
		return new AccountsEdit(driver, propObject);
	}
	
	public Accounts onClickSave() 
	{
		getSaveBtnField().click();
		System.out.println("Save Button Clicked");
		return new Accounts(driver, propObject);
	}
	
}
