package planit.tricentis.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsListPage {
	private WebDriver driver;
	By produtTitleLocator = By.cssSelector(".product-title");
	
	public ProductsListPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public void clickFirstProduct() 
	{
		driver.findElement(produtTitleLocator).click();
	}

}
