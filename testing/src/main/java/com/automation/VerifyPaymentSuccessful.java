package com.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;

public class VerifyPaymentSuccessful extends Common{

	public static void LoadDriver() {
		Common.LoadDriver();
	    Reporter.log("Driver is loaded");
	    driver.get(URL);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,1000)");
	    driver.findElement(By.xpath("(//*[@name='paymentProductId']/div)[18]")).click();
	    driver.findElement(By.xpath("//select[@name='issuerId']/option[11]")).click();
	    driver.findElement(By.id("primaryButton")).click();
	    Common.wait(30);
	    driver.findElement(By.name("button.edit")).click();
	    driver.findElement(By.xpath("//*[@class='paymentoptions']/p"));
	}

}
