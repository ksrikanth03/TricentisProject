package planit.tricentis.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ThankyouPage {
	private WebDriver driver;
	By thankYouText = By.xpath("//h1[contains(text(),'Thank you')]");
	By orderNumber = By.cssSelector(".details li");
	By orderCompletionButton = By.cssSelector(".order-completed-continue-button");
	By logout = By.cssSelector(".ico-logout");
	
	
	public ThankyouPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public String getThankYouText() {
		return driver.findElement(thankYouText).getText();
	}
	
	public String getOrderNumber() {
		return driver.findElement(orderNumber).getText();
	}
	
	public void clickOrderCompletionButton() 
	{
		driver.findElement(orderCompletionButton).click();
	}
	
	public void logout() 
	{
		driver.findElement(logout).click();
	}

}
