package FirstTest;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import managers.PageObjectManager;
import pageObjects.CartPage;
import pageObjects.MainPageProduct;
import pageObjects.Product;

public class TestProductsToCartAdditionPageObjectUsing extends TestBase {
	PageObjectManager pageObjectManager;
	Product product;
	MainPageProduct mainPageProduct;
    CartPage cartPage;
    
	@Test
	public void productToCartAdditionTest() {
		loginLitecart();
		pageObjectManager = new PageObjectManager(driver);
		mainPageProduct = pageObjectManager.getMainPageProduct();
		for (int i = 1; i < 4; i++) {
			addProductToCart();
		}
		mainPageProduct = pageObjectManager.getMainPageProduct();
		mainPageProduct.navigateToCartPage();	
		cartPage=pageObjectManager.getCartPage();
		Integer initialCartSize =cartPage.getNumberOfProductPositionsOnCart();
		System.out.println(initialCartSize);
		for (int i = 1; i <= initialCartSize; i++) {
			cartPage=pageObjectManager.getCartPage();
			cartPage.removeItemFromCart();			
		}
		int afterRemovingCartSize=cartPage.getNumberOfProductPositionsOnCart();
		Assert.assertEquals(0,afterRemovingCartSize);
		System.out.println("All products are successfully deleted from Cart");
	}

	private void addProductToCart() {	
		mainPageProduct = pageObjectManager.getMainPageProduct();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		mainPageProduct.selectProductFromMostPopular();
		product = pageObjectManager.getProduct();
		product.fillSizeIfRequired("Small");		
		product.addToCart();
		product.goToHomePage();
	}

}
