package com.mcafee.framework;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
*
* @author Balamurugan
*
*/

public class WebdriverInitializer 
{
	private String browser;
	public WebdriverInitializer(String browser) 
	{
		this.browser=browser;
	}
	
	protected WebDriver getWebDriver()
	{
		return webdriverInitializer(this.browser);
	}

	protected static WebDriver webDriver = null;

	private WebDriver webdriverInitializer(String type) 
	{
		switch(type) 
		{
			case "chrome":
				File chromeFile = new File(".\\driver\\chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", chromeFile.getAbsolutePath());
				/*
	              //Storing the Chrome Profile Path in Chrome_Profile_Path variable.
	              String Chrome_Profile_Path = "C:\\Users\\bsivasux\\AppData\\Local\\Google\\Chrome\\User Data";
	 
	              //Creating an instance of ChromeOptions (i.e objChrome_Profile)
	              ChromeOptions Chrome_Profile = new ChromeOptions();
	 
	              //Disabling the chrome browser extensions
	              Chrome_Profile.addArguments("chrome.switches","--disable-extensions");
	 
	              //Adding Chrome profile by .addArguments to objChrome_Profile
	              Chrome_Profile.addArguments("user-data-dir=" + Chrome_Profile_Path);
	 
	              //Initializing the Webdriver instance (i.e. driver) to open Chrome Browser and passing the Chrome Profile as argument
				  webDriver = new ChromeDriver(Chrome_Profile);
				  */
				  
				webDriver = new ChromeDriver();
				webDriver.manage().window().maximize();

			case "firefox":
				break;
				
			case "ie":
				File ieFile = new File(".\\driver\\IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver", ieFile.getAbsolutePath());
				webDriver = new InternetExplorerDriver();
				webDriver.manage().window().maximize();
				break;
				
			default:
				break;
		}
		return webDriver;
	}

	public void closeDriver() 
	{
		if (webDriver != null) 
		{
			this.webDriver.close();
			this.webDriver.quit();
		}
	}
}
