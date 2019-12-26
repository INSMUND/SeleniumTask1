package pageObjects;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Product {
	WebDriver driver;
	By productName = By.xpath("//h1[@class='title']");
	By regularPrice = By.xpath("//s[@class='regular-price']");
	By actionPrice = By.xpath("//strong[@class='campaign-price']");
	By addCartProduct = By.xpath("//button[@name='add_cart_product']");
	By optionsSize = By.xpath("//select[@name='options[Size]']");
	By homeLink=By.xpath("//div[@class='content']//a[@href='/litecart/']");

	public Product(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getOptionsSize() {
		return driver.findElement(optionsSize);
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

	public WebElement getAddCartProduct() {
		return driver.findElement(addCartProduct);
	}
	
	public WebElement getHomeLink() {
		return driver.findElement(homeLink);
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
	public void fillSizeIfRequired(String size) {
		try {
			getOptionsSize().sendKeys("Small");
		} catch (Exception e) {
			System.out.println("Product without Sale sticker was selected");
		}
	}
	public void addToCart() {
		int initialCartSize=getQuantityProductsOnCart();
		getAddCartProduct().click();
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath("//div[@id='cart']//span[@class='quantity']"), Integer.toString(initialCartSize+1)));
		System.out.println("Product" + getProductName().getText() + "successfully added to cart");
	}
	
   public int getQuantityProductsOnCart(){
	   String quantity=driver.findElement(By.xpath("//div[@id='cart']//span[@class='quantity']")).getText();
	   int quantityValue=Integer.parseInt(quantity);
	   return quantityValue;
   }
   
   public void goToHomePage() {
	   getHomeLink().click();
   }
   
}
