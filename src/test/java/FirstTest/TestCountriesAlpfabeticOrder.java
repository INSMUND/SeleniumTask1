package FirstTest;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCountriesAlpfabeticOrder extends TestBase {

	@Test
	public void countriesOrderTest() {
		loginAdmin();
		driver.findElement(By.xpath("(//ul[@id='box-apps-menu']/li)[3]")).click();
		List<WebElement> listOfCountries = driver.findElements(By.xpath("//tr[@class='row']"));
		int k=0;
		for (int i = 1; i <= listOfCountries.size() - 1; i++) {
			String xpathCurrentCountry = "//tr[@class='row']" + "[" + i + "]" + "//td[5]";
			String currentCountryTitle = driver.findElement(By.xpath(xpathCurrentCountry)).getText();
			k = i + 1;
			String xpathNextCountry = "//tr[@class='row']" + "[" + k + "]" + "//td[5]";
			String nextCountryTitle = driver.findElement(By.xpath(xpathNextCountry)).getText();
			Assert.assertTrue(currentCountryTitle.charAt(0) <= nextCountryTitle.charAt(0));				
			verifyZones(i);
		}
		verifyZones(k);
		System.out.println("Countries are in alphabetic order");
		System.out.println("Zones are in alphabetic order");
	}

	public void verifyZones(int z) {
		
		String xpathCurrentCountryZone = "//tr[@class='row']" + "[" + z + "]" + "//td[6]";
		WebElement zone = driver.findElement(By.xpath(xpathCurrentCountryZone));
		int zoneValue =Character.getNumericValue(zone.getText().trim().charAt(0));		
		if (!(zoneValue==0)) {	
			String xpathCurrentCountryName="//tr[@class='row']" + "[" + z + "]" + "//td[5]";
			System.out.println("Zones order verifying for country "+ driver.findElement(By.xpath(xpathCurrentCountryName)).getText());
			String xpathCurrentCountryZoneEdit = "//tr[@class='row']" + "[" + z + "]" + "//td[7]/a";
			String linkEditCountry=driver.findElement(By.xpath(xpathCurrentCountryZoneEdit)).getAttribute("href");
			driver.get(linkEditCountry);			
			Assert.assertEquals(driver.getTitle(), "Edit Country | My Store");
			List<WebElement> rowsZonesTable = driver.findElements(By.xpath("//table[@id='table-zones']//tr"));
			for (int i = 2; i <= (rowsZonesTable.size() - 2); i++) {
				String xpathCurrentCountry = "//table[@id='table-zones']//tr" + "[" + i + "]" + "//td[3]";
				String currentCountryTitle = driver.findElement(By.xpath(xpathCurrentCountry)).getText();
				int k = i + 1;
				String xpathNextCountry = "//table[@id='table-zones']//tr" + "[" + k + "]" + "//td[3]";
				String nextCountryTitle = driver.findElement(By.xpath(xpathNextCountry)).getText();
				Assert.assertTrue(currentCountryTitle.charAt(0) <= nextCountryTitle.charAt(0));				
			}
			driver.navigate().back();
		}
	}

}
