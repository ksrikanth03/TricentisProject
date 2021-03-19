package planit.tricentis.testcases;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import planit.tricentis.pageobjects.CheckoutPage;
import planit.tricentis.pageobjects.HomePage;
import planit.tricentis.pageobjects.LoginPage;
import planit.tricentis.pageobjects.ProductsListPage;
import planit.tricentis.pageobjects.ShoppingCartPage;
import planit.tricentis.pageobjects.SingleProductPage;
import planit.tricentis.pageobjects.ThankyouPage;
import planit.tricentis.common.BaseTest;
import planit.tricentis.common.Constants;
import planit.tricentis.common.TestData;

public class OrderTest extends BaseTest {
	
	WebDriver driver;

	@BeforeTest
	public void loginIntoApplication() throws Exception 
	{
		driver = initializeBrowser();
	}
	
	@Test
	public void orderConfirmationTest()
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickLoginLink();
		String actualoginText = loginPage.getWelcomeText();
		Assert.assertEquals(actualoginText, Constants.expectedLoginText);
		
		loginPage.enterEmail(Constants.email_id);
		loginPage.enterpassword(Constants.password);
		loginPage.clickLoginButton();
		
		HomePage homePage = new HomePage(driver);
		String actualAccountID = homePage.getAccountIdTopRight();
		Assert.assertEquals(actualAccountID, Constants.email_id);
		
		ShoppingCartPage shoppingCart= new ShoppingCartPage(driver);
		ProductsListPage productListPage = new ProductsListPage(driver);
		homePage.goToShoppingCart();
		shoppingCart.clearCart();
		
		homePage.goToBooksMenu();
		productListPage.clickFirstProduct();
		
		SingleProductPage singleProductPage = new SingleProductPage(driver);
		double productPrice = Double.parseDouble(singleProductPage.getProductPrice());
		singleProductPage.enterProductQuantity(TestData.productQuanity);
		singleProductPage.clickAddToCart();
		String actualAddToCartValidationMessage = singleProductPage.getValidationMessage();
		Assert.assertEquals(actualAddToCartValidationMessage, Constants.expectedAddToCartValidationMessage);
		homePage.goToShoppingCart();
		
		double actualSubTotal=Double.parseDouble(shoppingCart.getSubTotalPrice());
		double expectedSubTotal=productPrice*Double.parseDouble(TestData.productQuanity);
		Assert.assertEquals(actualSubTotal, expectedSubTotal);
		
		shoppingCart.selectTermsOfService();
		shoppingCart.clickCheckOut();
		
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.selectNewBillingAddress();
		
		Random r=new Random();
		String firstName=TestData.firstName+r.nextInt(1000);
		
		checkoutPage.enterBillingAddressFirstame(firstName);
		checkoutPage.selectBillingAddressCountry(TestData.country);
		checkoutPage.enterBillingAddressCity(TestData.city);
		checkoutPage.enterBillingAddress1(TestData.address1);
		checkoutPage.enterZipCode(TestData.ZipCode);
		checkoutPage.enterPhoneNumber(TestData.phoneNumber);
		checkoutPage.clickBillingAddressContinue();
		
		checkoutPage.selectShippingAddressByName(TestData.firstName);
		checkoutPage.clickShippingAddressContinue();
		checkoutPage.selectnextDayAir();
		checkoutPage.clickContinueNextDayButton();
		checkoutPage.selectCOD();
		checkoutPage.clickPaymentContinueButton();
		String actualPaymentMessae = checkoutPage.getPaymentMessage();
		Assert.assertEquals(actualPaymentMessae, Constants.expectedPaymentMessage);
		checkoutPage.clickPaymentInfoButton();
		checkoutPage.clickConfirmOrderContinueButton();
		
		ThankyouPage thankYouPage = new ThankyouPage(driver);
		String actualThankYouText = thankYouPage.getorderConfirmationText();
		Assert.assertEquals(actualThankYouText, Constants.expectedOrderConfirmMessage);
		
		String orderNumber=thankYouPage.getOrderNumber();
		System.out.println("Order Number: "+orderNumber);
		
		thankYouPage.clickOrderCompletionButton();
		thankYouPage.logout();
	
	}
	
	@AfterTest
	public void tearDown() 
	{
//		driver.quit();
	}
	
	
}
