package FirstTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestEditCatalogCountriesActiveFrames extends TestBase {
	String mainPageHandle;

	@Test
	public void editCatalogCountriesActiveFramesTest() {
		loginAdmin();
		driver.findElement(By.xpath("(//ul[@id='box-apps-menu']/li)[3]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='dataTable']//tr[2]/td[7]")));

		driver.findElement(By.xpath("//table[@class='dataTable']//tr[2]/td[7]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),' Edit Country')]")));

		mainPageHandle = driver.getWindowHandle();

		List<WebElement> listOfElementsToNewTabByClick = driver
				.findElements(By.xpath("//td[@id='content']//tr//a[@target='_blank']"));
		for (int i = 0; i < listOfElementsToNewTabByClick.size(); i++) {
			newOpenTabCodeTest(listOfElementsToNewTabByClick.get(i));
		}
	}

	private void newOpenTabCodeTest(WebElement currentElement) {
		currentElement.click();
		System.out.println("Link by element " + currentElement.getText() + " was performed");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ArrayList<String> tabHandles = new ArrayList<String>(driver.getWindowHandles());
		boolean newTabFound = false;
		for (String eachHandle : tabHandles) {
			if (!eachHandle.contentEquals(mainPageHandle)) {
				driver.switchTo().window(eachHandle);
				System.out.println("New tab by link click with URL " + driver.getCurrentUrl() + " was opened");
				driver.close();
				driver.switchTo().window(mainPageHandle);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				System.out.println(driver.getCurrentUrl());
				newTabFound = true;
			}
		}

		Assert.assertTrue("New tab did not open", newTabFound);
	}

}
