package com.macfee.sampletest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.mcafee.framework.DataProviderClass;
import com.macfee.pages.leads.LeadEdit;
import com.macfee.pages.leads.Leads;
import com.macfee.pages.leads.NewLead;
import com.macfee.pages.SalesHomePage;
import com.macfee.pages.SalesLoginPage;
import com.mcafee.framework.BaseClass;
import com.mcafee.framework.ConfigData;
import com.mcafee.framework.DataProviderClass;
import com.relevantcodes.extentreports.LogStatus;

public class UserLeadCreationFromSFUsingRecordTypeOCC extends BaseClass
{
	private static SalesLoginPage salesLoginPage;
	private static SalesHomePage salesHomePage;
	private static Leads LeadTab;
	private static NewLead leadRecordtype;
	private static LeadEdit leadEdit;
	
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
		leadEdit.putLeadCompanyTextField(testData[5]);
		leadEdit.putLeadStreetTextField(testData[8]);
		leadEdit.putLeadZipTextField(testData[9]);
		leadEdit.selectLeadState(testData[10]);
		leadEdit.selectLeadRoutingType(testData[6]);
		leadEdit.putLeadDealAmount(testData[7]);
		leadEdit.putLeadCloseDateTextField();
		leadEdit.SelectLeadSaveBtnField();
		
		Thread.sleep(3000);
		String leadName=leadEdit.verifyLeadCreated();
		Thread.sleep(3000);
		
		leadEdit.SelectsfLeadAddProductField();
		leadEdit.selectLeadProductInterest();
		leadEdit.SelectLeadProductRightArrowBtnField();
		leadEdit.SelectLeadProductOkBtn();
		leadEdit.SelectLeadProductSaveBtn();
		
		leadEdit.SelectLeadProductConvertBtn();
		Thread.sleep(3000);
		leadEdit.selectLeadAccName();
		leadEdit.putLeadOptyNameTextField(testData[11]);
		leadEdit.selectLeadStatus();
		leadEdit.putLeadSubjectTextField(testData[12]);
		Thread.sleep(3000);
		leadEdit.SelectLeadProductConvertBtn();
		
		String Opty=leadEdit.verifyOptyCreated();
		leadEdit.driverreturn();
		Assert.assertNotNull(leadName, "OCC Lead has been created in sales application");
		if (leadName!=null) {
			extentTest.log(LogStatus.PASS, "OCC Lead Created succesfully :" + leadName);
		}
		DataProviderClass.writeDataToExcel("./resources/TestData.xlsx", "LeadCreationByOCC", leadName, i ,testData.length);
		DataProviderClass.writeDataToExcel("./resources/TestData.xlsx", "LeadCreationByOCC", Opty, i ,testData.length+1);	
	
	} 
	
	@AfterMethod
	public void colno()
    {
		i++;
	}
}
