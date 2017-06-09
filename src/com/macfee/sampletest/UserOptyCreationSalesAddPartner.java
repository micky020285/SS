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
* @author Magesh
*
*/

public class UserOptyCreationSalesAddPartner extends BaseClass
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
		salesHomePage.editUserRoleProfile(ConfigData.TESTUSERROLES, ConfigData.TESTPCTUSERPROFILES);
		//sfTestUserRole=EMEA Geo Rep SEUR
		//PCTUserProfile=Custom: Sales Rep/AM
		salesHomePage.onClickLoginBtn();
		
	}
	
	@Test(dataProvider="OpportunityCreatorAddPartner", dataProviderClass=DataProviderClass.class)
	public void User_Opportunities_Creation_From_Sales_Add_Partner(String...testData) throws Exception
	{
		String opportunityName = "NULL";
		try
		{
			opportunityTab=salesHomePage.onClickOpportunityTab();
			opportunityEdit=opportunityTab.onClickNewButtonPCT();
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
				//fetch the owner name
				String opportunityOwnerName=opportunityTab.fetchOpportunityOwnerName();
				System.out.println(opportunityOwnerName);
			
				//Add partner to the current opty
				optyAssociatedPartnerEdit=opportunityTab.onClickNewAssociatedPartner();
				optyAssociatedPartnerEdit.putOptyPartnerAccountTxtField(testData[15]);
				optyAssociatedPartner=optyAssociatedPartnerEdit.onClickSave();
				String opportunityName2 = optyAssociatedPartner.fetchOpportunityName();
		
				if (opportunityName2.equals(opportunityName))
				{
					System.out.println("Partner linked to correct oppotunity");
					extentTest.log(LogStatus.PASS, " Partner added to Opportunity succesfully :" + opportunityName +" - "+ opportunityOwnerName );
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("Add Partner to Opportunity failed");
			extentTest.log(LogStatus.FAIL, "Add Partner to Opportunity failed with error :" + e);
			Assert.fail("Add Partner to Opportunity failed with error :" + e);
		}
		
		
	} 
	
	@AfterMethod
	public void colno()
    {
		i++;
	}
}
