package com.macfee.sampletest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.macfee.pages.SalesHomePage;
import com.macfee.pages.SalesLoginPage;
import com.macfee.pages.contacts.ContactSearch;
import com.macfee.pages.contacts.Contacts;
import com.macfee.pages.contacts.ContactsEdit;
import com.macfee.pages.contacts.NewContact;
  
import com.mcafee.framework.BaseClass;
import com.mcafee.framework.ConfigData;
import com.mcafee.framework.DataProviderClass;

  
  

public class ContactsCreationFromSFUsingRecordTypeEndCustomer extends BaseClass
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
		Assert.assertTrue(salesHomePage.isHomePageLaunched(), "Sales home page launched successfully");
		  
		System.out.println("End Customer Contacts Creation in Sales Application");
	}
	
	@Test(dataProvider="contactCreatorByEndCustomer",dataProviderClass=DataProviderClass.class)
	public void test(String...testData) throws Exception
	{
		contactsTab=salesHomePage.onClickContactTab();
		newContact=contactsTab.onClickNewButton();
		newContact.selectContactRecordType(testData[0]);
		contactSearch=newContact.onClickContinue();
		
		//End Customer 'Contact Search'
		contactSearch.putFirstName(testData[1]);
		contactSearch.putLastName(testData[2]);
		contactSearch.putBusinessEmailTxtField(testData[3]);
		contactSearch.putSearchEndCustomerAccountName(testData[4]);
		contactSearch.onClickContactSearchBtn();
		
		contactsEdit=contactSearch.onClickNewContactBtn();
			
		//End Customer 'Contact Information'
		contactsEdit.selectTitle(testData[5]);
		contactsEdit.putFirstName(testData[6]);
		contactsEdit.putJobTitle(testData[7]);
		contactsEdit.putLastName();
		contactsEdit.selectJobLevel(testData[8]);
		contactsEdit.putBusinessPhone(testData[9]);
		contactsEdit.selectJobFunction(testData[10]);
		contactsEdit.selectDesignationUnselected();
		contactsEdit.SelectDesignationsFWDBtn();
		contactsEdit.putBusinessPhoneExtension(testData[11]);
		contactsEdit.putMobile(testData[12]);
		contactsEdit.putBusinessFax(testData[13]);
		contactsEdit.putBusinessEmail();
		contactsEdit.putLinkedInProfile(testData[14]);
		
		//End Customer 'Additional Information
		contactsEdit.putContactDescription(testData[15]);
		
		//End Customer 'Address Information'
		contactsEdit.selectMailingCountry(testData[16]);
		contactsEdit.selectOtherCountry(testData[17]);
		contactsEdit.putMailingStreet(testData[18]);
		contactsEdit.putOtherStreet(testData[19]);
		contactsEdit.putMailingCity(testData[20]);
		contactsEdit.putOtherCity(testData[21]);
		contactsEdit.selectMailingStateProvince(testData[22]);
		contactsEdit.selectOtherStateProvince(testData[23]);
		contactsEdit.putMailingZipPostalCode(testData[24]);
		contactsEdit.putOtherZipPostalCode(testData[25]);
		
		//End Customer 'Marketing Information'
		contactsEdit.SelectDoNotCallChkBox(testData[26]);
		contactsEdit.putLatticeScore();
		contactsEdit.SelectDoNotMailChkBox(testData[27]);
		
		/*
		contactsEdit.putEloquaPhone(testData[28]);
		contactsEdit.SelectWithholdMarketingChkBox(testData[29]);
		contactsEdit.selectMarketingPersonaUnselectedMSL();
		contactsEdit.SelectMarketingPersonaFWDBtn();
		contactsEdit.SelectEmailOptOutChkBox(testData[30]);
		contactsEdit.selectContactStatus(testData[31]);
		*/
		contactsEdit.selectPreferredLanguage(testData[28]);
		
		/*
		contactsEdit.selectStatusReason(testData[33]);
		
		
		//End Customer 'System Information'
		contactsEdit.putLegacyId();
		contactsEdit.putContactSAPID(testData[34]);
		contactsEdit.putLegacyCreated();
		contactsEdit.putMDMContactID(testData[35]);
		contactsEdit.putEloquaContactID(testData[36]);
		contactsEdit.selectRelatedUser(testData[37]);
		contactsEdit.putRelatedUser(testData[38]);
		contactsEdit.putSourceSystem(testData[39]);
		contactsEdit.putProspectContactIdentifier(testData[40]);
		*/
		contactsEdit.onClickSave();
		String contactName=contactsTab.verifyContactCreated();
		Assert.assertNotNull(contactName, "End Customer Contact has been created in sales application");
		dataproviders.writeDataToExcel("./resources/TestData.xlsx", "ContactsCreationByEndCustomer", contactName, i ,testData.length);
	} 
	
	@AfterMethod
	public void colno()
    {
		i++;
	}
}
