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

  
  

public class AccountsCreationFromSFUsingRecordTypeEndCustomer extends BaseClass
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
		System.out.println("End Customer Accounts Creation in Sales Application");
	}
	
	
	
	@Test(dataProvider="AccountCreatorUsingByEndCustomer",dataProviderClass=DataProviderClass.class)
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
		accountsEdit.putAccountNameLocal(testData[4]);
		accountsEdit.putAccountSegment(testData[5]);
		//accountsEdit.selectVerticalIndustry(testData[6]);
		accountsEdit.selectCustomerAccountGroup(testData[6]);
		//accountsEdit.selectSiteDesignation(testData[8]);
		//accountsEdit.selectSiteDesignationCalculated(testData[9]);
		accountsEdit.selectAccountCurrency(testData[7]);
		
		//Additional Information
		accountsEdit.selectGeo(testData[8]);
		accountsEdit.selectRegion(testData[9]);
		accountsEdit.selectSubRegion(testData[10]);
		accountsEdit.putWebsite(testData[11]);
		accountsEdit.putSICDescription(testData[12]);
		
		//Address Information
		accountsEdit.selectCountry(testData[13]);
		accountsEdit.putStreet(testData[14]);
		accountsEdit.putCity(testData[15]);
		accountsEdit.selectState(testData[16]);
		accountsEdit.putZip(testData[17]);
		accountsEdit.putPhone(testData[18]);
		accountsEdit.putFax(testData[19]);
		
		//Account Hierarchy
		//accountsEdit.putGrandParentAccount(testData[23]);
		//accountsEdit.putParentAccount(testData[24]);
		
		accountsEdit.onClickSave();
		String accountName=accountsTab.verifyAccountCreated();
		Assert.assertNotNull(accountName, "End Customer Account has been created in sales application");
		dataproviders.writeDataToExcel("./resources/TestData.xlsx", "AccountsCreationsByEndCustomer", accountName, i ,testData.length);
	} 
	
	@AfterMethod
	public void colno()
    {
		i++;
	}
}
