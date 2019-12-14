package FirstTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import dataProviders.ConfigFileReader;
import managers.WebDriverManager;

public class TestBase {
	public WebDriver driver;
	ConfigFileReader configFileReader;
	public WebDriverManager webDriverManager;	

	@Before
	public void createDriver() {
		webDriverManager = new WebDriverManager();
		driver=webDriverManager.getDriver();
		configFileReader=new ConfigFileReader();
		
			}
	public void loginAdmin() {
		   driver.get(configFileReader.getApplicationUrlAdmin());		 	
		   driver.findElement(By.name("username")).sendKeys("admin");
		   driver.findElement(By.name("password")).sendKeys("admin");
		   driver.findElement(By.name("login")).click();
		 		System.out.println("Title of opened page is:"+driver.getTitle());
	}
	public void loginLitecart() {
		   driver.get(configFileReader.getApplicationUrlLitecart());			  
		 		System.out.println("Title of opened page is:"+driver.getTitle());
	}

	@After
	public void stop() {
		webDriverManager.quitDriver();	

	}

}
