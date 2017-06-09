package com.macfee.sampletest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.macfee.pages.SalesHomePage;
import com.macfee.pages.SalesLoginPage;
import com.macfee.pages.leads.LeadEdit;
import com.macfee.pages.leads.Leads;
import com.macfee.pages.leads.NewLead;
  
import com.mcafee.framework.BaseClass;
import com.mcafee.framework.ConfigData;
import com.mcafee.framework.DataProviderClass;

  
  

public class LeadCreationFromSFUsingRecordTypeOCC extends BaseClass
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
		  
		System.out.println("OCC Lead Creation in Sales Application");
		salesHomePage.globalSearch(ConfigData.TESTUSERNAME);
		salesHomePage.selectUser();
		salesHomePage.onClickUserActionMenu();
		salesHomePage.editUserRoleProfile(ConfigData.TESTUSERROLES, ConfigData.TESTLDRUSERPROFILE);
		//sfTestUserRole=EMEA Geo Rep SEUR
		//PCTUserProfile=Custom: LDR
		salesHomePage.onClickLoginBtn();
	}
	
	@Test(dataProvider="LeadCreatorUsingRecordTypeOCC", dataProviderClass=DataProviderClass.class)
	public void test(String...testData) throws Exception
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
		//leadEdit.putLeadContactTextField(testData[5]);
		//leadEdit.putLeadAccountTextField(testData[6]);
		leadEdit.putLeadCompanyTextField(testData[5]);
		leadEdit.putLeadCloseDateTextField();
		leadEdit.selectLeadRoutingType(testData[6]);
		leadEdit.SelectLeadSaveBtnField();
		String leadName=LeadTab.verifyLeadCreated();
		Assert.assertNotNull(leadName, "OCC Lead has been created in sales application");
		dataproviders.writeDataToExcel("./resources/TestData.xlsx", "LeadCreationByOCC", leadName, i ,testData.length);
	} 
	
	@AfterMethod
	public void colno()
    {
		i++;
	}
}
