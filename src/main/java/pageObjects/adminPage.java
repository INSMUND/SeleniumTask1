package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
	 WebDriver driver;

	  
	    
	    List<WebElement> listOfElements = driver.findElements(By.xpath("//td[@id='sidebar']//li"));
	    
	    By catalogButton = By.xpath("//td[@id='sidebar']//li[2]");
	    		
	   
	    
	    public AdminPage(WebDriver driver){
	    	this.driver = driver;    
	        PageFactory.initElements(driver, this);
	    }
	    
	    public WebElement getCatalogButton() {
			return driver.findElement(catalogButton);
		}


}
