package com.macfee.sampletest;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.macfee.pages.accounts.AccountSearch;
import com.macfee.pages.accounts.Accounts;
import com.macfee.pages.accounts.AccountsEdit;
import com.macfee.pages.accounts.NewAccounts;
import com.macfee.pages.SalesHomePage;
import com.macfee.pages.SalesLoginPage;
  
import com.mcafee.framework.BaseClass;
import com.mcafee.framework.ConfigData;
import com.mcafee.framework.DataProviderClass;
import com.relevantcodes.extentreports.LogStatus;

  
  

/**
*
* @author Balamurugan
*
*/

public class UserAccountsCreationFromSFUsingRecordTypePartnerAccountNonCountry extends BaseClass
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
		  
		System.out.println("Partner Account (Non-Country) Creation in Sales Application");
		
		salesHomePage.globalSearch(ConfigData.TESTUSERNAME);
		salesHomePage.selectUser();
		salesHomePage.onClickUserActionMenu();
		salesHomePage.editUserRoleProfile(ConfigData.TESTUSERROLES, ConfigData.TESTPCTUSERPROFILES);
		//sfTestUserRole=EMEA Geo Rep SEUR
		//PCTUserProfile=Custom: PCT
		salesHomePage.onClickLoginBtn();
	}
	
	@Test(dataProvider="AccountCreatorUsingByNonCountry", dataProviderClass=DataProviderClass.class)
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
		accountsEdit.selectPartnershipStatus(testData[4]);
		accountsEdit.putAccountName();
		accountsEdit.putAliasPreferredName(testData[5]);
		accountsEdit.putParentAccount(testData[6]);
		accountsEdit.selectPartnerType(testData[7]);
		accountsEdit.selectCountry(testData[8]);
		accountsEdit.putStreet(testData[9]);
		//accountsEdit.SelectPartnerLocatorChkBox(testData[10]);
		accountsEdit.putCity(testData[10]);
		accountsEdit.selectState(testData[11]);
		accountsEdit.putZip(testData[12]);
		accountsEdit.putPhone(testData[13]);
		accountsEdit.putFax(testData[14]);
		accountsEdit.onClickSave();
		String accountNameByNonCountry=accountsTab.verifyAccountCreated();
		Assert.assertNotNull(accountNameByNonCountry, "Partner Account (Non-Country) has been created in sales application");
		if (accountNameByNonCountry!=null) {
			extentTest.log(LogStatus.PASS, "Partner Account (Non-Country) Created succesfully :" + accountNameByNonCountry);
		}
		dataproviders.writeDataToExcel("./resources/TestData.xlsx", "AccountsCreationsByNonCountry", accountNameByNonCountry, i ,testData.length);
	} 
	
	@AfterMethod
	public void colno()
    {
		i++;
	}
}
