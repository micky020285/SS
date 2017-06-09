package com.mcafee.framework;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import com.google.common.base.Function;

/**
*
* @author Balamurugan
*
*/

public class AutomationHelper 
{
	public static WebElement findElement(WebDriver driver, By locator, int waitTime) 
	{
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(waitTime, TimeUnit.SECONDS)
				.pollingEvery(500, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() 
		{
			public WebElement apply(WebDriver driver) 
			{
				return driver.findElement(locator);
			}
		});
		return element;
	}
}




