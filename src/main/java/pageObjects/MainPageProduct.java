package pageObjects;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPageProduct {
	WebDriver driver;
	By productName = By.xpath("//div[@id='box-campaigns']//div[@class='name'][1]");
	By regularPrice = By.xpath("//div[@id='box-campaigns']//s[@class='regular-price'][1]");
	By actionPrice = By.xpath("//div[@id='box-campaigns']//strong[@class='campaign-price'][1]");
	

	public MainPageProduct(WebDriver driver) {
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
		fontSize.replace("px", "").trim();
		return fontSize.replace("px", "").trim();
	}
	public String getFontSizeRegularPrice() {
		String fontSize = driver.findElement(regularPrice).getCssValue("font-size");
		fontSize.replace("px", "").trim();
		return fontSize.replace("px", "").trim();
	}
	
	public String getTextDecorationRegularPrice() {
		String textDecoration=driver.findElement(regularPrice).getCssValue("text-decoration");
		String[] textDecorationValues = driver.findElement(regularPrice).getCssValue("text-decoration").split(" ");
		return textDecorationValues[0].trim();
		
		
	}
	
}
