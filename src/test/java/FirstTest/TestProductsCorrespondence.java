package FirstTest;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import managers.PageObjectManager;
import pageObjects.MainPageProduct;
import pageObjects.Product;

public class TestProductsCorrespondence extends TestBase {
	PageObjectManager pageObjectManager;
	MainPageProduct mainPageProduct;
	Product product;
	HashMap<String, String> productOnMainPageProperties;
	HashMap<String, String> productProperties;

	@Test
	public void correspondenceProductsTest() {
		loginLitecart();
		pageObjectManager = new PageObjectManager(driver);
		fillDataProductOnMainPage();
		driver.findElement(By.xpath("//div[@id='box-campaigns']//li[1]")).click();
		fillDataProduct();
		System.out.println("Product name on main page=" + productOnMainPageProperties.get("ProductName"));
		System.out.println("Product name on product page=" + productProperties.get("ProductName"));
		Assert.assertEquals(productOnMainPageProperties.get("ProductName"), productProperties.get("ProductName"));
		System.out.println("Regular price on main page=" + productOnMainPageProperties.get("RegularPrice"));
		System.out.println("Regular price on product page=" + productProperties.get("RegularPrice"));
		Assert.assertEquals(productOnMainPageProperties.get("RegularPrice"), productProperties.get("RegularPrice"));
		System.out.println("Action price on main page=" + productOnMainPageProperties.get("ActionPrice"));
		System.out.println("Action price on product page=" + productProperties.get("ActionPrice"));
		Assert.assertEquals(productOnMainPageProperties.get("ActionPrice"), productProperties.get("ActionPrice"));
		System.out.println("Color of products  regular price on main page is "
				+ productOnMainPageProperties.get("ColorRegularPrice"));
		Assert.assertEquals("gray", productOnMainPageProperties.get("ColorRegularPrice"));
		System.out.println(
				"Color of products regular price on product page is " + productProperties.get("ColorRegularPrice"));
		Assert.assertEquals("gray", productProperties.get("ColorRegularPrice"));
		System.out.println("Color of products  action price on main page is "
				+ productOnMainPageProperties.get("ColorActionPrice"));
		Assert.assertEquals("red", productOnMainPageProperties.get("ColorActionPrice"));
		System.out.println(
				"Color of products action price on product page is " + productProperties.get("ColorActionPrice"));
		Assert.assertEquals(productProperties.get("ColorActionPrice"), "red");
		System.out.println("Text decoration for regular price on main page is "
				+ productOnMainPageProperties.get("RegularPriceTextDecoration"));
		Assert.assertEquals(productOnMainPageProperties.get("RegularPriceTextDecoration").trim(), "line-through");
		System.out.println("Text decoration for regular price on product page is "
				+ productProperties.get("RegularPriceTextDecoration"));
		Assert.assertEquals("line-through", productProperties.get("RegularPriceTextDecoration").trim());
		System.out.println("Font size of product regular price on main page is  "
				+ Float.parseFloat(productOnMainPageProperties.get("FontSizeRegularPrice")));
		System.out.println("Font size of product action price on main page is  "
				+ Float.parseFloat(productOnMainPageProperties.get("FontSizeActionPrice")));
		Assert.assertTrue(Float.parseFloat(productOnMainPageProperties.get("FontSizeRegularPrice")) < Float
				.parseFloat(productOnMainPageProperties.get("FontSizeActionPrice")));
		System.out.println("Font size of product regular price on product page is  "
				+ Float.parseFloat(productProperties.get("FontSizeRegularPrice")));
		System.out.println("Font size of product action price on product page is  "
				+ Float.parseFloat(productProperties.get("FontSizeActionPrice")));
		Assert.assertTrue(Float.parseFloat(productProperties.get("FontSizeRegularPrice")) < Float
				.parseFloat(productProperties.get("FontSizeActionPrice")));
		Assert.assertEquals("18", productOnMainPageProperties.get("FontSizeActionPrice"));
		Assert.assertEquals("22", productProperties.get("FontSizeActionPrice"));

	}

	private void fillDataProductOnMainPage() {
		mainPageProduct = pageObjectManager.getMainPageProduct();
		productOnMainPageProperties = new HashMap<String, String>();
		productOnMainPageProperties.put("ProductName", mainPageProduct.getProductName().getText());
		productOnMainPageProperties.put("RegularPrice", mainPageProduct.getRegularPrice().getText());
		productOnMainPageProperties.put("ActionPrice", mainPageProduct.getActionPrice().getText());
		if ((mainPageProduct.getRGBColorsValuesRegularPrice().get("R")
				.equals(mainPageProduct.getRGBColorsValuesRegularPrice().get("G")))
				&& (mainPageProduct.getRGBColorsValuesRegularPrice().get("B")
						.equals(mainPageProduct.getRGBColorsValuesRegularPrice().get("G"))))

			productOnMainPageProperties.put("ColorRegularPrice", "gray");
		else
			productOnMainPageProperties.put("ColorRegularPrice", "not gray");

		if ((mainPageProduct.getRGBColorsValuesActionPrice().get("G")
				.equals(mainPageProduct.getRGBColorsValuesActionPrice().get("B")))
				&& (mainPageProduct.getRGBColorsValuesActionPrice().get("B").equals("0"))) {
			productOnMainPageProperties.put("ColorActionPrice", "red");
		} else
			productOnMainPageProperties.put("ColorActionPrice", "not red");
		productOnMainPageProperties.put("RegularPriceTextDecoration", mainPageProduct.getTextDecorationRegularPrice());
		productOnMainPageProperties.put("FontSizeActionPrice", mainPageProduct.getFontSizeActionPrice());
		productOnMainPageProperties.put("FontSizeRegularPrice", mainPageProduct.getFontSizeRegularPrice());
	}

	private void fillDataProduct() {
		product = pageObjectManager.getProduct();
		productProperties = new HashMap<String, String>();
		productProperties.put("ProductName", product.getProductName().getText());
		productProperties.put("RegularPrice", product.getRegularPrice().getText());
		productProperties.put("ActionPrice", product.getActionPrice().getText());
		if ((product.getRGBColorsValuesRegularPrice().get("R")
				.equals(product.getRGBColorsValuesRegularPrice().get("G")))
				&& (product.getRGBColorsValuesRegularPrice().get("B")
						.equals(product.getRGBColorsValuesRegularPrice().get("G"))))

			productProperties.put("ColorRegularPrice", "gray");
		else
			productProperties.put("ColorRegularPrice", "not gray");

		if ((product.getRGBColorsValuesActionPrice().get("G").equals(product.getRGBColorsValuesActionPrice().get("B")))
				&& (product.getRGBColorsValuesActionPrice().get("B").equals("0"))) {
			productProperties.put("ColorActionPrice", "red");
		} else
			productProperties.put("ColorActionPrice", "not red");
		productProperties.put("RegularPriceTextDecoration", product.getTextDecorationRegularPrice());
		productProperties.put("FontSizeActionPrice", product.getFontSizeActionPrice());
		productProperties.put("FontSizeRegularPrice", product.getFontSizeRegularPrice());
	}
}
