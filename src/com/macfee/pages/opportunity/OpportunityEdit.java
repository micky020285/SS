package com.macfee.pages.opportunity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.mcafee.framework.AutomationHelper;
import com.mcafee.framework.PropertiesReader;

/**
*
* @author Balamurugan
*
*/

public class OpportunityEdit 
{
	private WebDriver driver;
	private PropertiesReader propObject;
	
	OpportunityEdit(WebDriver driver, PropertiesReader propObject) 
	{
		this.driver = driver;
		this.propObject=propObject;
	}
	
	public void verifyIfCaseEditPage() 
	{
		Assert.assertEquals(getSaveBtnField().isDisplayed(), true, "In New Opportunity Page");
	}
	
	public WebElement getOpportunityNameTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfOpportunityNameTxtField")), 10);
	}
	
	public WebElement getAccountNameTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfOpportunityAccountNameTxtField")), 10);
	}
	
	public WebElement getProbabilityTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfProbabilityTxtField")), 10);
	}
	
	public WebElement getOpportunityTypeDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfOpportunityTypeDDField")), 10);
	}
	
	public WebElement getRoutetoMarketDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfRoutetoMarketDDField")), 10);
	}
	
	public WebElement getStageDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfStageDDField")), 10);
	}
	
	public WebElement getForecastCategoryDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfForecastCategoryDDField")), 10);
	}
	
	public WebElement getCloseDateTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfCloseDateTxtField")), 10);
	}
	
	public WebElement getDealAmountTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfDealAmountTxtField")), 10);
	}
	
	public WebElement getDealRegistrationStatusDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfDealRegistrationStatusDDField")), 10);
	}
	
	public WebElement getUpsideAmountTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfUpsideAmountTxtField")), 10);
	}
	
	public WebElement getWonLostReasonUnselectedMSLField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfWonLostReasonUnselectedMSLField")), 10);
	}
	
	public WebElement getWonLostReasonFWDBtnField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfWonLostReasonFWDBtnField")), 10);
	}
	
	public WebElement getWonLostReasonBKDBtnField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfWonLostReasonBKDBtnField")), 10);
	}
	
	public WebElement getWonLostReasonSelectedMSLField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfWonLostReasonSelectedMSLField")), 10);
	}
	
	public WebElement getWinLossCommentsTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfWinLossCommentsTxtField")), 10);
	}
	
	public WebElement getHidePartnerDealAmountChkBox()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfHidePartnerDealAmountChkBox")), 10);
	}
	
	public WebElement getPartnerDealAmountTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfPartnerDealAmountTxtField")), 10);
	}
	
	public WebElement getPlanningOpportunityToUpdateFlagChkBox()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfPlanningOpportunityToUpdateFlagChkBox")), 10);
	}
	
	public WebElement getUpfrontAmountTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfUpfrontAmountTxtField")), 10);
	}
	
	public WebElement getMSPBookedAmountTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfMSPBookedAmountTxtField")), 10);
	}
	
	public WebElement getLengthofTermDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfLengthofTermDDField")), 10);
	}
	
	public WebElement getLeadDealAmountTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfLeadDealAmountTxtField")), 10);
	}
	
	public WebElement getOpportunityCurrencyDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfOpportunityCurrencyDDField")), 10);
	}
	
	public WebElement getLeadSourceDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfLeadSourceDDField")), 10);
	}
	
	public WebElement getLeadIDTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfLeadIDTxtField")), 10);
	}
	
	public WebElement getNextStepTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfNextStepTxtField")), 10);
	}
	
	public WebElement getCriticalSuccessFactorsTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfCriticalSuccessFactorsTxtField")), 10);
	}
	
	public WebElement getSalesCommentTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfSalesCommentTxtField")), 10);
	}
	
	public WebElement getCompellingEventTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfCompellingEventTxtField")), 10);
	}
	
	public WebElement getManagerCommentTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfManagerCommentTxtField")), 10);
	}
	
	public WebElement getDescribeWinCloseStrategyTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfDescribeWinCloseStrategyTxtField")), 10);
	}
	
	public WebElement getCompetitiveAdvantageTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfCompetitiveAdvantageTxtField")), 10);
	}
	
	public WebElement getReasonforChangeinCloseDateTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfReasonforChangeinCloseDateTxtField")), 10);
	}
	
	public WebElement getCompetitiveDisadvantageTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfCompetitiveDisadvantageTxtField")), 10);
	}
	
	public WebElement getReasonforChangeinDealSizeTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfReasonforChangeinDealSizeTxtField")), 10);
	}
	
	public WebElement getCustomerPainPointsTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfCustomerPainPointsTxtField")), 10);
	}
	
	public WebElement getSOWDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfSOWDDField")), 10);
	}
	
	public WebElement getCustomerBusinessNeedTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfCustomerBusinessNeedTxtField")), 10);
	}
	
	public WebElement getPOCDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfPOCDDField")), 10);
	}
	
	public WebElement getRedFlagsTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfRedFlagsTxtField")), 10);
	}
	
	public WebElement getRFPDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfRFPDDField")), 10);
	}

	public WebElement getProfessionalServicesDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfProfessionalServicesDDField")), 10);
	}

	public WebElement getDeleteStatusDDField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfDeleteStatusDDField")), 10);
	}
	
	public WebElement getDeleteRequestReasonTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfDeleteRequestReasonTxtField")), 10);
	}
	
	public WebElement getSiebelIDTxtField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfSiebelIDTxtField")), 10);
	}
	
	public WebElement getExcludeterritoryassignmentfilterlogicChkBox()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfExcludeterritoryassignmentfilterlogicChkBox")), 10);
	}
	
	public WebElement getLeadProductInterestUnselectedMSLField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfLeadProductInterestUnselectedMSLField")), 10);
	}
	
	public WebElement getLeadProductInterestFWDBtnField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfLeadProductInterestFWDBtnField")), 10);
	}
	
	public WebElement getLeadProductInterestBKDBtnField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfLeadProductInterestBKDBtnField")), 10);
	}
	
	public WebElement getLeadProductInterestSelectedMSLField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfLeadProductInterestSelectedMSLField")), 10);
	}
	
	public WebElement getProfServCustomerTrainingIncludedUnselectedMSLField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfProfServCustomerTrainingIncludedUnselectedMSLField")), 10);
	}
	
	public WebElement getProfServCustomerTrainingIncludedFWDBtnField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfProfServCustomerTrainingIncludedFWDBtnField")), 10);
	}
	
	public WebElement getProfServCustomerTrainingIncludedBKDBtnField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfProfServCustomerTrainingIncludedBKDBtnField")), 10);
	}
	
	public WebElement getProfServCustomerTrainingIncludedSelectedMSLField()
	{
		return AutomationHelper.findElement(driver, By.id(propObject.getData("sfProfServCustomerTrainingIncludedSelectedMSLField")), 10);
	}
	
	
	public WebElement getSaveBtnField()
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfSaveBtnField")), 10);
	}
	
	public WebElement getCancelBtnField() 
	{
		return AutomationHelper.findElement(driver, By.xpath(propObject.getData("sfCancelBtnField")), 10);
	}
	
	public String putOpportunityName()
	{
		Date datetime = new Date();
		String Opty_Name;
		String currentDate;
		currentDate = new SimpleDateFormat("MM_dd_yyyy_HH_mm_SS").format(datetime);
		Opty_Name = "Opty_Name_"+currentDate.toString();
		getOpportunityNameTxtField().sendKeys(Opty_Name);
		System.out.println("Opty Name is " + Opty_Name);
		return Opty_Name;
	}
	
	public void putAccountName(String accountName)
	{
		getAccountNameTxtField().sendKeys(accountName);
		System.out.println("Account Name is " + accountName);
	}
	
	public void putProbability(String probability) throws InterruptedException
	{
		getProbabilityTxtField().clear();
		Thread.sleep(2000);
		getProbabilityTxtField().sendKeys(probability);
		Thread.sleep(2000);
		getProbabilityTxtField().sendKeys(Keys.TAB);
		Thread.sleep(2000);
		System.out.println("Probability (%) is " + probability);
	}
		
	public void selectOpportunityType(String opportunityType)
	{
		Select dropdown= new Select(getOpportunityTypeDDField()); 
		dropdown.selectByVisibleText(opportunityType); 
		System.out.println("Opportunity type is " + opportunityType);
	}
	
	public void selectRoutetoMarketDDField(String RoutetoMarket)
	{
		Select dropdown= new Select(getRoutetoMarketDDField()); 
		dropdown.selectByVisibleText(RoutetoMarket); 
		System.out.println("Route to Market is " + RoutetoMarket);
	}
	
	public void selectStage(String stage)
	{
		Select dropdown= new Select(getStageDDField()); 
		dropdown.selectByVisibleText(stage); 
		System.out.println("Stage is " + stage);
	}
	
	public void selectForecastCategory(String forecastcategory)
	{
		Select dropdown= new Select(getForecastCategoryDDField()); 
		dropdown.selectByVisibleText(forecastcategory); 
		System.out.println("Forecast Category is " + forecastcategory);
	}
	
	public void putCloseDate()
	{
		String currentDate;
		Date date = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 30);
		currentDate = new SimpleDateFormat("MM/dd/yyyy").format(calendar.getTime());
		
		getCloseDateTxtField().sendKeys(currentDate);
		System.out.println("Close Date is " + currentDate);
	}
	
	public void putDealAmount(String dealAmount)
	{
		getDealAmountTxtField().sendKeys(dealAmount);
		System.out.println("Deal Amount is " + dealAmount);
	}
	
	public void putUpsideAmount(String UpsidedealAmount)
	{
		getUpsideAmountTxtField().sendKeys(UpsidedealAmount);
		System.out.println("Upside Deal Amount is " + UpsidedealAmount);
	}
	
	public void selectDealRegistrationStatus(String DealRegistrationStatus)
	{
		Select dropdown= new Select(getDealRegistrationStatusDDField()); 
		dropdown.selectByVisibleText(DealRegistrationStatus); 
		System.out.println("Deal Registration Status Category is " + DealRegistrationStatus);
	}
	
	public void putWinLossComments(String WinLossComments)
	{
		getWinLossCommentsTxtField().sendKeys(WinLossComments);
		System.out.println("Win Loss Comments is " + WinLossComments);
	}
	
	public void selectHidePartnerDealAmount(String HidePartnerDealAmount)
	{
		if (HidePartnerDealAmount == "True")
		{
			getHidePartnerDealAmountChkBox().click();
			System.out.println("Hide Partner Deal Amount is Selected");
		}
		else
		{
			System.out.println("Hide Partner Deal Amount is not Selected");
		}
	}
	
	public void putPartnerDealAmountTxtField(String PartnerDealAmount)
	{
		getPartnerDealAmountTxtField().sendKeys(PartnerDealAmount);
		System.out.println("Partner Deal Amount is " + PartnerDealAmount);
	}
	
	public void selectPlanningOpportunityToUpdateFlagChkBox(String PlanningOpportunityToUpdate)
	{
		if (Boolean.valueOf(PlanningOpportunityToUpdate) && !getPlanningOpportunityToUpdateFlagChkBox().isSelected())
		{
			getPlanningOpportunityToUpdateFlagChkBox().click();
			System.out.println("Planning Opportunity To Update is Selected");
		}
		else
		{
			System.out.println("Planning Opportunity To Update is not Selected");
		}
	}
	
	public void putUpfrontAmountTxtField(String UpfrontAmount)
	{
		getUpfrontAmountTxtField().sendKeys(UpfrontAmount);
		System.out.println("Upfront Amount is " + UpfrontAmount);
	}
	
	public void putMSPBookedAmountTxtField(String MSPBookedAmount)
	{
		getMSPBookedAmountTxtField().sendKeys(MSPBookedAmount);
		System.out.println("MSP Booked Amount is " + MSPBookedAmount);
	}
	
	public void selectLengthofTermDDField(String LengthofTerm)
	{
		Select dropdown= new Select(getLengthofTermDDField()); 
		dropdown.selectByVisibleText(LengthofTerm); 
		System.out.println("Route to Market is " + LengthofTerm);
	}
	
	public void putLeadDealAmountTxtField(String LeadDealAmount)
	{
		getLeadDealAmountTxtField().sendKeys(LeadDealAmount);
		System.out.println("Lead Deal Amount is " + LeadDealAmount);
	}
	
	public void selectOpportunityCurrency(String opportunitycurrency)
	{
		Select dropdown= new Select(getOpportunityCurrencyDDField()); 
		dropdown.selectByVisibleText(opportunitycurrency); 
		System.out.println("Opportunity Currency is " + opportunitycurrency);
	}
	
	public void putLeadSourceDDField(String LeadSource)
	{
		getLeadSourceDDField().sendKeys(LeadSource);
		System.out.println("Lead Source is " + LeadSource);
	}
	
	public void putLeadIDTxtField(String LeadID)
	{
		getLeadIDTxtField().sendKeys(LeadID);
		System.out.println("Lead ID is " + LeadID);
	}
	
	public void putNextStepTxtField(String NextStep)
	{
		getNextStepTxtField().sendKeys(NextStep);
		System.out.println("Next Step is " + NextStep);
	}
	
	public void putCriticalSuccessFactorsTxtField(String CriticalSuccessFactors)
	{
		getCriticalSuccessFactorsTxtField().sendKeys(CriticalSuccessFactors);
		System.out.println("Critical Success Factors is " + CriticalSuccessFactors);
	}
	
	public void putSalesCommentTxtField(String SalesComment)
	{
		getSalesCommentTxtField().sendKeys(SalesComment);
		System.out.println("Sales Comment is " + SalesComment);
	}
	
	public void putCompellingEventTxtField(String CompellingEvent)
	{
		getCompellingEventTxtField().sendKeys(CompellingEvent);
		System.out.println("Compelling Event is " + CompellingEvent);
	}
	
	public void putManagerCommentTxtField(String ManagerComment)
	{
		getManagerCommentTxtField().sendKeys(ManagerComment);
		System.out.println("Manager Comment is " + ManagerComment);
	}
	
	public void putDescribeWinCloseStrategyTxtField(String DescribeWinCloseStrategy)
	{
		getDescribeWinCloseStrategyTxtField().sendKeys(DescribeWinCloseStrategy);
		System.out.println("Describe Win/Close Strategy is " + DescribeWinCloseStrategy);
	}
	
	public void putCompetitiveAdvantageTxtField(String CompetitiveAdvantage)
	{
		getCompetitiveAdvantageTxtField().sendKeys(CompetitiveAdvantage);
		System.out.println("Describe Win/Close Strategy is " + CompetitiveAdvantage);
	}
	
	public void putReasonforChangeinCloseDateTxtField(String ReasonforChangeinCloseDate)
	{
		getReasonforChangeinCloseDateTxtField().sendKeys(ReasonforChangeinCloseDate);
		System.out.println("Reason for Change in Close Date is " + ReasonforChangeinCloseDate);
	}
	
	public void putCompetitiveDisadvantageTxtField(String CompetitiveDisadvantage)
	{
		getCompetitiveDisadvantageTxtField().sendKeys(CompetitiveDisadvantage);
		System.out.println("Competitive Disadvantage is " + CompetitiveDisadvantage);
	}
	
	public void putReasonforChangeinDealSizeTxtField(String ReasonforChangeinDealSize)
	{
		getReasonforChangeinDealSizeTxtField().sendKeys(ReasonforChangeinDealSize);
		System.out.println("Reason for Change in Deal Size is " + ReasonforChangeinDealSize);
	}
	
	public void putCustomerPainPointsTxtField(String CustomerPainPoints)
	{
		getCustomerPainPointsTxtField().sendKeys(CustomerPainPoints);
		System.out.println("Customer Pain Points is " + CustomerPainPoints);
	}

	public void putSOWDDField(String SOW)
	{
		getSOWDDField().sendKeys(SOW);
		System.out.println("SOW is " + SOW);
	}
	
	public void putCustomerBusinessNeedTxtField(String CustomerBusinessNeed)
	{
		getCustomerBusinessNeedTxtField().sendKeys(CustomerBusinessNeed);
		System.out.println("Customer Business Need is " + CustomerBusinessNeed);
	}
	
	public void putPOCDDField(String POC)
	{
		getPOCDDField().sendKeys(POC);
		System.out.println("POC is " + POC);
	}
	
	public void putRedFlagsTxtField(String RedFlags)
	{
		getRedFlagsTxtField().sendKeys(RedFlags);
		System.out.println("Red Flags is " + RedFlags);
	}
	
	public void putRFPDDField(String RFP)
	{
		getRFPDDField().sendKeys(RFP);
		System.out.println("POC is " + RFP);
	}
	
	public void putProfessionalServicesDDField(String ProfessionalServices)
	{
		getProfessionalServicesDDField().sendKeys(ProfessionalServices);
		System.out.println("Professional Services is " + ProfessionalServices);
	}

	public void putDeleteStatusDDField(String DeleteStatus)
	{
		getDeleteStatusDDField().sendKeys(DeleteStatus);
		System.out.println("Delete Status is " + DeleteStatus);
	}
	
	public void putDeleteRequestReasonTxtField(String DeleteRequestReason)
	{
		getDeleteRequestReasonTxtField().sendKeys(DeleteRequestReason);
		System.out.println("Delete Request Reason is " + DeleteRequestReason);
	}
	
	public void putSiebelIDTxtField(String SiebelID)
	{
		getSiebelIDTxtField().sendKeys(SiebelID);
		System.out.println("Siebel ID is " + SiebelID);
	}
	
	public void selectExcludeterritoryassignmentfilterlogicChkBox(String Excludeterritoryassignmentfilterlogic)
	{
		if (Boolean.valueOf(Excludeterritoryassignmentfilterlogic) && !getExcludeterritoryassignmentfilterlogicChkBox().isSelected())
		{
			getExcludeterritoryassignmentfilterlogicChkBox().click();
			System.out.println("Exclude territory assignment filter logic is Selected");
		}
		else
		{
			System.out.println("Exclude territory assignment filter logic is not Selected");
		}
	}
	
	public void putWonLostReasonUnselectedMSLField(String WonLostReason)
	{
		getWonLostReasonUnselectedMSLField().sendKeys(WonLostReason);
		System.out.println("Won Lost Reason is " + WonLostReason);
	}
	
	public void putWonLostReasonFWDBtnField()
	{
		getWonLostReasonFWDBtnField().click();
		System.out.println("Won Lost Reason Forward Btn is clicked");
	}
	
	public void putWonLostReasonBKDBtnField()
	{
		getWonLostReasonBKDBtnField().click();
		System.out.println("Won Lost Reason Backward Btn is clicked");
	}
	
	public void putWonLostReasonSelectedMSLField(String WonLostReason)
	{
		getWonLostReasonSelectedMSLField().sendKeys(WonLostReason);
		System.out.println("Won Lost Reason is " + WonLostReason);
	}
	
	public void putLeadProductInterestUnselectedMSLField(String LeadProductInterest)
	{
		getLeadProductInterestUnselectedMSLField().sendKeys(LeadProductInterest);
		System.out.println("Lead Product Interest is " + LeadProductInterest);
	}
	
	public void putLeadProductInterestFWDBtnField()
	{
		getLeadProductInterestFWDBtnField().click();
		System.out.println("Lead Product Interest Forward Btn is clicked");
	}
	
	public void putLeadProductInterestBKDBtnField()
	{
		getLeadProductInterestBKDBtnField().click();
		System.out.println("Lead Product Interest Backward Btn is clicked");
	}
	
	public void putLeadProductInterestSelectedMSLField(String LeadProductInterest)
	{
		getLeadProductInterestSelectedMSLField().sendKeys(LeadProductInterest);
		System.out.println("Lead Product Interest is " + LeadProductInterest);
	}
	
	public void putProfServCustomerTrainingIncludedUnselectedMSLField(String ProfServCustomerTrainingIncluded)
	{
		getProfServCustomerTrainingIncludedUnselectedMSLField().sendKeys(ProfServCustomerTrainingIncluded);
		System.out.println("Prof Serv/Customer Training Included is " + ProfServCustomerTrainingIncluded);
	}
	
	public void putProfServCustomerTrainingIncludedFWDBtnField()
	{
		getProfServCustomerTrainingIncludedFWDBtnField().click();
		System.out.println("Prof Serv/Customer Training Included Forward Btn is clicked");
	}
	
	public void putProfServCustomerTrainingIncludedBKDBtnField()
	{
		getProfServCustomerTrainingIncludedBKDBtnField().click();
		System.out.println("Prof Serv/Customer Training Included Backward Btn is clicked");
	}
	
	public void putProfServCustomerTrainingIncludedSelectedMSLField(String ProfServCustomerTrainingIncluded)
	{
		getProfServCustomerTrainingIncludedSelectedMSLField().sendKeys(ProfServCustomerTrainingIncluded);
		System.out.println("Prof Serv/Customer Training Included is " + ProfServCustomerTrainingIncluded);
	}
	
	
	public Opportunity clickCancel() 
	{
		getCancelBtnField().click();
		return new Opportunity(driver, propObject);
	}
	
	public Opportunity onClickSave() 
	{
		getSaveBtnField().click();
		System.out.println("Save button clicked");
		return new Opportunity(driver, propObject);
	}
}
