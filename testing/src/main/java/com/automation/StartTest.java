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
        Common.LoadDriver();
        Reporter.log("Driver is loaded");
        
        driver.get(URL);
        this.TakeScreenshot(driver, "screenshots1\\test.png");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        driver.findElement(By.xpath("(//*[@name='paymentProductId']/div)[18]")).click();
        this.TakeScreenshot(driver, "screenshots\\test1.png");
        driver.findElement(By.xpath("//select[@name='issuerId']/option[11]")).click();
        driver.findElement(By.id("primaryButton")).click();
        Common.wait(30);
        driver.findElement(By.name("button.edit")).click();
        driver.findElement(By.xpath("//*[@class='paymentoptions']/p"));
        
    }
  
	@AfterClass
    public void afterClass() {
       
	}

}
