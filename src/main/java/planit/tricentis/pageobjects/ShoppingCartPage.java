package planit.tricentis.pageobjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage {
	private WebDriver driver;
	By removeCheckBoxesLocator = By.cssSelector(".remove-from-cart");
	By quantitiesLocator = By.cssSelector(".qty input");
	By updateCartLocator = By.cssSelector(".update-cart-button");
	By subTotalPriceLocator = By.cssSelector(".cart-total-right .product-price");
	By termsOfServiceLocator = By.cssSelector("[id='termsofservice']");
	By checkOutLocator = By.cssSelector("[name='checkout']");
	
	
	public ShoppingCartPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public void clearCart()
	{
		try
		{
			List<WebElement> removeCheckBoxesList=driver.findElements(removeCheckBoxesLocator);
			Iterator<WebElement> removeCheckBoxIterator=removeCheckBoxesList.iterator();
			while(removeCheckBoxIterator.hasNext())
			{
				WebElement checkBox=removeCheckBoxIterator.next();
				checkBox.click();
			}
			
			List<WebElement> quanitiesList=driver.findElements(quantitiesLocator);
			Iterator<WebElement> quantities=quanitiesList.listIterator();
			while(quantities.hasNext())
			{
				WebElement quantity=quantities.next();
				quantity.clear();
				quantity.sendKeys("0");
			}
			
			WebElement updateCartButton=driver.findElement(updateCartLocator);
			updateCartButton.click();
		}
		catch(NoSuchElementException nse)
		{
			System.out.println("Cart is Already Cleared");
		}
	}
	
	public String getSubTotalPrice() 
	{
		return driver.findElement(subTotalPriceLocator).getText();
	}
	
	public void selectTermsOfService() 
	{
		driver.findElement(termsOfServiceLocator).click();
	}
	
	public void clickCheckOut()
	{
		driver.findElement(checkOutLocator).click();
	}
}
