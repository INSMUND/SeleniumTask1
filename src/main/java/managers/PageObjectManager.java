package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.Product;
import pageObjects.AddNewProductPage;
import pageObjects.CreateAccountPage;
import pageObjects.MainPageProduct;

public class PageObjectManager {
	private WebDriver driver;
	private MainPageProduct mainPageProduct;
	private CreateAccountPage createAccountPage ;
	private Product product;
	private AddNewProductPage addNewProductPage;
	

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
	
	public CreateAccountPage getCreateAccountPage() {
		return (createAccountPage == null) ? createAccountPage = new CreateAccountPage(driver)
				: createAccountPage;
	}
	
	public AddNewProductPage getAddNewProductPage() {
		return (addNewProductPage == null) ? addNewProductPage = new AddNewProductPage(driver) : addNewProductPage;
	}

	

}
