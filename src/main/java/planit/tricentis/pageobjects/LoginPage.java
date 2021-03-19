package planit.tricentis.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	private WebDriver driver;
	private By loginLink = By.cssSelector(".ico-login");
	private By signInMessage = By.cssSelector(".page-title");
	private By emailLocator = By.cssSelector("#Email");
	private By passwordLocator = By.cssSelector("#Password");
	private By loginButton = By.cssSelector(".login-button");
	
	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public void clickLoginLink() 
	{
		driver.findElement(loginLink).click();
	}
	
	public String getWelcomeText()
	{
		return driver.findElement(signInMessage).getText();
	}
	
	public void enterEmail(String emailID)
	{
		WebElement emailTextBox = driver.findElement(emailLocator);
		emailTextBox.clear();
		emailTextBox.sendKeys(emailID);	
	}
	
	public void enterpassword(String password)
	{
		WebElement passwordTextBox = driver.findElement(passwordLocator);
		passwordTextBox.clear();
		passwordTextBox.sendKeys(password);	
	}
	
	public void clickLoginButton() 
	{
		driver.findElement(loginButton).click();
	}
	
	
	

}
