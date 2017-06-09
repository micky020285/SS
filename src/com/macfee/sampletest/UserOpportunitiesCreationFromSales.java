package com.macfee.sampletest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.macfee.pages.SalesHomePage;
import com.macfee.pages.SalesLoginPage;
import com.macfee.pages.opportunity.NewOpportunity;
import com.macfee.pages.opportunity.Opportunity;
import com.macfee.pages.opportunity.OpportunityEdit;
  
import com.mcafee.framework.BaseClass;
import com.mcafee.framework.ConfigData;
import com.mcafee.framework.DataProviderClass;

/**
*
* @author Balamurugan
*
*/

public class UserOpportunitiesCreationFromSales extends BaseClass
{
	private static SalesLoginPage salesLoginPage;
	private static SalesHomePage salesHomePage;
	private static Opportunity opportunityTab;
	private static NewOpportunity newOpportunity;
	private static OpportunityEdit opportunityEdit;
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
	
	@Test(dataProvider="OpportunityCreatorByStandard", dataProviderClass=DataProviderClass.class)
	public void test(String...testData) throws Exception
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
		//opportunityEdit.selectRoutetoMarketDDField(testData[7]);
		opportunityEdit.putDealAmount(testData[6]);
		opportunityEdit.putUpsideAmount(testData[7]);
		
		/*
		opportunityEdit.selectDealRegistrationStatus(testData[10]);
		opportunityEdit.putWinLossComments(testData[11]);
		opportunityEdit.selectHidePartnerDealAmount(testData[12]);
		opportunityEdit.putPartnerDealAmountTxtField(testData[13]);
		opportunityEdit.selectPlanningOpportunityToUpdateFlagChkBox(testData[14]);
		opportunityEdit.putUpfrontAmountTxtField(testData[15]);
		opportunityEdit.putMSPBookedAmountTxtField(testData[16]);
		opportunityEdit.selectLengthofTermDDField(testData[17]);
		opportunityEdit.putLeadDealAmountTxtField(testData[18]);
		opportunityEdit.selectOpportunityCurrency(testData[19]);
		opportunityEdit.putLeadSourceDDField(testData[20]);
		opportunityEdit.putLeadIDTxtField(testData[21]);
		opportunityEdit.putNextStepTxtField(testData[22]);
		opportunityEdit.putCriticalSuccessFactorsTxtField(testData[23]);
		opportunityEdit.putSalesCommentTxtField(testData[24]);
		opportunityEdit.putCompellingEventTxtField(testData[25]);
		opportunityEdit.putManagerCommentTxtField(testData[26]);
		opportunityEdit.putDescribeWinCloseStrategyTxtField(testData[27]);
		opportunityEdit.putCompetitiveAdvantageTxtField(testData[28]);
		opportunityEdit.putReasonforChangeinCloseDateTxtField(testData[29]);
		opportunityEdit.putCompetitiveDisadvantageTxtField(testData[30]);
		opportunityEdit.putReasonforChangeinDealSizeTxtField(testData[31]);
		opportunityEdit.putCustomerPainPointsTxtField(testData[32]);
		opportunityEdit.putSOWDDField(testData[33]);
		opportunityEdit.putCustomerBusinessNeedTxtField(testData[34]);
		opportunityEdit.putPOCDDField(testData[35]);
		opportunityEdit.putRedFlagsTxtField(testData[36]);
		opportunityEdit.putRFPDDField(testData[37]);
		opportunityEdit.putProfessionalServicesDDField(testData[38]);
		opportunityEdit.putDeleteStatusDDField(testData[39]);
		opportunityEdit.putDeleteRequestReasonTxtField(testData[40]);
		//opportunityEdit.putSiebelIDTxtField(testData[6]);
		opportunityEdit.selectExcludeterritoryassignmentfilterlogicChkBox(testData[41]);
		opportunityEdit.putWonLostReasonUnselectedMSLField();
		opportunityEdit.putWonLostReasonFWDBtnField();
		opportunityEdit.putWonLostReasonBKDBtnField();
		opportunityEdit.putWonLostReasonSelectedMSLField();
		opportunityEdit.putLeadProductInterestUnselectedMSLField();
		opportunityEdit.putLeadProductInterestFWDBtnField();
		opportunityEdit.putLeadProductInterestBKDBtnField();
		opportunityEdit.putLeadProductInterestSelectedMSLField();
		opportunityEdit.putProfServCustomerTrainingIncludedUnselectedMSLField();
		opportunityEdit.putProfServCustomerTrainingIncludedFWDBtnField();
		opportunityEdit.putProfServCustomerTrainingIncludedBKDBtnField();
		opportunityEdit.putProfServCustomerTrainingIncludedSelectedMSLField();
		*/
		
		opportunityEdit.selectOpportunityCurrency(testData[8]);
		opportunityEdit.onClickSave();
		String opportunityName = opportunityTab.verifyOpportunityCreated();
		//Assert.assertNotNull(opportunityName, "Opportunity Created in Sales Application");
		dataproviders.writeDataToExcel("./resources/TestData.xlsx", "OpportunityCreationByStandard", opportunityName, i ,testData.length);
	} 
	
	@AfterMethod
	public void colno()
    {
		i++;
	}
}
