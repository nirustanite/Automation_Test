package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;

import com.automation.utils.ExtentReports.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

public class VerifyPaymentSuccessful extends Common{

	public static void LoadDriver() {
		Common.LoadDriver();
	    ExtentTestManager.getTest().setDescription("Verify Payment successful");
	    driver.get(URL);
	    if(Common.isElementPresent(Common.read("VerificationPaymentScreen")))
	    {
	    	ExtentTestManager.getTest().log(LogStatus.PASS,"Payment Screen is loaded");
		    Common.TakeScreenshotPass();
	    }
	    else
	    {
	    	ExtentTestManager.getTest().log(LogStatus.FAIL,"Payment Screen is not loaded");
	    	Common.TakeScreenshotFail();
	    }
	    Common.ScrollWindow();
	 
	    if(Common.isElementPresent(Common.read("SelectIdealPaymentOption")))
	    {
	    	ExtentTestManager.getTest().log(LogStatus.PASS,"Ideal payment is present");
	    	Common.TakeScreenshotPass();
	    	driver.findElement(By.xpath(Common.read("SelectIdealPaymentOption"))).click();
	    }
	    else
	    {
	    	ExtentTestManager.getTest().log(LogStatus.FAIL,"Ideal payment is not loaded");
	    	Common.TakeScreenshotFail();
	    }
	    if(Common.isElementPresent(Common.read("VerifySelectBank"))) {
	    	ExtentTestManager.getTest().log(LogStatus.PASS,"Select your Bank is present");
	    	Common.TakeScreenshotPass();
	    	if(Common.isElementPresent(Common.read("ClickIssuer")))
	    	{
	    		ExtentTestManager.getTest().log(LogStatus.PASS,"Issuer is present");
	    		driver.findElement(By.xpath(Common.read("ClickIssuer"))).click();
	    		Common.TakeScreenshotPass();
	    		driver.findElement(By.id(Common.read("PayButton"))).click();
	    	}
	    }
	    else
	    {
	    	ExtentTestManager.getTest().log(LogStatus.FAIL,"Select your Bank is not present");
	    	Common.TakeScreenshotFail();
	    }
	    if(Common.isElementPresent(Common.read("ConfirmTransaction")))
	    {
	    	ExtentTestManager.getTest().log(LogStatus.PASS,"Ideal Issuer Simulation page is navigated");
	    	Common.TakeScreenshotPass();
	    	driver.findElement(By.name(Common.read("ClickConfirmTransaction"))).click();
	    }
	    else
	    {
	    	ExtentTestManager.getTest().log(LogStatus.PASS,"Ideal Issuer Simulation page is not navigated");
	    	Common.TakeScreenshotFail();
	    }
	    if(Common.isElementPresent(Common.read("VerifyPaymentStatus")))
	    {
	    	ExtentTestManager.getTest().log(LogStatus.PASS,"Payment Status Page is loaded");
	    	Common.TakeScreenshotPass();
	    	String getText = driver.findElement(By.xpath(Common.read("PaymentSuccessful"))).getText();
	    	if(getText.equalsIgnoreCase("Your payment is successful."))
	    	{
	    		ExtentTestManager.getTest().log(LogStatus.PASS,"Verified Payment is successful");
	    	}
	    	else
	    	{
	    		ExtentTestManager.getTest().log(LogStatus.FAIL,"Verified Payment is not successful");
	    		Common.TakeScreenshotFail();
	    	}
	    }
	}

}
