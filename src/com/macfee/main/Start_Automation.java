package com.macfee.main;

import org.testng.TestNG;
import com.mcafee.framework.TestCaseCollector;
import com.mcafee.framework.TestListener;

/**
*
* @author Balamurugan
*
*/

public class Start_Automation 
{
	public static void main(String[] args) throws Exception 
	{
		TestNG testng = new TestNG();
		testng.setTestClasses(TestCaseCollector.getInstance().getTestClasses());
		testng.setPreserveOrder(true);
		testng.addListener(new TestListener());
		/*testng.addExecutionListener(new ATUReportsListener());
		testng.addListener(new ConfigurationListener());
		testng.addListener(new MethodListener());
		System.setProperty("atu.reporter.config", ".\\resources\\atu.properties");*/
		testng.run(); 
	}
}
