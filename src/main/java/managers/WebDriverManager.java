package managers;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import dataProviders.ConfigFileReader;
import enums.DriverType;

public class WebDriverManager {
	 public WebDriver driver;
	 private static DriverType driverType;
	 private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	 private static final String FIREFOX_DRIVER_PROPERTY = "webdriver.gecko.driver";
	 
	 
	 public WebDriverManager() {
	 driverType = new ConfigFileReader().getBrowser();
	  }
	 
	 public WebDriver getDriver() {
	 if(driver == null) driver = createDriver();
	 return driver;
	 }
	 
	 	 
	 private WebDriver createDriver() {
	        switch (driverType) {     
	        case FIREFOX :
	        	System.setProperty(FIREFOX_DRIVER_PROPERTY, new ConfigFileReader().getDriverPathFirefox());
	        	driver = new FirefoxDriver();
	      break;
	        case CHROME : 	        	
	         System.setProperty(CHROME_DRIVER_PROPERTY, new ConfigFileReader().getDriverPathChrome());	          
	            driver = new ChromeDriver(new ChromeOptions().setExperimentalOption("w3c", false));
	     break;
	      	        }
	 
	        if(new ConfigFileReader().getBrowserWindowSize()) driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(new ConfigFileReader().getImplicitlyWait(), TimeUnit.SECONDS);
	 return driver;
	 } 
	 
	 public void quitDriver() {
	// driver.close();
	 driver.quit();
	 }
}
