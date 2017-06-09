package com.mcafee.framework;

import java.io.File;

/**
*
* @author Balamurugan
*
*/

public class ConfigData 
{	
	static PropertiesReader locatorPropReaderObj;
	static
	{
		locatorPropReaderObj=new PropertiesReader(new File(".\\resources\\config.properties"));
	}
	
	public static final String SFURL=locatorPropReaderObj.getData("sfURL");
	public static final String SFUSERNAME=locatorPropReaderObj.getData("sfUserName");
	public static final String SFPASSWORD=locatorPropReaderObj.getData("sfPassword");
	
	
	//Impersonation Username, Role & Profile
	public static final String TESTUSERNAME=locatorPropReaderObj.getData("sfTestUserName");
	public static final String TESTUSERROLES=locatorPropReaderObj.getData("sfTestUserRole");
	public static final String TESTUSERPROFILES=locatorPropReaderObj.getData("sfTestUserProfile");
	
	public static final String TESTTERRITORYUSERPROFILE=locatorPropReaderObj.getData("sfTerritoryUserProfile");
	public static final String TESTINTERNALMKTGUSERPROFILE=locatorPropReaderObj.getData("sfInternalMktgUserProfile");
	public static final String TESTLDRUSERPROFILE=locatorPropReaderObj.getData("sfLDRUserProfile");
	public static final String TESTLEGALUSERPROFILE=locatorPropReaderObj.getData("sfLegalUserProfile");
	public static final String TESTPCTUSERPROFILES=locatorPropReaderObj.getData("sfPCTUserProfile");
	public static final String TESTPROFSERVICESUSERPROFILE=locatorPropReaderObj.getData("sfProfessionalServicesUserProfile");
	public static final String TESTSALESENGINEERUSERPROFILE=locatorPropReaderObj.getData("sfSalesEngineerUserProfile");
	public static final String TESTSALESREPAMUSERPROFILE=locatorPropReaderObj.getData("sfSalesRepAMUserProfile");
	public static final String TESTSALESREPAMFORECASTUSERPROFILE=locatorPropReaderObj.getData("sfSalesRepAMForecastUserProfile");
	public static final String TESTTIERONEUSERPROFILE=locatorPropReaderObj.getData("sfTierOneUserProfile");
	public static final String TESTTIERTWOUSERPROFILE=locatorPropReaderObj.getData("sfTierTwoUserProfile");
	public static final String TESTSYSADMINUSERPROFILE=locatorPropReaderObj.getData("sfSystemAdministratorUserProfile");
}
