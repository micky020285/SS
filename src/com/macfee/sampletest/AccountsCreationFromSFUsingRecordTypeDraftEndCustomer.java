package com.macfee.sampletest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.macfee.pages.Profile;
import com.macfee.pages.SalesHomePage;
import com.macfee.pages.SalesLoginPage;
import com.macfee.pages.SetUp;
import com.macfee.pages.accounts.AccountSearch;
import com.macfee.pages.accounts.Accounts;
import com.macfee.pages.accounts.AccountsEdit;
import com.macfee.pages.accounts.NewAccounts;
  
import com.mcafee.framework.BaseClass;
import com.mcafee.framework.ConfigData;
import com.mcafee.framework.DataProviderClass;

  
  

public class AccountsCreationFromSFUsingRecordTypeDraftEndCustomer extends BaseClass
{
	private static SalesLoginPage salesLoginPage;
	private static SalesHomePage salesHomePage;
	private static SetUp setupUser;
	private static Profile profile;
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
		  
		System.out.println("Draft End Customer Accounts Creation in Sales Application");
	}
	
	@Test(dataProvider="AccountCreatorUsingByDraftEndCustomer", dataProviderClass=DataProviderClass.class)
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
		accountsEdit.putAccountName();
		accountsEdit.selectAccountCurrency(testData[4]);
		accountsEdit.putParentAccount(testData[5]);
		accountsEdit.putAccountSegment(testData[6]);
		accountsEdit.putDescription(testData[7]);
		//accountsEdit.selectSiteDesignation(testData[8]);
		//accountsEdit.selectPlanningOwnerDD(testData[9]);
		//accountsEdit.putPlanningOwnerTxt(testData[10]);
		accountsEdit.selectCountry(testData[8]);
		accountsEdit.putStreet(testData[9]);
		accountsEdit.putCity(testData[10]);
		accountsEdit.selectState(testData[11]);
		accountsEdit.putZip(testData[12]);
		accountsEdit.putWebsite(testData[13]);
		accountsEdit.putPhone(testData[14]);
		accountsEdit.onClickSave();
		String accountName=accountsTab.verifyAccountCreated();
		Assert.assertNotNull(accountName, "Draft End Customer Account has been created in sales application");
		dataproviders.writeDataToExcel("./resources/TestData.xlsx", "AccountsCreationsByDraftEndCus", accountName, i ,testData.length);
	} 
	
	@AfterMethod
	public void colno()
    {
		i++;
	}

}
