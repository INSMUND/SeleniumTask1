package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	WebDriver driver;
	By listOfItems = By.xpath("//tr//td[@class='item']");
	By removeProductButton=By.xpath("//li[@class='item'][1]//button[@name='remove_cart_item']");
	
	

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	public List<WebElement> getListOfItemsOnCart() {
		return driver.findElements(listOfItems);
	}
	
	public WebElement getRemoveProductButton() {
		return driver.findElement(removeProductButton);
	}
	
	public Integer getNumberOfProductPositionsOnCart() {
		return getListOfItemsOnCart().size();
	}
	
	public void removeItem() {
		getRemoveProductButton().click();
	}
	
	public void removeItemFromCart() {
		int initialCartSize=getNumberOfProductPositionsOnCart();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(getRemoveProductButton())   );
		getRemoveProductButton().click();
		
		wait.until(
				ExpectedConditions.numberOfElementsToBe(listOfItems, initialCartSize - 1));
	
	System.out.println("Product successfully deleted from Cart");
	}

}
