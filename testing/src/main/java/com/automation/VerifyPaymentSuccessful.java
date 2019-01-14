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
	    if(Common.isElementPresent("//*[@id='selectmethod']"))
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
	 
	    if(Common.isElementPresent("(//*[@name='paymentProductId']/div)[18]"))
	    {
	    	ExtentTestManager.getTest().log(LogStatus.PASS,"Ideal payment is present");
	    	Common.TakeScreenshotPass();
	    	driver.findElement(By.xpath("(//*[@name='paymentProductId']/div)[18]")).click();
	    }
	    else
	    {
	    	ExtentTestManager.getTest().log(LogStatus.FAIL,"Ideal payment is not loaded");
	    	Common.TakeScreenshotFail();
	    }
	    if(Common.isElementPresent("//*[@id='label-issuerId']")) {
	    	ExtentTestManager.getTest().log(LogStatus.PASS,"Select your Bank is present");
	    	Common.TakeScreenshotPass();
	    	if(Common.isElementPresent("//select[@name='issuerId']/option[11]"))
	    	{
	    		ExtentTestManager.getTest().log(LogStatus.PASS,"Issuer is present");
	    		driver.findElement(By.xpath("//select[@name='issuerId']/option[11]")).click();
	    		Common.TakeScreenshotPass();
	    		driver.findElement(By.id("primaryButton")).click();
	    	}
	    }
	    else
	    {
	    	ExtentTestManager.getTest().log(LogStatus.FAIL,"Select your Bank is not present");
	    	Common.TakeScreenshotFail();
	    }
	    if(Common.isElementPresent("//*[@name='button.edit']"))
	    {
	    	ExtentTestManager.getTest().log(LogStatus.PASS,"Ideal Issuer Simulation page is navigated");
	    	Common.TakeScreenshotPass();
	    	driver.findElement(By.name("button.edit")).click();
	    }
	    else
	    {
	    	ExtentTestManager.getTest().log(LogStatus.PASS,"Ideal Issuer Simulation page is not navigated");
	    	Common.TakeScreenshotFail();
	    }
	    if(Common.isElementPresent("//*[@class='paymentoptions']/h2"))
	    {
	    	ExtentTestManager.getTest().log(LogStatus.PASS,"Payment Status Page is loaded");
	    	Common.TakeScreenshotPass();
	    	String getText = driver.findElement(By.xpath("//*[@class='paymentoptions']/p")).getText();
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
