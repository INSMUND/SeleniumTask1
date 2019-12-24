package FirstTest;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import managers.PageObjectManager;
import pageObjects.MainPageProduct;
import pageObjects.Product;

public class ProductsToCartAddition extends TestBase{
	PageObjectManager pageObjectManager;
	Product product;
	MainPageProduct mainPageProduct;
	
	
	@Test
	public void productToCartAdditionTest() {
	loginLitecart();
	pageObjectManager = new PageObjectManager(driver);
    for (int i=1;i<4;i++) {
    	addProductToCart(i);
	}
    mainPageProduct=pageObjectManager.getMainPageProduct();
    mainPageProduct.getCheckout().click();
   
    List<WebElement> listOfItemsOnCart = driver.findElements(By.xpath("//tr//td[@class='item']"));
    Integer initialCartSize=listOfItemsOnCart.size();
	for (int i = 1; i <= initialCartSize ; i++) {	 
//	  driver.findElement(By.xpath("//li[@class='item'][1]")).click();
	  driver.findElement(By.xpath("//li[@class='item'][1]//button[@name='remove_cart_item']")).click();
	  WebDriverWait wait = new WebDriverWait(driver,60);
	    wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//tr//td[@class='item']"), initialCartSize-i)    );  
	}
    
	}
	private void addProductToCart(int i) {
		driver.findElement(By.xpath("//div[@id='box-most-popular']//li[1]")).click();
		product = pageObjectManager.getProduct();		
		try
	    {
			product.getOptionsSize().sendKeys("Small");
	    }
	    catch(Exception e)
	    {
	       System.out.println("Product without Sale sticker was selected");
	    }
		 product.getAddCartProduct().click();
		    WebDriverWait wait = new WebDriverWait(driver,100);
		    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='cart']//span[@class='quantity']"), Integer.toString(i)));  
		    System.out.println("Product" +product.getProductName().getText()+ "successfully added to cart");
		    driver.navigate().back();
	}

}
