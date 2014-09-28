package com.testcloud.testcases;
// import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.testcloud.framework.AppResources;
import com.testcloud.framework.FunctionalTestLibrary;

public class OpenFFedreamscom
{
	static Properties appProps = new AppResources().getProperties();
	String testURL = appProps.getProperty("test.url").toString();
	protected WebDriver driver;
	private StringBuffer verificationErrors =
			new StringBuffer();
	@Before
	public void setUp()
	{
		driver = new FirefoxDriver();
		driver.get(testURL);
	}
	@Test
	/* ****************/
	 public void NavigationCheck() 
	{
		try {
				// Select trip typeto OneWay
				WebElement tripType =
						driver.findElement(By.id("tripType1"));
				tripType.click();
				// Enter departure location 
				WebElement departure =
				driver.findElement(By.id("departureLocation"));
				departure.sendKeys("London");
				// Enter arrival location
				WebElement arrival = driver.findElement(By.id("arrivalLocation"));
				arrival.sendKeys("Miami");
				// Set departure & return Date
			
				// Press Search button
				WebElement element =
						driver.findElement(By.id("search_home_flight"));
				element.click();
				// assertEquals("Cheap flights", driver.getTitle());
			} catch (Error e) {
				//Capture and append Exceptions/Errors
				verificationErrors.append(e.toString());
			}
	}
	 /* 
	  * 
	  * */
	@After
	public void tearDown() throws Exception 
	{
		//Close the browser
		driver.quit();
		String verificationErrorString =
		verificationErrors.toString();
		if (!"".equals(verificationErrorString)) 
		{
			fail(verificationErrorString);
		}
	}

}
