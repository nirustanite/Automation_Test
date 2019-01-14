package com.automation;

import com.automation.model.*;
import com.automation.utils.ExtentReports.ExtentTestManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.ingenico.connect.gateway.sdk.java.Client;
import com.ingenico.connect.gateway.sdk.java.Factory;
import com.ingenico.connect.gateway.sdk.java.domain.definitions.Address;
import com.ingenico.connect.gateway.sdk.java.domain.definitions.AmountOfMoney;
import com.ingenico.connect.gateway.sdk.java.domain.hostedcheckout.CreateHostedCheckoutRequest;
import com.ingenico.connect.gateway.sdk.java.domain.hostedcheckout.CreateHostedCheckoutResponse;
import com.ingenico.connect.gateway.sdk.java.domain.hostedcheckout.definitions.HostedCheckoutSpecificInput;
import com.ingenico.connect.gateway.sdk.java.domain.payment.definitions.Customer;
import com.ingenico.connect.gateway.sdk.java.domain.payment.definitions.Order;
import com.relevantcodes.extentreports.LogStatus;

public class Common {

	public static String value;
	public static Client client;
	public static CreateHostedCheckoutResponse response;
	public static WebDriver driver;
	public static String URL;
	
	//Initializing the Java SDK
	public static void InitializeSdk()
	{
		File file = new File("resources/authentication.properties");
		client = Factory.createClient(file.toURI(), read("ApiKeyId"), read("SecretApiKey"));
	}
	
	public static void CreateNewTransaction(String locale,String variant,long Amount, String CurrencyCode, String CountryCode, String MerchantCustomerId)
	{
		Transaction transaction = new Transaction(locale,variant,Amount,CurrencyCode,CountryCode,MerchantCustomerId);
	    createHostedCheckout(transaction);
	}
	
	// Create Hosted Checkout and receive the PartialRedirectUrl
	public static void createHostedCheckout(Transaction transaction)
	{
		HostedCheckoutSpecificInput hostedCheckoutSpecificInput = new HostedCheckoutSpecificInput();
		hostedCheckoutSpecificInput.setLocale(transaction.getLocale());
		hostedCheckoutSpecificInput.setVariant(transaction.getVariant());

		AmountOfMoney amountOfMoney = new AmountOfMoney();
		amountOfMoney.setAmount(transaction.getAmount());
		amountOfMoney.setCurrencyCode(transaction.getCurrencyCode());

		Address billingAddress = new Address();
		billingAddress.setCountryCode(transaction.getCountryCode());

		Customer customer = new Customer();
		customer.setBillingAddress(billingAddress);
		customer.setMerchantCustomerId(transaction.getMerchantCustomerId());

		Order order = new Order();
		order.setAmountOfMoney(amountOfMoney);
		order.setCustomer(customer);

		CreateHostedCheckoutRequest body = new CreateHostedCheckoutRequest();
		body.setHostedCheckoutSpecificInput(hostedCheckoutSpecificInput);
		body.setOrder(order);

		response = client.merchant(read("MerchantId")).hostedcheckouts().create(body);
		getOneTimePaymentURL(response.getPartialRedirectUrl());
		
	}
	
	public static String getOneTimePaymentURL(String response)
	{
		URL = read("URLAddition")+response;
		return URL;
	}
	
	public static String read(String key)
	{
		try {
			File file = new File("resources/config.properties");
			FileInputStream fileinput = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(fileinput);
			fileinput.close();
			value = prop.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public static void LoadDriver()
	{
		System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		options.addArguments("headless");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}
	
	public static void wait(int seconds)
	{
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public static boolean isElementPresent(String xpath)
	{
		try
		{
			driver.findElement(By.xpath(xpath));
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	public static void ScrollWindow()
	{
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollBy(0,1000)");
	}
	
	public static void TakeScreenshotPass()
	{
		 String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)driver).
	                getScreenshotAs(OutputType.BASE64);
	 
	        ExtentTestManager.getTest().log(LogStatus.PASS,"Step passed",
	                ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
	}
	
	public static void TakeScreenshotFail()
	{
		 String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)driver).
	                getScreenshotAs(OutputType.BASE64);
	 
	        ExtentTestManager.getTest().log(LogStatus.FAIL,"Step failed",
	                ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
	}
	
}
