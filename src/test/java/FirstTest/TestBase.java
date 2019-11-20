package FirstTest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import dataProviders.ConfigFileReader;

public class TestBase {
	public WebDriver driver;
	ConfigFileReader configFileReader;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

	@Before
	public void createDriver() {
		System.setProperty(CHROME_DRIVER_PROPERTY, new ConfigFileReader().getDriverPathChrome());
		driver = new ChromeDriver();
		configFileReader = new ConfigFileReader();
		if (configFileReader.getBrowserWindowSize())
			driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(new ConfigFileReader().getImplicitlyWait(), TimeUnit.SECONDS);
	}

	@After
	public void stop() {
		driver.quit();

	}

}
