package FirstTest;

import java.util.HashMap;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import dataProviders.UserData;

import managers.PageObjectManager;
import pageObjects.CreateAccountPage;
import pageObjects.MainPageProduct;

public class TestNewUserRegistration extends TestBase {
	PageObjectManager pageObjectManager;
	MainPageProduct mainPageProduct;
	CreateAccountPage createAccountPage;
	UserData userData;

	@Test
	public void newUserRegistrationTest() {
		loginLitecart();
		pageObjectManager = new PageObjectManager(driver);
		mainPageProduct = pageObjectManager.getMainPageProduct();
		mainPageProduct.getNewCustomerRegstrationLik().click();
		createAccountPage = pageObjectManager.getCreateAccountPage();
		userData = new UserData();
		generateUserData();
		fillCreateAccountForm();
		createAccountPage.getNewsletterFlag().click();
		createAccountPage.getCreateAccountButton().click();
		WebElement logout=driver.findElement(By.xpath("//div[@id='box-account']//a[contains(text(),'Logout')]"));
		Assert.assertTrue(logout.isDisplayed());
		System.out.println("User account is created");
		driver.get(logout.getAttribute("href"));
		login();		
		WebElement logoutExistingUser=driver.findElement(By.xpath("//div[@id='box-account']//a[contains(text(),'Logout')]"));
		Assert.assertTrue(logoutExistingUser.isDisplayed());
		System.out.println("Existing user can login");
		driver.get(logoutExistingUser.getAttribute("href"));		
       
	}

	private void fillCreateAccountForm() {
		createAccountPage.getTaxID().sendKeys(userData.getTaxID());
		createAccountPage.getCompany().sendKeys(userData.getCompany());
		createAccountPage.getFirstname().sendKeys(userData.getFirstname());
		createAccountPage.getLastname().sendKeys(userData.getLastName());
		createAccountPage.getAddress1().sendKeys(userData.getAddress1());
		createAccountPage.getPostcode().sendKeys("TW2 7LD");
		createAccountPage.getCity().sendKeys(userData.getCity());
		createAccountPage.getCountryCode().sendKeys(userData.getCountry());
		createAccountPage.getEmail().sendKeys(userData.getEmail());
		createAccountPage.getPhone().sendKeys(userData.getPhone());
		createAccountPage.getPasswordConfirm().sendKeys(userData.getPassword());
		createAccountPage.getPasswordDesired().sendKeys(userData.getPassword());

	}

	private void generateUserData() {
		Faker ukFake = new Faker(Locale.UK);
		userData.setPostcode(ukFake.address().zipCode());
		userData.setAddress1(ukFake.address().streetName() + " " + ukFake.address().buildingNumber());
		userData.setCity(ukFake.address().city());
		FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-GB"), new RandomService());
		userData.setEmail(fakeValuesService.bothify("????##@gmail.com"));
		userData.setTaxID(fakeValuesService.bothify("#########"));
		userData.setCompany("Blue Industries");
		userData.setFirstname("John");
		userData.setLastName("Doe");
		userData.setCountry("United Kingdom");
		userData.setPhone(fakeValuesService.bothify("############"));
		userData.setPassword("Selenium2019");
	}
	 private void login() {
		 mainPageProduct.getEmail().sendKeys(userData.getEmail()); 
		 mainPageProduct.getPassword().sendKeys(userData.getPassword());
		 mainPageProduct.getLogin().click();
	 }

}
