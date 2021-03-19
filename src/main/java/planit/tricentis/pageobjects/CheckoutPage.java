package planit.tricentis.pageobjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {
	
	By billingAddressLocator = By.cssSelector("[id='billing-address-select']");
	By billingAddressFirstName = By.cssSelector("#BillingNewAddress_FirstName");
	By billingAddressCountry = By.cssSelector("select#BillingNewAddress_CountryId");
	By billingAddressCity = By.cssSelector("#BillingNewAddress_City");
	By billingAddress1 = By.cssSelector("#BillingNewAddress_Address1");
	By billingAddressZipCode = By.cssSelector("#BillingNewAddress_ZipPostalCode");
	By billingAddressPhoneNumber = By.cssSelector("#BillingNewAddress_PhoneNumber");
	By billingAddressContinueButton = By.cssSelector("[title='Continue']");
	By shippingAddressLocator = By.id("shipping-address-select");
	By shippingAddressContinueButton = By.cssSelector("#checkout-step-shipping .new-address-next-step-button");
	By nextDayAir = By.cssSelector("#shippingoption_1");
	By continueNextDayButton = By.cssSelector(".shipping-method-next-step-button");
	By codLocator = By.cssSelector("[value='Payments.CashOnDelivery']");
	By paymentContinue = By.cssSelector(".payment-method-next-step-button");
	By paymentMessageLocator = By.cssSelector(".payment-info p");
	By paymentInfoContinue = By.cssSelector(".payment-info-next-step-button");
	

	private WebDriver driver;
	
	
	
	public CheckoutPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	
	public void selectNewBillingAddress() 
	{
		Select newAddress = new Select(driver.findElement(billingAddressLocator));
		newAddress.selectByVisibleText("New Address");
	}
	
	public void enterBillingAddressFirstame(String firstName) 
	{
		driver.findElement(billingAddressFirstName).sendKeys(firstName);
	}
	
	public void selectBillingAddressCountry(String country) 
	{
		
		Select selectCountry=new Select(driver.findElement(billingAddressCountry));
		selectCountry.selectByVisibleText(country);
	}
	
	public void enterBillingAddressCity(String city) 
	{
		driver.findElement(billingAddressCity).sendKeys(city);
	}
	
	public void enterBillingAddress1(String Address1) 
	{
		driver.findElement(billingAddress1).sendKeys(Address1);
	}
	
	public void enterZipCode(String zipCode) 
	{
		driver.findElement(billingAddressZipCode).sendKeys(zipCode);
	}
	
	public void enterPhoneNumber(String phoneNumer) 
	{
		driver.findElement(billingAddressPhoneNumber).sendKeys(phoneNumer);
	}
	
	public void clickBillingAddressContinue()
	{
		driver.findElement(billingAddressContinueButton).click();
	}
	
	public void selectShippingAddressByName(String name)
	{
		Select shippingAddress = new Select(driver.findElement(shippingAddressLocator));
		List<WebElement> shippingAddresses = shippingAddress.getOptions();
		Iterator<WebElement> shippingAddressIterator = shippingAddresses.iterator();
		String addressValue="";
		while(shippingAddressIterator.hasNext()) {
			WebElement singleShippingAddress = shippingAddressIterator.next();
			if(singleShippingAddress.getText().contains(name))
				{
				addressValue = singleShippingAddress.getAttribute("value");
				}
			
		}
		shippingAddress.selectByValue(addressValue);
	}
	
	public void clickShippingAddressContinue()
	{
		driver.findElement(shippingAddressContinueButton).click();
	}
	
	public void selectnextDayAir()
	{
		driver.findElement(nextDayAir).click();
	}
	
	public void clickContinueNextDayButton()
	{
		driver.findElement(continueNextDayButton).click();
	}
	
	public void selectCOD()
	{
		driver.findElement(codLocator).click();
	}
	
	public void clickPaymentContinueButton()
	{
		driver.findElement(paymentContinue).click();
	}
	
	public String getPaymentMessage() 
	{
		return driver.findElement(paymentMessageLocator).getText();
	}
	
	public void clickPaymentInfoButton()
	{
		driver.findElement(paymentInfoContinue).click();
	}
	
	
}
