package planit.tricentis.common;

import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;


public class BaseTest extends Driver{
	
	public String cwd = System.getProperty("user.dir");
	String configFilePath = cwd + "\\src\\main\\java\\planit\\tricentis\\common\\configuration.properties";
	
	public WebDriver initializeBrowser() throws Exception
	{
		FileReader readerObject=new FileReader(configFilePath);
		Properties propertiesObject = new Properties();
		propertiesObject.load(readerObject);
		
		driver = this.getDriver(propertiesObject.getProperty("browser"));
		driver.get(propertiesObject.getProperty("url"));
		return driver;
	}
	

}
