package com.automation;
import com.automation.model.*;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class StartTest extends Common{

	@BeforeClass
	public void beforeClass() {
		Common.InitializeSdk();
	}
	
	@Test
	public void VerifyPaymentSuccessful() {
	    Common.CreateNewTransaction("en_GB","testVariant",2345L,"EUR","NL","1234");
        Common.LoadDriver();
        Reporter.log("Driver is loaded");
        
        driver.get(URL);
        this.TakeScreenshot(driver, "screenshots\\test.png");
    }
  
	@AfterClass
    public void afterClass() {
       
	}

}
