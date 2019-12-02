package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class adminPage {
	 WebDriver driver;

	    @FindBy(name="uid")
	    WebElement user99GuruName;

	    @FindBy(name="password")
	    WebElement password99Guru; 
	    
	    List<WebElement> listOfElements = driver.findElements(By.xpath("//td[@id='sidebar']//li"));
	
	  
	   
	    
	    public adminPage(WebDriver driver){
	    	this.driver = driver;    
	        PageFactory.initElements(driver, this);
	    }


}
