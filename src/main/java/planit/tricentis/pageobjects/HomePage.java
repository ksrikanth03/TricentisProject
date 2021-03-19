package planit.tricentis.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	private WebDriver driver;
	private By accountIDLocator = By.cssSelector(".header-links .account");
	private By shoppingLinkLocator = By.cssSelector(".ico-cart");
	private By booksMenuLocator = By.xpath("//a[contains(text(),'Books')]");
	
	public HomePage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public String getAccountIdTopRight() 
	{
		return driver.findElement(accountIDLocator).getText();
	}
	
	public void goToShoppingCart()
	{
		driver.findElement(shoppingLinkLocator).click();
	}
	
	public void goToBooksMenu() 
	{
		driver.findElement(booksMenuLocator).click();
	}
}
