package com.macfee.sampletest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
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
import com.relevantcodes.extentreports.LogStatus;

/**
*
* @author Magesh Kumar
*
*/

public class UserOptyCreationSalesAddProducts extends BaseClass
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
	public void User_Opportunities_Creation_From_Sales_Add_Products(String...testData) throws Exception
	{
		String opportunityName = "NULL";
		
		try
		{
			opportunityTab=salesHomePage.onClickOpportunityTab();
			newOpportunity=opportunityTab.onClickNewButton();
			newOpportunity.selectOpportunityRecordType(testData[0]);
			opportunityEdit=newOpportunity.onClickContinue();
			String opportunityName1=opportunityEdit.putOpportunityName();
			opportunityEdit.putAccountName(testData[1]);
			//opportunityEdit.putProbability(testData[2]);
			opportunityEdit.selectOpportunityType(testData[3]);
			opportunityEdit.selectStage(testData[4]);
			opportunityEdit.selectForecastCategory(testData[5]);
			opportunityEdit.putCloseDate();
			opportunityEdit.putDealAmount(testData[6]);
			opportunityEdit.putUpsideAmount(testData[7]);
			opportunityEdit.selectOpportunityCurrency(testData[8]);
			opportunityEdit.onClickSave();
			opportunityName=opportunityTab.verifyOpportunityCreated();
			
			if (opportunityName1.equals(opportunityName))
			{
			System.out.println("Correct opportunity created");
			extentTest.log(LogStatus.PASS, " Opportunity created succesfully for Opty type " +testData[3]+ " : " + opportunityName);
			dataproviders.writeDataToExcel("./resources/TestData.xlsx", "OptyCreationAddPartner", opportunityName, i ,testData.length);
			}
		}
		catch (Exception e)
		{
			System.out.println("Opportunity creation failed");
			extentTest.log(LogStatus.FAIL, " Opportunity creation failed with error :" + e);
			Assert.fail(" Opportunity creation failed with error :" + e);
		}
		
		try
		{
			if (testData[3].equals("New Business"))
			{
				//Add Product to Opportunity created
				//fetch the owner name
				String opportunityOwnerName=opportunityTab.fetchOpportunityOwnerName();
				System.out.println(opportunityOwnerName);
				
				//Logout from current user
				//salesHomePage=opportunityTab.onClickLogoutButton();
				System.out.println("Logout successful");
				
				//Login as Opty owner
				salesHomePage.globalSearch(opportunityOwnerName);
				salesHomePage.selectUser();
				salesHomePage.onClickUserActionMenu();
				salesHomePage.onClickLoginBtn();
				System.out.println("Logged in as "+opportunityOwnerName);
				Thread.sleep(5000);
				
				//Search for current opty
				salesHomePage.globalSearch(opportunityName);
				salesHomePage.selectOpty();
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
				System.out.println("Added Product to opportunity created successfully");
				extentTest.log(LogStatus.PASS, "Added Product to opportunity created :" + opportunityName);	
				dataproviders.writeDataToExcel("./resources/TestData.xlsx", "OptyCreationAddPartner", opportunityOwnerName, i ,testData.length+1);
				
				//Logout and login as default profile as a part of clean up
				salesHomePage=opportunityTab.onClickLogoutButton();
				System.out.println("Logout successful");
				salesHomePage.globalSearch(ConfigData.TESTUSERNAME);
				salesHomePage.selectUser();
				salesHomePage.onClickUserActionMenu();
				salesHomePage.editUserRoleProfile(ConfigData.TESTUSERROLES, ConfigData.TESTSALESREPAMUSERPROFILE);
				//sfTestUserRole=EMEA Geo Rep SEUR
				//PCTUserProfile=Custom: Sales Rep/AM
				salesHomePage.onClickLoginBtn();
			}
		}
		catch (Exception e)
		{
			System.out.println("Add Products to Opportunity created failed");
			extentTest.log(LogStatus.FAIL, "Add Products to Opportunity created failed with error :" + e);
			Assert.fail("Add Products to Opportunity created failed with error :" + e);
		}
	} 
	
	@AfterMethod
	public void colno()
    {
		i++;
	}
}