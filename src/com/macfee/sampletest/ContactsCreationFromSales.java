package com.macfee.sampletest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.mcafee.framework.ConfigData;
import com.macfee.pages.SalesLoginPage;
  
import com.mcafee.framework.BaseClass;
import com.macfee.pages.SalesHomePage;
import com.macfee.pages.contacts.Contacts;
import com.macfee.pages.contacts.NewContact;
import com.macfee.pages.contacts.ContactSearch;
import com.macfee.pages.contacts.ContactsEdit;
import com.mcafee.framework.DataProviderClass;

  
  

/**
*
* @author Balamurugan
*
*/

public class ContactsCreationFromSales extends BaseClass
{
	private static SalesLoginPage salesLoginPage;
	private static SalesHomePage salesHomePage;
	private static Contacts contactsTab;
	private static NewContact newContact;
	private static ContactSearch contactSearch;
	private static ContactsEdit contactsEdit;
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
	
	@Test(dataProvider="salesContactCreator",dataProviderClass=DataProviderClass.class)
	public void test(String...testData) throws Exception
	{
		contactsTab=salesHomePage.onClickContactTab();
		newContact=contactsTab.onClickNewButton();
		newContact.selectContactRecordType(testData[0]);
		contactSearch=newContact.onClickContinue();
		contactSearch.putFirstName(testData[1]);
		contactSearch.putLastName(testData[2]);
		contactSearch.putBusinessEmailTxtField(testData[3]);
		contactSearch.putSearchEndCustomerAccountName(testData[4]);
		contactSearch.onClickContactSearchBtn();
		contactsEdit=contactSearch.onClickNewContactBtn();
		contactsEdit.selectTitle(testData[5]);
		contactsEdit.putFirstName(testData[6]);
		contactsEdit.putLastName();
		contactsEdit.putBusinessEmail();
		contactsEdit.onClickSave();
		String contactName=contactsTab.verifyContactCreated();
		//Assert.assertNotNull(contactName, "Contact has been created in sales application");
		dataproviders.writeDataToExcel("./resources/TestData.xlsx", "SalesContactCreations", contactName, i ,testData.length);
	} 
	
	@AfterMethod
	public void colno()
    {
		i++;
	}
}
