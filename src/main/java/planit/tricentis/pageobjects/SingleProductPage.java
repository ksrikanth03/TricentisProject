package planit.tricentis.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SingleProductPage {
	private WebDriver driver;
	By productPriceLocator = By.cssSelector(".product-price  span");
	By productQuantityLocator = By.cssSelector(".qty-input");
	By addToCartLocator = By.xpath("//input[@value='Add to cart']");
	By validationBarLocator = By.cssSelector(".content");
	
	
	public SingleProductPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public String getProductPrice()
	{
		return driver.findElement(productPriceLocator).getText().trim();
	}
	
	public void enterProductQuantity(String Quanity) 
	{
		WebElement productQuanityElement = driver.findElement(productQuantityLocator);
		productQuanityElement.clear();
		productQuanityElement.sendKeys(Quanity);
	}
	
	public void clickAddToCart()
	{
		driver.findElement(addToCartLocator).click();
	}
	
	public String getValidationMessage() {
		return driver.findElement(validationBarLocator).getText();
	}
	

}
