package com.macfee.sampletest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.macfee.pages.SalesHomePage;
import com.macfee.pages.SalesLoginPage;
import com.macfee.pages.accounts.AccountSearch;
import com.macfee.pages.accounts.Accounts;
import com.macfee.pages.accounts.AccountsEdit;
import com.macfee.pages.accounts.NewAccounts;
  
import com.mcafee.framework.BaseClass;
import com.mcafee.framework.ConfigData;
import com.mcafee.framework.DataProviderClass;

  
  

public class AccountsCreationFromSFUsingRecordTypePartnerAccountCountry extends BaseClass
{
	private static SalesLoginPage salesLoginPage;
	private static SalesHomePage salesHomePage;
	private static Accounts accountsTab;
	private static NewAccounts newAccount;
	private static AccountSearch accountSearch;
	private static AccountsEdit accountsEdit;
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
		  
		System.out.println("Partner Account Country Creation in Sales Application");
	}
	
	
	
	@Test(dataProvider="AccountCreatorUsingByCountry", dataProviderClass=DataProviderClass.class)
	public void test(String...testData) throws Exception
	{
		accountsTab=salesHomePage.onClickAccountTab();
		newAccount=accountsTab.onClickNewButton();
		newAccount.selectAccountRecordType(testData[0]);
		accountSearch=newAccount.onClickContinue();
		accountSearch.putAccountName(testData[1]);
		accountSearch.putAccountNameLocal(testData[2]);
		accountSearch.selectCountryName(testData[3]);
		accountSearch.onClickAccountSearchBtn();
		accountsEdit=accountSearch.onClickNewAccountsBtn();

		//Account Information
		accountsEdit.putAccountName();
		accountsEdit.selectPartnershipStatus(testData[4]);
		accountsEdit.putAliasPreferredName(testData[5]);
		accountsEdit.putParentAccount(testData[6]);
		accountsEdit.selectPartnerType(testData[7]);
		accountsEdit.selectPartnerClassificationUnselected();
		accountsEdit.SelectPartnerClassificationFWDBtn();
		accountsEdit.selectVerticalMarketFocusUnselected();
		accountsEdit.SelectVerticalMarketFocusFWDBtn();
		accountsEdit.selectCountriesAuthorizedToSellInUnselected();
		accountsEdit.SelectCountriesAuthorizedToSellInFWDBtn();
		
		//Additional Information
		accountsEdit.putTotalSiteEmployees(testData[8]);
		accountsEdit.selectCountry(testData[9]);
		accountsEdit.putStreet(testData[10]);
		//accountsEdit.SelectPartnerLocatorChkBox(testData[10]);
		accountsEdit.putCity(testData[11]);
		accountsEdit.selectState(testData[12]);
		accountsEdit.putZip(testData[13]);
		accountsEdit.putPhone(testData[14]);
		accountsEdit.putFax(testData[15]);
		accountsEdit.putWebsite(testData[16]);
		
		//System Information
		accountsEdit.selectAccountCurrency(testData[17]);
		
		/*
		//Account Information
		accountsEdit.putAccountName();
		accountsEdit.selectPartnershipStatus(testData[4]);
		accountsEdit.putAliasPreferredName(testData[5]);
		accountsEdit.selectStatusReason(testData[6]);
		accountsEdit.selectPartnerType(testData[7]);
		accountsEdit.selectNamedPartner(testData[8]);
		accountsEdit.selectPurchasingAgreement(testData[9]);
		accountsEdit.selectMSPPricingBand(testData[10]);
		accountsEdit.selectPartnerClassificationUnselected();
		accountsEdit.SelectPartnerClassificationFWDBtn();
		accountsEdit.selectVerticalMarketFocusUnselected();
		accountsEdit.SelectVerticalMarketFocusFWDBtn();
		accountsEdit.selectCountriesAuthorizedToSellInUnselected();
		accountsEdit.selectCountriesAuthorizedToSellInFWDBtn();

		//Additional Information
		accountsEdit.putTotalSiteEmployees(testData[11]);
		accountsEdit.selectCountry(testData[12]);
		accountsEdit.putStreet(testData[13]);
		accountsEdit.putCity(testData[14]);
		accountsEdit.selectState(testData[15]);
		accountsEdit.putZip(testData[16]);
		accountsEdit.putPhone(testData[17]);
		accountsEdit.putFax(testData[18]);
		accountsEdit.putWebsite(testData[19]);

		//System Information
		accountsEdit.selectAccountCurrency(testData[20]);
		*/
		
		accountsEdit.onClickSave();
		String accountName=accountsTab.verifyAccountCreated();
		Assert.assertNotNull(accountName, "Partner Account(Country) has been created in sales application");
		dataproviders.writeDataToExcel("./resources/TestData.xlsx", "AccountsCreationsByCountry", accountName, i ,testData.length);
	} 
	
	@AfterMethod
	public void colno()
    {
		i++;
	}
}
