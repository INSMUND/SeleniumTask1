package FirstTest;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestZonesOrder extends TestBase {

	@Test
	public void zonesOrderTest() {
		loginAdmin();
		driver.findElement(By.xpath("//td[@id='sidebar']//li[6]")).click();
		List<WebElement> listOfCountries = driver.findElements(By.xpath("//form[@name='geo_zones_form']//tr"));

		for (int i = 2; i <= listOfCountries.size() - 1; i++) {

			String xpathCurrentCountryZonesLink = "//form[@name='geo_zones_form']//tr" + "[" + i + "]" + "//td[5]/a";
			String link = driver.findElement(By.xpath(xpathCurrentCountryZonesLink)).getAttribute("href");
			driver.get(link);
			verifyZones();
			driver.navigate().back();
		}
		System.out.println("Zones are in alphabetic order");
	}

	public void verifyZones() {
		List<WebElement> listOfZones = driver.findElements(By.xpath("//table[@id='table-zones']//tr"));
		int k = 0;
		for (int i = 2; i <= listOfZones.size() - 2; i++) {
			String xpathCurrentZone = "//table[@id='table-zones']//tr" + "[" + i + "]"
					+ "//td[3]//option[@selected='selected']";
			String currentZoneTitle = driver.findElement(By.xpath(xpathCurrentZone)).getText();
			k = i + 1;
			String xpathNextZone = "//table[@id='table-zones']//tr" + "[" + k + "]"
					+ "//td[3]//option[@selected='selected']";
			String nextZoneTitle = driver.findElement(By.xpath(xpathNextZone)).getText();
			Assert.assertTrue(currentZoneTitle.charAt(0) <= nextZoneTitle.charAt(0));
		}
	}

}
