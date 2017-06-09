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
import com.macfee.pages.contacts.ContactSearch;
import com.macfee.pages.contacts.Contacts;
import com.macfee.pages.contacts.ContactsEdit;
import com.macfee.pages.leads.LeadEdit;
import com.macfee.pages.leads.Leads;
import com.macfee.pages.accounts.NewAccounts;
import com.macfee.pages.contacts.NewContact;
import com.macfee.pages.leads.NewLead;
import com.macfee.pages.Profile;
import com.macfee.pages.SalesHomePage;
import com.macfee.pages.SalesLoginPage;
import com.macfee.pages.SetUp;
import com.macfee.pages.opportunity.NewOpportunity;
import com.macfee.pages.opportunity.Opportunity;
import com.macfee.pages.opportunity.OpportunityAddProduct;
import com.macfee.pages.opportunity.OpportunityEdit;
import com.macfee.pages.opportunity.OpportunityProductSelection;
import com.macfee.pages.opportunity.OptyAssociatedPartner;
import com.macfee.pages.opportunity.OptyAssociatedPartnerEdit;
import com.macfee.pages.opportunity.OptyNewAssociatedPartner;
import com.macfee.pages.opportunity.OptyOwnershipEdit;
  
import com.mcafee.framework.BaseClass;
import com.mcafee.framework.ConfigData;
import com.mcafee.framework.DataProviderClass;

  
  

public class EndToEndSFTest extends BaseClass
{
		private static SalesLoginPage salesLoginPage;
		private static SalesHomePage salesHomePage;
		private static Accounts accountsTab;
		private static NewAccounts newAccount;
		private static AccountSearch accountSearch;
		private static AccountsEdit accountsEdit;
		private static Contacts contactsTab;
		private static NewContact newContact;
		private static ContactSearch contactSearch;
		private static ContactsEdit contactsEdit;
		private static Opportunity opportunityTab;
		private static NewOpportunity newOpportunity;
		private static OpportunityEdit opportunityEdit;
		private static OpportunityProductSelection opportunityProductSelection;
		private static OpportunityAddProduct opportunityAddProduct;
		private static OptyNewAssociatedPartner optyNewAssociatedPartner;
		private static OptyAssociatedPartnerEdit optyAssociatedPartnerEdit;
		private static OptyAssociatedPartner optyAssociatedPartner;
		private static OptyOwnershipEdit optyOwnershipEdit;
		private static Leads LeadTab;
		private static NewLead leadRecordtype;
		private static LeadEdit leadEdit;
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
		
		@BeforeMethod
		public void beforeMethod1()
		{
			salesHomePage.globalSearch(ConfigData.TESTUSERNAME);
			salesHomePage.selectUser();
			salesHomePage.onClickUserActionMenu();
			salesHomePage.editUserRoleProfile(ConfigData.TESTUSERROLES, ConfigData.TESTTERRITORYUSERPROFILE);
			salesHomePage.onClickLoginBtn();
		}
		
		@Test(dataProvider="AccountCreatorUsingByDraftEndCustomer", dataProviderClass=DataProviderClass.class)
		public void test1(String...testData) throws Exception
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
		public void colno1()
	    {
			i++;
		}
		
		@BeforeMethod
		public void beforeMethod2()
		{
			salesHomePage.globalSearch(ConfigData.TESTUSERNAME);
			salesHomePage.selectUser();
			salesHomePage.onClickUserActionMenu();
			salesHomePage.editUserRoleProfile(ConfigData.TESTUSERROLES, ConfigData.TESTTERRITORYUSERPROFILE);
			salesHomePage.onClickLoginBtn();
		}
		
