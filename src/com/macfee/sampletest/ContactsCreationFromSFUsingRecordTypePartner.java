package com.macfee.sampletest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.macfee.pages.SalesHomePage;
import com.macfee.pages.SalesLoginPage;
import com.macfee.pages.contacts.Contacts;
import com.macfee.pages.contacts.ContactsEdit;
import com.macfee.pages.contacts.NewContact;
  
import com.mcafee.framework.BaseClass;
import com.mcafee.framework.ConfigData;
import com.mcafee.framework.DataProviderClass;

  
  

public class ContactsCreationFromSFUsingRecordTypePartner extends BaseClass
{
	private static SalesLoginPage salesLoginPage;
	private static SalesHomePage salesHomePage;
	private static Contacts contactsTab;
	private static NewContact newContact;
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
		  
		System.out.println("Partner Contacts Creation in Sales Application");
	}
	
	@Test(dataProvider="contactCreatorByPartnerCreator", dataProviderClass=DataProviderClass.class)
	public void test(String...testData) throws Exception
	{
		contactsTab=salesHomePage.onClickContactTab();
		newContact=contactsTab.onClickNewButton();
		newContact.selectContactRecordType(testData[0]);	
		contactsEdit=newContact.onClickContinueBtn();
			
		//Partner 'Contact Information'
		contactsEdit.selectTitle(testData[1]);
		contactsEdit.putFirstName(testData[2]);
		contactsEdit.putLastName();
		contactsEdit.putPartnerContactAccountName(testData[3]);
		contactsEdit.putBusinessEmail();
		contactsEdit.selectPartnerContactStatus(testData[4]);
		contactsEdit.putBusinessPhone(testData[5]);
		contactsEdit.putBusinessPhoneExtension(testData[6]);
		contactsEdit.selectDesignationUnselected();
		contactsEdit.SelectDesignationsFWDBtn();
		contactsEdit.putJobTitle(testData[7]);
		contactsEdit.selectPartnerRole(testData[8]);
		contactsEdit.selectPartnerPersonaUnselectedMSL();
		contactsEdit.SelectPartnerPersonaFWDBtn();
		contactsEdit.putLinkedInProfile(testData[9]);
		contactsEdit.selectContactCurrencyDD(testData[10]);
		contactsEdit.selectPartnerContactLevelDD(testData[11]);
		contactsEdit.selectJobLevel(testData[12]);
		
		//Partner 'Additional Information'
		contactsEdit.selectPreferredContactMethodDD(testData[13]);
		contactsEdit.selectPreferredLanguage(testData[14]); 
		
		//Partner 'Address Information'
		contactsEdit.selectMailingCountry(testData[15]);
		contactsEdit.selectOtherCountry(testData[16]);
		contactsEdit.putMailingStreet(testData[17]);
		contactsEdit.putOtherStreet(testData[18]);
		contactsEdit.putMailingCity(testData[19]);
		contactsEdit.putOtherCity(testData[20]);
		contactsEdit.selectMailingStateProvince(testData[21]);
		contactsEdit.selectOtherStateProvince(testData[22]);
		contactsEdit.putMailingZipPostalCode(testData[23]);
		contactsEdit.putOtherZipPostalCode(testData[24]);
		
		//Partner 'System Access & Permissions (Partner Portal is "prerequisite" for all others)'
		contactsEdit.SelectPartnerPortalAccessRequestChkBox(testData[25]);
		//contactsEdit.selectPartnerPortalRequestStatusDD(testData[26]);
		contactsEdit.Select360DashboardAccessRequestChkBoxField(testData[26]);
		//contactsEdit.select360dashboardRequestStatusDD(testData[28]);
		contactsEdit.SelectMcAfeeSolutionsCenterAccessRequestChkBox(testData[27]);
		//contactsEdit.selectMcAfeeSolutionsCenterRequestStatusDD(testData[30]);
		contactsEdit.SelectMDFAccessRequestChkBox(testData[28]);
		//contactsEdit.selectMDFRequestStatusDD(testData[32]);
		contactsEdit.SelectPartnerLearningCenterAccessRequestChkBoxField(testData[29]);
		//contactsEdit.selectPartnerLearningCenterRequestStatusDD(testData[34]);
		contactsEdit.SelectRebatesAccessRequestChkBox(testData[30]);
		//contactsEdit.selectRebatesRequestStatusDD(testData[36]);
		contactsEdit.SelectSalesforcecomAccessRequestChkBox(testData[31]);
		//contactsEdit.selectSalesforcecomRequestStatusDD(testData[38]);
		contactsEdit.SelectServicePortalAccessRequestChkBox(testData[32]);
		//contactsEdit.selectServicePortalRequestStatusDD(testData[40]);
		contactsEdit.SelectAbilitytoExportPermissionRequestChkBox(testData[33]);
		//contactsEdit.selectAbilitytoExportRequestStatusDD(testData[42]);
		contactsEdit.SelectMakePartnerAdminPermissionRequestChkBox(testData[34]);
		//contactsEdit.selectMakePartnerAdminRequestStatusDD(testData[44]);
		contactsEdit.SelectiAssetMSRoyaltyToolAdminRequestChkBox(testData[35]);
		//contactsEdit.selectiAssetMSPRoyaltyToolAdminStatus(testData[46]);
		contactsEdit.SelectiAssetMSPRoyaltyToolReadOnlyRequestChkBox(testData[36]);
		//contactsEdit.selectiAssetMSPRoyaltyToolReadOnlyStatusDD(testData[48]);

		//Partner 'System Information'
		//contactsEdit.putsfTCAcceptanceDateTxt();
		//contactsEdit.putLegacyId();
		//contactsEdit.putLegacyCreated();
		contactsEdit.selectRelatedUser(testData[37]);
		contactsEdit.putRelatedUser(testData[38]);
		
		contactsEdit.onClickSave();
		String contactName=contactsTab.verifyContactCreated();
		Assert.assertNotNull(contactName, "Partner contact has been created in sales application");
		dataproviders.writeDataToExcel("./resources/TestData.xlsx", "ContactsCreationByPartner", contactName, i ,testData.length);
	} 
	
	@AfterMethod
	public void colno()
    {
		i++;
	}
}
