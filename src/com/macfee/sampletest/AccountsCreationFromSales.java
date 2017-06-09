package com.macfee.sampletest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.macfee.pages.SalesLoginPage;
  
import com.mcafee.framework.BaseClass;
import com.mcafee.framework.ConfigData;
import com.macfee.pages.SalesHomePage;
import com.macfee.pages.accounts.Accounts;
import com.macfee.pages.accounts.NewAccounts;
import com.macfee.pages.accounts.AccountSearch;
import com.macfee.pages.accounts.AccountsEdit;
import com.mcafee.framework.DataProviderClass;
  
  

/**
*
* @author Balamurugan
*
*/

public class AccountsCreationFromSales extends BaseClass
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
		//Assert.assertTrue(false, "Home page launched successfully");
		//Assert.assertTrue(salesHomePage.isHomePageLaunched(), "Sales home page launched successfully");
		  
		System.out.println("Accounts Creation in Sales Application");
	}
	
	@Test(dataProvider="salesAccountCreator",dataProviderClass=DataProviderClass.class)
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
		Thread.sleep(8000);
		accountsEdit=accountSearch.onClickNewAccountsBtn();
		accountsEdit.putAccountName();
		accountsEdit.selectAccountCurrency(testData[4]);
		accountsEdit.onClickSave();
		String accountName=accountsTab.verifyAccountCreated();
		//Assert.assertNotNull(accountName, "Account has been created in sales application");
		dataproviders.writeDataToExcel("./resources/TestData.xlsx", "SalesAccountsCreations", accountName, i ,testData.length);
	} 
	
	@AfterMethod
	public void colno()
    {
		i++;
	}
}
