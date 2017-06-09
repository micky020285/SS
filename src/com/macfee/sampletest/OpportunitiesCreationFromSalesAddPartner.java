package com.macfee.sampletest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.macfee.pages.SalesHomePage;
import com.macfee.pages.SalesLoginPage;
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

  
  

public class OpportunitiesCreationFromSalesAddPartner extends BaseClass
{
	private static SalesLoginPage salesLoginPage;
	private static SalesHomePage salesHomePage;
	private static Opportunity opportunityTab;
	private static NewOpportunity newOpportunity;
	private static OpportunityEdit opportunityEdit;
	private static OpportunityProductSelection opportunityProductSelection;
	private static OpportunityAddProduct opportunityAddProduct;
	private static OptyNewAssociatedPartner optyNewAssociatedPartner;
	private static OptyAssociatedPartnerEdit optyAssociatedPartnerEdit;
	private static OptyAssociatedPartner optyAssociatedPartner;
	private static OptyOwnershipEdit optyOwnershipEdit;
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
		  
		System.out.println("Opportunity Creation in Sales Application");
		salesHomePage.globalSearch(ConfigData.TESTUSERNAME);
		salesHomePage.selectUser();
		salesHomePage.onClickUserActionMenu();
		salesHomePage.editUserRoleProfile(ConfigData.TESTUSERROLES, ConfigData.TESTSALESREPAMUSERPROFILE);
		//sfTestUserRole=EMEA Geo Rep SEUR
		//PCTUserProfile=Custom: Sales Rep/AM
		salesHomePage.onClickLoginBtn();
	}
	
	@Test(dataProvider="OpportunityCreatorAddPartner", dataProviderClass=DataProviderClass.class)
	public void test(String...testData) throws Exception
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
		//opportunityTab.clickEdit();
		
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
		String OpportunityName1 = optyAssociatedPartner.fetchOpportunityName();*/
		
		/*if (OpportunityName1 == opportunityName)
		{
			System.out.println("Partner linked to correct oppotunity");
		}
		*/
		//Assert.assertNotNull(opportunityName, "Opportunity Created in Sales Application");
		dataproviders.writeDataToExcel("./resources/TestData.xlsx", "OptyCreationAddPartner", opportunityName, i ,testData.length);
		dataproviders.writeDataToExcel("./resources/TestData.xlsx", "OptyCreationAddPartner", opportunityOwnerName, i ,testData.length+1);
	} 
	
	@AfterMethod
	public void colno()
    {
		i++;
	}
}
