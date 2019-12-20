package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.Product;
import pageObjects.MainPageProduct;

public class PageObjectManager {
	private WebDriver driver;
	private MainPageProduct mainPageProduct;
	private Product product;
	

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public MainPageProduct getMainPageProduct() {
		return (mainPageProduct == null) ? mainPageProduct = new MainPageProduct(driver) : mainPageProduct;
	}

	public Product getProduct() {
		return (product == null) ? product = new Product(driver)
				: product;
	}

	

}
