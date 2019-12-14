package FirstTest;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestStickersArePresented extends TestBase {

	@Test
	public void stickersArePresentedTest() {
		loginLitecart();
		List<WebElement> listOfProducts = driver
				.findElements(By.xpath("//li[@class='product column shadow hover-light']"));
		for (int i = 1; i <= listOfProducts.size(); i++) {
			String xpathProduct = "(//li[@class='product column shadow hover-light'])" + "[" + i + "]";
			WebElement Product = driver.findElement(By.xpath(xpathProduct));
			Assert.assertTrue(Product.isDisplayed());
			String xpathProductTitle = "(//li[@class='product column shadow hover-light'])" + "[" + i + "]"
					+ "//div[@class='name']";
			System.out
					.println("Web element " + driver.findElement(By.xpath(xpathProductTitle)).getText() + " is found");
			String xpathProductSticker = "(//li[@class='product column shadow hover-light'])" + "[" + i + "]"
					+ "//div[contains(@class,'sticker')]";
			WebElement ProductSticker = driver.findElement(By.xpath(xpathProductSticker));
			Assert.assertTrue(ProductSticker.isDisplayed());
			System.out.println("Product sticker  " + ProductSticker.getText() + "  for element is displayed");
		}
	}

}
