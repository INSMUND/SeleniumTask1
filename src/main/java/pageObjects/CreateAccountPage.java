package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccountPage {
	WebDriver driver;
	By taxID = By.xpath("//input[@name='tax_id']");
	By company = By.xpath("//input[@name='company']");
	By firstname = By.xpath("//input[@name='firstname']");
	By lastname = By.xpath("//input[@name='lastname']");
	By address1 = By.xpath("//input[@name='address1']");
	By postcode = By.xpath("//input[@name='postcode']");
	By city = By.xpath("//input[@name='city']");
	By countryCode = By.xpath("//select[@name='country_code']");
	By email = By.xpath("//input[@name='email']");
	By phone = By.xpath("//input[@name='phone']");
	By passwordDesired = By.xpath("//input[@name='password']");
	By passwordConfirm = By.xpath("//input[@name='confirmed_password']");	
	By newsletterFlag = By.xpath("//input[@name='newsletter']");
	By createAccountButton = By.xpath("//button[@name='create_account']");
	

	public CreateAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getCreateAccountButton() {
		return driver.findElement(createAccountButton);
	}
	
	public WebElement getNewsletterFlag() {
		return driver.findElement(newsletterFlag);
	}

	public WebElement getTaxID() {
		return driver.findElement(taxID);
	}

	public WebElement getCompany() {
		return driver.findElement(company);
	}

	public WebElement getFirstname() {
		return driver.findElement(firstname);
	}

	public WebElement getLastname() {
		return driver.findElement(lastname);
	}

	public WebElement getAddress1() {
		return driver.findElement(address1);
	}

	public WebElement getPostcode() {
		return driver.findElement(postcode);
	}

	public WebElement getCity() {
		return driver.findElement(city);
	}

	public WebElement getCountryCode() {
		return driver.findElement(countryCode);
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getPhone() {
		return driver.findElement(phone);
	}

	public WebElement getPasswordDesired() {
		return driver.findElement(passwordDesired);
	}

	public WebElement getPasswordConfirm() {
		return driver.findElement(passwordConfirm);
	}
}
