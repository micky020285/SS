package com.macfee.sampletest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.macfee.pages.leads.LeadEdit;
import com.macfee.pages.leads.Leads;
import com.macfee.pages.leads.NewLead;
import com.macfee.pages.SalesHomePage;
import com.macfee.pages.SalesLoginPage;
  
import com.mcafee.framework.BaseClass;
import com.mcafee.framework.ConfigData;
import com.mcafee.framework.DataProviderClass;
import com.relevantcodes.extentreports.LogStatus;
  

public class UserLeadCreationFromSFUsingRecordTypeSalesLead extends BaseClass
{
	private static SalesLoginPage salesLoginPage;
	private static SalesHomePage salesHomePage;
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
		  
		System.out.println("Sales Lead Creation in Sales Application");
		salesHomePage.globalSearch(ConfigData.TESTUSERNAME);
		salesHomePage.selectUser();
		salesHomePage.onClickUserActionMenu();
		salesHomePage.editUserRoleProfile(ConfigData.TESTUSERROLES, ConfigData.TESTLDRUSERPROFILE);
		//sfTestUserRole=EMEA Geo Rep SEUR
		//PCTUserProfile=Custom: LDR
		salesHomePage.onClickLoginBtn();
	}
		
	@Test(dataProvider="LeadCreatorUsingRecordTypeSalesLead", dataProviderClass=DataProviderClass.class)
	public void User_Lead_Creation_From_SF_Using_Record_Type_Sales_Lead(String...testData) throws Exception
	{
		try
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
		//leadEdit.selectLeadProductInterestsUnselected();
		//leadEdit.getLeadProductInterestsRightArrowBtnField();
		leadEdit.putLeadContactTextField(testData[5]);
		leadEdit.putLeadAccountTextField(testData[6]);
		leadEdit.putLeadCloseDateTextField();
		leadEdit.putLeadCompanyTextField(testData[7]);
		leadEdit.putLeadDealAmount(testData[8]);
		leadEdit.SelectLeadSaveBtnField();		
		
		Thread.sleep(3000);
		String leadName=leadEdit.verifyLeadCreated();
		Assert.assertNotNull(leadName, "Sales Lead has been created in sales application");
		extentTest.log(LogStatus.PASS, "Sales Lead Created succesfully :" + leadName);
		DataProviderClass.writeDataToExcel("./resources/TestData.xlsx", "LeadCreationBySalesLead", leadName, i ,testData.length);
		}
		catch (Exception e)
		{
			System.out.println("Lead creation failed");
			extentTest.log(LogStatus.FAIL, "Lead creation failed with error :" + e);
			Assert.fail("Lead creation failed with error :" + e);
		}
		try
		{
			
		Thread.sleep(3000);
		leadEdit.SelectsfLeadAddProductField();
		leadEdit.selectLeadProductInterest();
		leadEdit.SelectLeadProductRightArrowBtnField();
		leadEdit.SelectLeadProductOkBtn();
		leadEdit.SelectLeadProductSaveBtn();
		
		leadEdit.SelectLeadProductConvertBtn();
		String Opty=leadEdit.verifyOptyCreated();
	
		Assert.assertNotNull(Opty, "Opty has been created in sales application");
		extentTest.log(LogStatus.PASS, "Opty has been created in sales application succesfully :" + Opty);
		DataProviderClass.writeDataToExcel("./resources/TestData.xlsx", "LeadCreationBySalesLead", Opty, i ,testData.length+1);	
	
		}
		catch (Exception e)
		{
			System.out.println("Conversion of Lead to Opty failed");
			extentTest.log(LogStatus.FAIL, "Conversion of Lead to Opty failed with error :" + e);
			Assert.fail("Conversion of Lead to Opty failed with error :" + e);
		}
	} 
	
	@AfterMethod
	public void colno()
    {
		i++;
	}
}
