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
		List<WebElement> listOfProducts = driver.findElements(By.xpath("//li[contains(@class,'product')]/a[@class='link']"));
		for (int i = 0; i < listOfProducts.size(); i++) {
			WebElement product = listOfProducts.get(i);
			Assert.assertTrue(product.isDisplayed());
			String productTitle = product.getAttribute("title");
			System.out.println("Web element " + productTitle + " is found");
			List<WebElement> listOfStickers = product.findElements(By.xpath(".//div[contains(@class,'sticker')]"));
			int quantityOfStickersOnCurrentElement = listOfStickers.size();
			System.out.println("Product " + productTitle + "  has " + quantityOfStickersOnCurrentElement + "stickers");
			Assert.assertTrue(quantityOfStickersOnCurrentElement < 2);
		}
	}

}