		@Test(dataProvider="AccountCreatorUsingByEndCustomer",dataProviderClass=DataProviderClass.class)
		public void test2(String...testData) throws Exception
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
			accountsEdit.selectCustomerAccountGroup(testData[6]);
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
			accountsEdit.onClickSave();
			String accountName=accountsTab.verifyAccountCreated();
			Assert.assertNotNull(accountName, "End Customer Account has been created in sales application");
			dataproviders.writeDataToExcel("./resources/TestData.xlsx", "AccountsCreationsByEndCustomer", accountName, i ,testData.length);
		}
		
		@AfterMethod
		public void colno2()
	    {
			i++;
		}
		
		@BeforeMethod
		public void beforeMethod3()
		{
			salesHomePage.globalSearch(ConfigData.TESTUSERNAME);
			salesHomePage.selectUser();
			salesHomePage.onClickUserActionMenu();
			salesHomePage.editUserRoleProfile(ConfigData.TESTUSERROLES, ConfigData.TESTPCTUSERPROFILES);
			salesHomePage.onClickLoginBtn();
		}
		
		@Test(dataProvider="AccountCreatorUsingByCountry", dataProviderClass=DataProviderClass.class)
		public void test3(String...testData) throws Exception
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
			accountsEdit.putCity(testData[11]);
			accountsEdit.selectState(testData[12]);
			accountsEdit.putZip(testData[13]);
			accountsEdit.putPhone(testData[14]);
			accountsEdit.putFax(testData[15]);
			accountsEdit.putWebsite(testData[16]);
			//System Information
			accountsEdit.selectAccountCurrency(testData[17]);			
			accountsEdit.onClickSave();
			String accountName=accountsTab.verifyAccountCreated();
			Assert.assertNotNull(accountName, "Partner Account(Country) has been created in sales application");
			dataproviders.writeDataToExcel("./resources/TestData.xlsx", "AccountsCreationsByCountry", accountName, i ,testData.length);
		} 
		
		@AfterMethod
		public void colno3()
	    {
			i++;
		}
		
		@BeforeMethod
		public void beforeMethod4()
		{
			salesHomePage.globalSearch(ConfigData.TESTUSERNAME);
			salesHomePage.selectUser();
			salesHomePage.onClickUserActionMenu();
			salesHomePage.editUserRoleProfile(ConfigData.TESTUSERROLES, ConfigData.TESTPCTUSERPROFILES);
			salesHomePage.onClickLoginBtn();
		}
		
		@Test(dataProvider="AccountCreatorUsingByNonCountry", dataProviderClass=DataProviderClass.class)
		public void test4(String...testData) throws Exception
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
			accountsEdit.putCity(testData[10]);
			accountsEdit.selectState(testData[11]);
			accountsEdit.putZip(testData[12]);
			accountsEdit.putPhone(testData[13]);
			accountsEdit.putFax(testData[14]);
			accountsEdit.onClickSave();
			String accountNameByNonCountry=accountsTab.verifyAccountCreated();
			Assert.assertNotNull(accountNameByNonCountry, "Partner Account (Non-Country) has been created in sales application");
			dataproviders.writeDataToExcel("./resources/TestData.xlsx", "AccountsCreationsByNonCountry", accountNameByNonCountry, i ,testData.length);
		} 
		
		@AfterMethod
		public void colno4()
	    {
			i++;
		}
		
		@BeforeMethod
		public void beforeMethod5()
		{
			salesHomePage.globalSearch(ConfigData.TESTUSERNAME);
			salesHomePage.selectUser();
			salesHomePage.onClickUserActionMenu();
			salesHomePage.editUserRoleProfile(ConfigData.TESTUSERROLES, ConfigData.TESTTERRITORYUSERPROFILE);
			salesHomePage.onClickLoginBtn();
		}
		
		@Test(dataProvider="contactCreatorByEndCustomer",dataProviderClass=DataProviderClass.class)
		public void test5(String...testData) throws Exception
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
			contactsEdit.selectPreferredLanguage(testData[28]);
			contactsEdit.onClickSave();
			String contactName=contactsTab.verifyContactCreated();
			Assert.assertNotNull(contactName, "End Customer Contact has been created in sales application");
			dataproviders.writeDataToExcel("./resources/TestData.xlsx", "ContactsCreationByEndCustomer", contactName, i ,testData.length);
		}
		
		@AfterMethod
		public void colno5()
	    {
			i++;
		}
		
		@BeforeMethod
		public void beforeMethod6()
		{
			salesHomePage.globalSearch(ConfigData.TESTUSERNAME);
			salesHomePage.selectUser();
			salesHomePage.onClickUserActionMenu();
			salesHomePage.editUserRoleProfile(ConfigData.TESTUSERROLES, ConfigData.TESTPCTUSERPROFILES);
			salesHomePage.onClickLoginBtn();
		}
		
		@Test(dataProvider="contactCreatorByPartnerCreator", dataProviderClass=DataProviderClass.class)
		public void test6(String...testData) throws Exception
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
			contactsEdit.SelectPartnerPortalAccessRequestChkBox(testData[25]);
			contactsEdit.Select360DashboardAccessRequestChkBoxField(testData[26]);
			contactsEdit.SelectMcAfeeSolutionsCenterAccessRequestChkBox(testData[27]);
			contactsEdit.SelectMDFAccessRequestChkBox(testData[28]);
			contactsEdit.SelectPartnerLearningCenterAccessRequestChkBoxField(testData[29]);
			contactsEdit.SelectRebatesAccessRequestChkBox(testData[30]);
			contactsEdit.SelectSalesforcecomAccessRequestChkBox(testData[31]);
			contactsEdit.SelectServicePortalAccessRequestChkBox(testData[32]);
			contactsEdit.SelectAbilitytoExportPermissionRequestChkBox(testData[33]);
			contactsEdit.SelectMakePartnerAdminPermissionRequestChkBox(testData[34]);
			contactsEdit.SelectiAssetMSRoyaltyToolAdminRequestChkBox(testData[35]);
			contactsEdit.SelectiAssetMSPRoyaltyToolReadOnlyRequestChkBox(testData[36]);
			contactsEdit.selectRelatedUser(testData[37]);
			contactsEdit.putRelatedUser(testData[38]);
			contactsEdit.onClickSave();
			String contactName=contactsTab.verifyContactCreated();
			Assert.assertNotNull(contactName, "Partner contact has been created in sales application");
			dataproviders.writeDataToExcel("./resources/TestData.xlsx", "ContactsCreationByPartner", contactName, i ,testData.length);
		} 
		
		@AfterMethod
		public void colno6()
	    {
			i++;
		}
		
		@BeforeMethod
		public void beforeMethod7()
		{
			salesHomePage.globalSearch(ConfigData.TESTUSERNAME);
			salesHomePage.selectUser();
			salesHomePage.onClickUserActionMenu();
			salesHomePage.editUserRoleProfile(ConfigData.TESTUSERROLES, ConfigData.TESTSALESREPAMUSERPROFILE);
			salesHomePage.onClickLoginBtn();
		}
		
		@Test(dataProvider="OpportunityCreatorByStandard", dataProviderClass=DataProviderClass.class)
		public void test7(String...testData) throws Exception
		{
			opportunityTab =  salesHomePage.onClickOpportunityTab();
			newOpportunity = opportunityTab.onClickNewButton();
			newOpportunity.selectOpportunityRecordType(testData[0]);
			opportunityEdit = newOpportunity.onClickContinue();
			opportunityEdit.putOpportunityName();
			opportunityEdit.putAccountName(testData[1]);
			opportunityEdit.putProbability(testData[2]);
			opportunityEdit.selectOpportunityType(testData[3]);
			opportunityEdit.selectStage(testData[4]);
			opportunityEdit.selectForecastCategory(testData[5]);
			opportunityEdit.putCloseDate();
			opportunityEdit.putDealAmount(testData[6]);
			opportunityEdit.putUpsideAmount(testData[7]);
			opportunityEdit.selectOpportunityCurrency(testData[8]);
			opportunityEdit.onClickSave();
			String opportunityName = opportunityTab.verifyOpportunityCreated();
			Assert.assertNotNull(opportunityName, "Opportunity Created in Sales Application");
			dataproviders.writeDataToExcel("./resources/TestData.xlsx", "OpportunityCreationByStandard", opportunityName, i ,testData.length);
		} 
		
		@AfterMethod
		public void colno7()
	    {
			i++;
		}
		
		@BeforeMethod
		public void beforeMethod8()
		{
			salesHomePage.globalSearch(ConfigData.TESTUSERNAME);
			salesHomePage.selectUser();
			salesHomePage.onClickUserActionMenu();
			salesHomePage.editUserRoleProfile(ConfigData.TESTUSERROLES, ConfigData.TESTSALESREPAMUSERPROFILE);
			salesHomePage.onClickLoginBtn();
		}
		
		@Test(dataProvider="OpportunityCreatorAddPartner", dataProviderClass=DataProviderClass.class)
		public void test8(String...testData) throws Exception
		{
			opportunityTab=salesHomePage.onClickOpportunityTab();
			newOpportunity=opportunityTab.onClickNewButton();
			newOpportunity.selectOpportunityRecordType(testData[0]);
			opportunityEdit=newOpportunity.onClickContinue();
			opportunityEdit.putOpportunityName();
			opportunityEdit.putAccountName(testData[1]);
			opportunityEdit.putProbability(testData[2]);
			opportunityEdit.selectOpportunityType(testData[3]);
			opportunityEdit.selectStage(testData[4]);
			opportunityEdit.selectForecastCategory(testData[5]);
			opportunityEdit.putCloseDate();
			opportunityEdit.putDealAmount(testData[6]);
			opportunityEdit.putUpsideAmount(testData[7]);
			opportunityEdit.selectOpportunityCurrency(testData[8]);
			opportunityEdit.onClickSave();
			String opportunityName=opportunityTab.verifyOpportunityCreated();
			//Add Partner to Opportunity created
			//fetch the owner name
			String opportunityOwnerName=opportunityTab.fetchOpportunityOwnerName();
			System.out.println(opportunityOwnerName);
			//Logout from current user
			salesHomePage=opportunityTab.onClickLogoutButton();
			System.out.println("Logout successful");
			//Login as Opty owner
			salesHomePage.globalSearch(opportunityOwnerName);
			salesHomePage.selectUser();
			salesHomePage.onClickUserActionMenu();
			salesHomePage.onClickLoginBtn();
			System.out.println("Logged in as "+opportunityOwnerName);
			//Search for current opty
			salesHomePage.globalSearch(opportunityName);
			salesHomePage.selectOpty();
			//opportunityTab=salesHomePage.onClickOpportunityTab();
			System.out.println("Search for Opty name with Opty owner name");
			//Add product to the current opty
			opportunityProductSelection=opportunityTab.onClickAddProduct();
			opportunityProductSelection.selectOptyProductSelect1ChkBoxField();
			opportunityProductSelection.selectOptyProductSelect2ChkBoxField();
			opportunityAddProduct=opportunityProductSelection.onClickSelect();
			opportunityAddProduct.putOptyAddProductUnitPriceTxtField1(testData[9]);
			opportunityAddProduct.putOptyAddProductQuantityTxtField1(testData[11]);
			opportunityAddProduct.putOptyAddProductDescriptionTxtField1(testData[13]);
			opportunityAddProduct.putOptyAddProductUnitPriceTxtField2(testData[10]);
			opportunityAddProduct.putOptyAddProductQuantityTxtField2(testData[12]);
			opportunityAddProduct.putOptyAddProductDescriptionTxtField2(testData[14]);
			opportunityAddProduct.onClickSave();
			//logout and perform operation using admin login
			salesHomePage=opportunityTab.onClickLogoutButton();
			System.out.println("Logout successful");
			salesHomePage.globalSearch(opportunityName);
			salesHomePage.selectOpty();
			//Add partner to the current opty
			/*optyNewAssociatedPartner=opportunityTab.onClickNewAssociatedPartner();
			optyNewAssociatedPartner.selectAssociatedPartnerRecordType(testData[0]);
			optyAssociatedPartnerEdit=optyNewAssociatedPartner.onClickContinue();
			optyAssociatedPartnerEdit.putOptyPartnerAccountTxtField(testData[15]);
			optyAssociatedPartner=optyAssociatedPartnerEdit.onClickSave();
			String OpportunityName1 = optyAssociatedPartner.fetchOpportunityName();
			
			if(OpportunityName1 == opportunityName)
			{
				System.out.println("Partner linked to correct oppotunity");
			}*/
			
			Assert.assertNotNull(opportunityName, "Opportunity Created in Sales Application");
			dataproviders.writeDataToExcel("./resources/TestData.xlsx", "OptyCreationAddPartner", opportunityName, i ,testData.length);
			dataproviders.writeDataToExcel("./resources/TestData.xlsx", "OptyCreationAddPartner", opportunityOwnerName, i ,testData.length+1);
		} 
		
		@AfterMethod
		public void colno8()
	    {
			i++;
		}
		
		@BeforeMethod
		public void beforeMethod9()
		{
			salesHomePage.globalSearch(ConfigData.TESTUSERNAME);
			salesHomePage.selectUser();
			salesHomePage.onClickUserActionMenu();
			salesHomePage.editUserRoleProfile(ConfigData.TESTUSERROLES, ConfigData.TESTLDRUSERPROFILE);
			salesHomePage.onClickLoginBtn();
		}
		
		@Test(dataProvider="LeadCreatorUsingRecordTypeOCC", dataProviderClass=DataProviderClass.class)
		public void test9(String...testData) throws Exception
		{
			LeadTab=salesHomePage.onClickLeadTab();
			leadRecordtype=LeadTab.onClickNew();
			leadRecordtype.selectLeadRecordGroup(testData[0]);
			leadEdit=leadRecordtype.onClickContinueBtn();
			leadEdit.selectLeadCountryType(testData[1]);
			leadEdit.putLeadFirstName(testData[2]);
			leadEdit.putLeadLastName();
			leadEdit.putLeadCity(testData[3]);
			leadEdit.putLeadEmail();
			leadEdit.putLeadBusinessPhone(testData[4]);
			leadEdit.putLeadCompanyTextField(testData[5]);
			leadEdit.putLeadCloseDateTextField();
			leadEdit.selectLeadRoutingType(testData[6]);
			leadEdit.SelectLeadSaveBtnField();
			String leadName=LeadTab.verifyLeadCreated();
			Assert.assertNotNull(leadName, "OCC Lead has been created in sales application");
			dataproviders.writeDataToExcel("./resources/TestData.xlsx", "LeadCreationByOCC", leadName, i ,testData.length);
		} 
		
		@AfterMethod
		public void colno9()
	    {
			i++;
		}
		
		@BeforeMethod
		public void beforeMethod10()
		{
			salesHomePage.globalSearch(ConfigData.TESTUSERNAME);
			salesHomePage.selectUser();
			salesHomePage.onClickUserActionMenu();
			salesHomePage.editUserRoleProfile(ConfigData.TESTUSERROLES, ConfigData.TESTLDRUSERPROFILE);
			salesHomePage.onClickLoginBtn();
		}
		
		@Test(dataProvider="LeadCreatorUsingRecordTypeSalesLead", dataProviderClass=DataProviderClass.class)
		public void test10(String...testData) throws Exception
		{
			LeadTab = salesHomePage.onClickLeadTab();
			leadRecordtype = LeadTab.onClickNew();
			leadRecordtype.selectLeadRecordGroup(testData[0]);
			leadEdit = leadRecordtype.onClickContinueBtn();
			leadEdit.selectLeadCountryType(testData[1]);
			leadEdit.putLeadFirstName(testData[2]);
			leadEdit.putLeadLastName();
			leadEdit.putLeadCity(testData[3]);
			leadEdit.putLeadEmail();
			leadEdit.putLeadBusinessPhone(testData[4]);
			leadEdit.selectLeadProductInterestsUnselected();
			Thread.sleep(2000);
			leadEdit.getLeadProductInterestsRightArrowBtnField();
			leadEdit.putLeadContactTextField(testData[5]);
			leadEdit.putLeadAccountTextField(testData[6]);
			leadEdit.putLeadCloseDateTextField();
			leadEdit.putLeadCompanyTextField(testData[7]);
			leadEdit.SelectLeadSaveBtnField();
			String leadName = LeadTab.verifyLeadCreated();
			Assert.assertNotNull(leadName, "Sales Lead has been created in sales application");
			dataproviders.writeDataToExcel("./resources/TestData.xlsx", "LeadCreationBySalesLead", leadName, i ,testData.length);
		} 
		
		@AfterMethod
		public void colno10()
	    {
			i++;
		}
		
		@AfterClass
		public void testUserLogout()
		{	
			try {
					salesHomePage = salesHomePage.onClickTopRightLogoutButton();
				} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}	
		}
}
