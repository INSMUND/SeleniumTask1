package FirstTest;


import java.util.List;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class TestLogsAdminProductsOpenPresented extends TestBase{	
	EventFiringWebDriver eventDriver;
	
	@Test
	public void logsAdminProductsOpenPresentedTest() {
		loginAdmin();
	
	try {
		EventFiringWebDriver eventFiringDriver = new
		EventFiringWebDriver(driver);
		IAmTheEventListener eventListener = new IAmTheEventListener();
		eventFiringDriver.register(eventListener);
		eventFiringDriver.get("http://localhost:8080/litecart/admin/?app=catalog&doc=catalog&category_id=1");
		List<WebElement> listOfProducts = eventFiringDriver
				.findElements(By.xpath("//table[@class='dataTable']//td[3]/a[contains(@href,'product')]"));
		for (int i=1;i<=listOfProducts.size();i++) {
			String currentXpath="(//table[@class='dataTable']//td[3]//a[contains(@href,'product')])["+i+"]";
			eventFiringDriver.findElement(By.xpath(currentXpath)).click();
			eventFiringDriver.navigate().back();			
		}		
		} catch(Exception e) {
			  System.out.println("");
		}
		}
}
		
	
	
