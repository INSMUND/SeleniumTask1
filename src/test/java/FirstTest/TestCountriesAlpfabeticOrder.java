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
		for (int i = 1; i <= listOfCountries.size()-1; i++) {
			String xpathCurrentCountry="//tr[@class='row']" + "[" + i + "]"+"//td[5]";
			String currentCountryTitle=driver.findElement(By.xpath(xpathCurrentCountry)).getText();
			int k=i+1;
			String xpathNextCountry="//tr[@class='row']" + "[" + k + "]"+"//td[5]";
			String nextCountryTitle=driver.findElement(By.xpath(xpathNextCountry)).getText();
			Assert.assertTrue (currentCountryTitle.charAt(0)<=nextCountryTitle.charAt(0));		
			
		}
	}

	
	

}
