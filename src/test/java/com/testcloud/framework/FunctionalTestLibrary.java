package com.testcloud.framework;

import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testcloud.framework.AppResources;
//import com.thoughtworks.selenium.*;
//import junit.framework.Assert;

public class FunctionalTestLibrary {
	
	static Properties appProps = new AppResources().getProperties();
	
	/**
	 * Login to BugCenter with good credentials
	 * 
	 * @param WebDriver driver 
	 * @param string username
	 * @param string password
	 * @return null
	 */
	public static void login(WebDriver driver, String username, String password) throws Exception{
		
		//clicking in the start session button
		driver.findElement(By.id("gb_70")).click();
		Thread.sleep(5000);
		//insert username
		driver.findElement(By.id(appProps.getProperty("usernameTextBox.id"))).sendKeys(username);
		//insert password
		driver.findElement(By.id(appProps.getProperty("passwordTextBox.id"))).sendKeys(password);
		
		 //Uncheck persistent checkox
		driver.findElement(By.id(appProps.getProperty("persistenceCheckbox.id"))).click();
		
        //click on login button
		driver.findElement(By.name(appProps.getProperty("loginButton.id"))).click();	
		
	}
	
	/**
	 * Logout 
	 * 
	 * @param WebDriver driver
	 * @return null
	 * @throws Exception 

	public static void logout(WebDriver driver, String username) throws Exception {
		
		System.out.println("--------------" + username);
		//clicking on link to expand logout options
		driver.findElement(By.partialLinkText(username)).click();
		Thread.sleep(3000);
		//clicking in the logout button
		driver.findElement(By.id("gb_71")).click();	
		Thread.sleep(5000);
		
		//verify vendoservices page loading by asserting the existence of text SQA in page source code
		Assert.assertTrue(driver.getPageSource().contains("Iniciar ses"));
		
		//otros elementos que se pueden utilizar
		//Helper.waitForElementByXpath(driver, appProps.getProperty("usernameTextBox.xpath"), "login textbox not found in the page by xpath");
		//Helper.waitForElementById(driver, appProps.getProperty("usernameTextBox.id"), "login textbox not found in the page");
		
		Helper.log("Logout done!");
		
	}
		 */
	
	/**
	 * Google Search 
	 * 
	 * @param WebDriver driver
	 * @param String search
	 * @return 
	 * @return null
	 * @throws Exception 
	 */
	public static String searchInGoogle(WebDriver driver, String lookfor) throws Exception {
        
		// Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys(lookfor);

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());
        
        return driver.getTitle();
		
		
	}
	
	/**
	 * Google Search 
	 * 
	 * @param WebDriver driver
	 * @param String search
	 * @return 
	 * @return null
	 * @throws Exception 
	 */
	public static List<WebElement> googleSuggestion(WebDriver driver, String lookfor) throws Exception {
        
		// Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys(lookfor);

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // Sleep until the div we want is visible or 5 seconds is over
        long end = System.currentTimeMillis() + 5000;
        while (System.currentTimeMillis() < end) {
            WebElement resultsDiv = driver.findElement(By.className("gssb_e"));

            // If results have been returned, the results are displayed in a drop down.
            if (resultsDiv.isDisplayed()) {
              break;
            }
        }

        // And now list the suggestions
        List<WebElement> allSuggestions = driver.findElements(By.xpath("//td[@class='gssb_a gbqfsf']"));
        
        for (WebElement suggestion : allSuggestions) {
            System.out.println(suggestion.getText());
        }
		
        return allSuggestions;
	}

}
