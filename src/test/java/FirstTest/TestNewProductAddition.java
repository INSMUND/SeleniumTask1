package FirstTest;

import java.io.File;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import managers.PageObjectManager;
import pageObjects.AddNewProductPage;
import pageObjects.AdminPage;
import pageObjects.MainPageProduct;

public class TestNewProductAddition extends TestBase {
		

	private PageObjectManager pageObjectManager;
	private AddNewProductPage addNewProductPage;
	private String productNameGenerated;
	
	@Test
	public void addNewProductTest() {
		loginAdmin();
		WebDriverWait wait = new WebDriverWait(driver,30);	
		driver.findElement(By.xpath("//td[@id='sidebar']//li[2]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@id='content']//a[2]")));
		driver.findElement(By.xpath("//td[@id='content']//a[2]")).click();		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='tabs']//li[@class='active']")).getText(),"General");
		pageObjectManager = new PageObjectManager(driver);
		addNewProductPage = pageObjectManager.getAddNewProductPage();
		fillGeneralTab();			
		addNewProductPage.getInformationTab().click();
		wait.until(ExpectedConditions.visibilityOf(addNewProductPage.getManufacturer())  );
		fillManufacturerTab();
		addNewProductPage.getPricesTab().click();
		wait.until(ExpectedConditions.visibilityOf(addNewProductPage.getPurchasePrice())  );
		fillPricesTab();
		addNewProductPage.getSaveButton().click();
		driver.findElement(By.xpath("//li[@id='doc-catalog']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(), 'Rubber Airplane')]")).isDisplayed());
		System.out.println("Product"+" "+productNameGenerated+ "is created");
		}
	private void fillGeneralTab() {
		addNewProductPage.getEnabledRadioButton().click();
		FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-GB"), new RandomService());
		productNameGenerated="Rubber Airplane"+" "+fakeValuesService.bothify("???");
		addNewProductPage.getName().sendKeys(productNameGenerated);
		addNewProductPage.getCode().sendKeys("RA12443342");
		addNewProductPage.getUnisexProductGroup().click();
		addNewProductPage.getQuantity().sendKeys("100");
		String relativePath = "src/test/resources/Image.png";
		uploadFile(addNewProductPage.getChooseFileToUploadButton(), getFilePathByFormat(relativePath));
		addNewProductPage.getDateValidFrom().sendKeys("12/03/2020");
		addNewProductPage.getDateValidTo().sendKeys("12/05/2020");
	}
	private void fillManufacturerTab() {
		addNewProductPage.getManufacturer().sendKeys("ACME Corp.");
		addNewProductPage.getKeywords().sendKeys("Toys");
		addNewProductPage.getDescription().sendKeys("Rubber toys for babies swimming");
		addNewProductPage.getHeadTitle().sendKeys("Rubber Airplane");
		addNewProductPage.getMetaDescription().sendKeys("Rubber toys");		
	}
	private void fillPricesTab() {
		addNewProductPage.getPurchasePrice().sendKeys("3.00");
		addNewProductPage.getPurchasePriceCurrencyCode().sendKeys("Euros");
		addNewProductPage.getPricesUSD().sendKeys("10");
		addNewProductPage.getPricesEUR().sendKeys("8");
	}
	public String getFilePathByFormat(String filePath) {
        File file = new File(filePath);
        return file.getAbsolutePath();
    }
	public void uploadFile(WebElement webElement, String filePath){
        try {
          
            webElement.sendKeys(getFilePathByFormat(filePath));
        }catch (Exception e) {
        	System.out.println("Disable to download file");
        }
    }
}
