### Automation_Test
### Using Selenium Webdriver

**TASK**

1. Sign-up and get ApiKeyId and SecretApiKey required for signature generation.
2. Use Ingenico's JavaServerSDK and use HostedCheckoutPayment requestto get Partial-Redirect URL.
3. Add "https://payment." to the Partial-Redirect URL and redirect on Chrome Browser.
4. At hostedCheckout page, Select Ideal Payment method.
5. Select issuer.
6. Click on Pay button.
7. Verify Payment successfull.

---

**PREREQUISTES**
1. Create config.properties and authentication.properties in resources folder.
1. Enter values in unfilled places by using resources/sampleauthentication.properties in resources/authentication.properties.
2. Enter values in unfilled places by using resources/sampleconfig.properties in resources/config.properties.
3. Install chrome driver and place the path in resources/config.properties
   Example Path: \\Path to exe\\chromedriver.exe

---

**PARAMETERS REQUIRED**

**config.properties**
1. ApiKeyId.
2. SecretApiKey.
3. MerchantId.
4. chromedriverpath.


**authentication.properties**
1. connect.api.integrator= your company name
2. connect.api.endpoint.host= api.domain.com

---

**COMMAND TO RUN THE PROGRAM**

mvn clean test -DsuiteXmlFile=testng

---

**REPORT GENERATION**

Used Extent Reports for report generation.

The report will be available under ExtentReports folder.
