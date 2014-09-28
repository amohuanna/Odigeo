package com.testcloud.framework;

import java.util.regex.*;
//import com.thoughtworks.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {
	
	/**
	   * Kill autoid elements
	   * @param proceso proceso a matar
	   */
	public static void killProcess(String proceso) throws Exception{
		
		Helper.log("Killing the element "+proceso);
		//RunProgram.Exec("D:\\testABIL\\psexec.exe -d -high -u TESTABIL.LOCAL\\selenium -p 1111 D:\\testABIL\\pskill -t " + proceso);
		RunProgram.Exec("C:\\workspace\\pskill -t " + proceso);
		Thread.sleep(2000);
	}

	/**
	   * Verify if an element it is present By ID
	*/
	public static boolean isElementPresentById(WebDriver driver, String Id){
		try{
			driver.findElement(By.id(Id));
			return true;
		}catch(NoSuchElementException e){
			return false;
		}
	}
	
	/**
	   * Verify if an element it is present By Xpath
	*/
	public static boolean isElementPresentByXpath(WebDriver driver, String xpath){
		try{
			driver.findElement(By.xpath(xpath));
			return true;
		}catch(NoSuchElementException e){
			return false;
		}
	}
	/**
	   * Verify if an element it is present By CssSelector
	*/
	public static boolean isElementPresentByCssSelector(WebDriver driver, String cssSelector){
		try{
			driver.findElement(By.cssSelector(cssSelector));
			return true;
		}catch(NoSuchElementException e){
			return false;
		}
	}
	
	
	/**
	   * 
	   * Wait for an element By Xpath
	   * 
	   */
	public static void waitForElementByXpath(WebDriver driver, String xpath, String error ) throws Exception{
		
		Helper.log("Waiting for element " + xpath + " in " + driver.getCurrentUrl());
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	/**
	   * 
	   * Wait for an element By CssSelector
	   * 
	   */
	public static void waitForElementByCssSelector(WebDriver driver, String elemenCssSelector, String error ) throws Exception{
		
		Helper.log("Waiting for element " + elemenCssSelector + " in " + driver.getCurrentUrl());
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(elemenCssSelector)));
	}
	
	/**
	   * 
	   * Wait for an element By Id
	   * 
	   */
	public static void waitForElementById(WebDriver driver, String elemenId, String error ) throws Exception{
		
		Helper.log("Waiting for element " + elemenId + " in " + driver.getCurrentUrl());
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elemenId)));
	}
	
    /**
     * 
     * \\@param inputStr tipo string, texto introducido a ser comparado con la regexp
     * \\@param regEx tipo regexp, expresion regular introducida a ser comparado con el texto
     * \\@return tipo string[] Array, se guarda las coincidencias entre ambos parametros 
    */
    public static final String[] parse (String inputStr, String regEx) {
    	Pattern p = Pattern.compile(regEx);
	    Matcher m = p.matcher(inputStr);

	    if (m.find()) {
	      int Count=m.groupCount();
	      String[] res=new String[Count];

	      for (int i=0; i<Count; i++) {res[i]=m.group(i+1);}
	      return res;
	    }

	    else return null;
    }
  
    public static void log(String message){
    	System.out.println("---------> " + message);
    }
    
}