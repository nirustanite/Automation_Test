package com.automation.utils.Listeners;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.automation.utils.ExtentReports.ExtentManager;
import com.automation.utils.ExtentReports.ExtentTestManager;
import com.automation.Common;
import com.automation.StartTest;

public class TestListener extends StartTest implements ITestListener{

	private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
    
    public void onStart(ITestContext iTestContext) {
        iTestContext.setAttribute("WebDriver", this.driver);
    }
 
  
    public void onFinish(ITestContext iTestContext) {
       
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
    }
 
    public void onTestStart(ITestResult iTestResult) {
      
        ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(),"");
    }
 
    public void onTestSuccess(ITestResult iTestResult) {
        ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
        
 
    }
 
    public void onTestFailure(ITestResult iTestResult) {
    
       Object testClass = iTestResult.getInstance();
        WebDriver webDriver = Common.driver;
 
       
        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)webDriver).
                getScreenshotAs(OutputType.BASE64);
 
     
        ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed",
                ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
    }
 
    public void onTestSkipped(ITestResult iTestResult) {
       
       ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
    }

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
		ExtentTestManager.getTest().log(LogStatus.WARNING, "TestFailedButWithinSuccessPercentage");
	}
 
    
}
