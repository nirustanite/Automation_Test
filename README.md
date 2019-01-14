### Automation_Test
### Using Selenium Webdriver

**TASK**

1. Sign-up and get ApiKeyId and SecretApiKey required for signature generation.
2. Use Ingenico's JavaServerSDK and use HostedCheckoutPayment requestto get Partial-Redirect URL.
3. Add "https://payment." to the Partia-Redirect URL and redirect on Chrome Browser.
4. At hostedCheckout page, Select Ideal Payment method.
5. Select issuer.
6. Click on Pay button.
7. Verify Payment successfull.

---

**PARAMETERS REQUIRED**

---

**config.properties**
1. ApiKeyId.
2. SecretApiKey.
3. MerchantID

---

**authentication.properties**
1. connect.api.integrator= your company name
2. connect.api.endpoint.host= api.domain.com

---

**COMMAND TO RUN THE PROGRAM**

mvn clean test -DsuiteXmlFile=testng.xml

---

**PREREQUISTES**
1. Enter values in unfilled places in resources/authentication.properties
2. Enter values in unfilled places in resources/config.properties
3. Install chrome driver and place it in driver folder.

