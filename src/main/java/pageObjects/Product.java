package pageObjects;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Product {
	WebDriver driver;
	By productName = By.xpath("//h1[@class='title']");
	By regularPrice = By.xpath("//s[@class='regular-price']");
	By actionPrice = By.xpath("//strong[@class='campaign-price']");
	
	public Product(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getProductName() {
		return driver.findElement(productName);
	}

	public WebElement getRegularPrice() {
		return driver.findElement(regularPrice);
	}

	public WebElement getActionPrice() {
		return driver.findElement(actionPrice);
	}

	public HashMap<String, String> getRGBColorsValuesActionPrice() {
		HashMap<String, String> mainPageProductRGBColors = new HashMap<String, String>();
		String color = driver.findElement(actionPrice).getCssValue("Color");		
		String[] hexValue = color.replace("rgb(", "").replace(")", "").split(",");
		mainPageProductRGBColors.put("R", hexValue[0].trim());
		mainPageProductRGBColors.put("G", hexValue[1].trim());
		mainPageProductRGBColors.put("B", hexValue[2].trim());
		return mainPageProductRGBColors;
	}

	public HashMap<String, String> getRGBColorsValuesRegularPrice() {
		HashMap<String, String> mainPageProductRGBColors = new HashMap<String, String>();
		String color = driver.findElement(regularPrice).getCssValue("Color");
		String[] hexValue = color.replace("rgb(", "").replace(")", "").split(",");
		mainPageProductRGBColors.put("R", hexValue[0].trim());
		mainPageProductRGBColors.put("G", hexValue[1].trim());
		mainPageProductRGBColors.put("B", hexValue[2].trim());
		return mainPageProductRGBColors;
	}
	public String getFontSizeActionPrice() {
		String fontSize = driver.findElement(actionPrice).getCssValue("font-size");	
		return fontSize.replace("px", "").trim();
	}
	public String getFontSizeRegularPrice() {
		String fontSize = driver.findElement(regularPrice).getCssValue("font-size");		
		return fontSize.replace("px", "").trim();
	}
	
	public String getTextDecorationRegularPrice() {		
		String[] textDecorationValues = driver.findElement(regularPrice).getCssValue("text-decoration").split(" ");
		return textDecorationValues[0].trim();
	}
}
