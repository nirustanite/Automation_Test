package com.automation;
import com.automation.model.*;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
        VerifyPaymentSuccessful.LoadDriver();
        
    }
  
	@AfterClass
    public void afterClass() {
       
	}

}
