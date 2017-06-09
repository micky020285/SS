package com.macfee.sampletest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.macfee.pages.Profile;
import com.macfee.pages.SalesHomePage;
import com.macfee.pages.SalesLoginPage;
import com.macfee.pages.SetUp;
import com.mcafee.framework.BaseClass;
import com.mcafee.framework.ConfigData;

/**
*
* @author Murali
*
*/

public class ProfieSelection extends BaseClass
{
	private static SalesHomePage salesHomePage;
	private static SalesLoginPage salesLoginPage;
	private static SetUp setupUser;
	private static Profile profile;
	
	@Test
	public void setup() 
	{
		super.setup();
		System.out.println("Setup done");
		salesLoginPage=commonMethods.launchSFApplication();
		salesHomePage=salesLoginPage.doLogIn(ConfigData.SFUSERNAME, ConfigData.SFPASSWORD);
		//Assert.assertTrue(false, "Home page launched successfully");
		Assert.assertTrue(salesHomePage.isHomePageLaunched(), "Sales home page launched successfully");
		System.out.println("End Customer Contacts Creation in Sales Application");
		salesHomePage.SelectTopRightCornerUserMenu();
		setupUser = salesHomePage.SelectTopRightCornerSetupSubMenu();
		setupUser.ClickOnManageUser();
		profile = setupUser.ClickOnProfiles();
		profile.onClickUserProfile();
		profile.onClickUserViewDetails();
		profile.onClickUserLoginLink();
	}
}
