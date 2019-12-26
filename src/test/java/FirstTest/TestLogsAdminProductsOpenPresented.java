package FirstTest;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import dataProviders.ConfigFileReader;

public class TestLogsAdminProductsOpenPresented extends TestBase{
	
	
	@Test
	public void logsAdminProductsOpenPresentedTest() {
		loginAdmin();		
		EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
		eventDriver.ElementClicked =
			    new EventHandler<WebElementEventArgs>(eventDriver_ElementClicked);
		eventDriver.get("http://localhost:8080/litecart/admin/?app=catalog&doc=catalog&category_id=1");		
		List<WebElement> listOfProducts = eventDriver
				.findElements(By.xpath("//table[@class='dataTable']//td[3]/a[contains(@href,'product')]"));
		
		for (WebElement e:listOfProducts) {
			e.click();
		}
}
	 public void analyzeLog() {
	        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
	        for (LogEntry entry : logEntries) {
	            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
	            //do something useful with the data
	        }
	    }
}