package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddNewProductPage {
	WebDriver driver;
	By enabledRadioButton = By.xpath("//input[@name='status'][1]");
	By name = By.xpath("//input[@name='name[en]']");
	By code = By.xpath("//input[@name='code']");
	By unisexProductGroup = By.xpath("//input[@name='product_groups[]'][@value='1-3']");
	By quantity = By.xpath("//input[@name='quantity']");
	By chooseFileToUploadButton = By.xpath("//input[@name='new_images[]']");
	By dateValidFrom = By.xpath("//input[@name='date_valid_from']");
	By dateValidTo = By.xpath("//input[@name='date_valid_to']");
		
	By informationTab = By.xpath("//div[@class='tabs']//li[2]");
	By manufacturer = By.xpath("//select[@name='manufacturer_id']");	
	By supplier = By.xpath("//select[@name='supplier_id']");
	By keywords = By.xpath("//input[@name='keywords']");
	By description = By.xpath("//input[@name='short_description[en]']");
	By headTitle = By.xpath("//input[@name='head_title[en]']");
	By metaDescription = By.xpath("//input[@name='meta_description[en]']");
	
	By pricesTab = By.xpath("//div[@class='tabs']//li[4]");
	By purchasePrice = By.xpath("//input[@name='purchase_price']");
	By purchasePriceCurrencyCode = By.xpath("//select[@name='purchase_price_currency_code']");	
	By pricesUSD = By.xpath("//input[@name='prices[USD]']");
	By pricesEUR = By.xpath("//input[@name='prices[EUR]']");
	By priceInclTaxUSDNumber= By.xpath("//input[@name='gross_prices[USD]']");
	By priceInclTaxEURNumber = By.xpath("//input[@name='gross_prices[EUR]']");
	By saveButton = By.xpath("//button[@name='save']");
	
	public AddNewProductPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getEnabledRadioButton() {
		return driver.findElement(enabledRadioButton);
	}

	public WebElement getName() {
		return driver.findElement(name);
	}

	public WebElement getCode() {
		return driver.findElement(code);
	}

	public WebElement getUnisexProductGroup() {
		return driver.findElement(unisexProductGroup);
	}

	public WebElement getQuantity() {
		return driver.findElement(quantity);
	}

	public WebElement getChooseFileToUploadButton() {
		return driver.findElement(chooseFileToUploadButton);
	}

	public WebElement getDateValidFrom() {
		return driver.findElement(dateValidFrom);
	}

	public WebElement getDateValidTo() {
		return driver.findElement(dateValidTo);
	}

	public WebElement getInformationTab() {
		return driver.findElement(informationTab);
	}

	public WebElement getManufacturer() {
		return driver.findElement(manufacturer);
	}

	public WebElement getSupplier() {
		return driver.findElement(supplier);
	}

	public WebElement getKeywords() {
		return driver.findElement(keywords);
	}

	public WebElement getDescription() {
		return driver.findElement(description);
	}

	public WebElement getHeadTitle() {
		return driver.findElement(headTitle);
	}

	public WebElement getMetaDescription() {
		return driver.findElement(metaDescription);
	}

	public WebElement getPricesTab() {
		return driver.findElement(pricesTab);
	}

	public WebElement getPurchasePrice() {
		return driver.findElement(purchasePrice);
	}

	public WebElement getPurchasePriceCurrencyCode() {
		return driver.findElement(purchasePriceCurrencyCode);
	}

	public WebElement getPricesUSD() {
		return driver.findElement(pricesUSD);
	}

	public WebElement getPricesEUR() {
		return driver.findElement(pricesEUR);
	}

	public WebElement getPriceInclTaxUSDNumber() {
		return driver.findElement(priceInclTaxUSDNumber);
	}

	public WebElement getPriceInclTaxEURNumber() {
		return driver.findElement(priceInclTaxEURNumber);
	}

	public WebElement getSaveButton() {
		return driver.findElement(saveButton);
	}
	
	
	
	
}
