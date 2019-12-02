package FirstTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import managers.WebDriverManager;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestLoginPage extends TestBase {

	@Test
	public void loginPageTest() {

		driver.get(configFileReader.getApplicationUrl());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("login")).click();
		System.out.println("Title of opened page is:"+driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "My Store");
	}
}
