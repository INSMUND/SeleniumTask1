package FirstTest;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestAdminSidebar extends TestBase {

	@Test
	public void adminSidebarTest() {

		List<WebElement> listOfMenuItems = driver.findElements(By.xpath("//ul[@id='box-apps-menu']/li"));
		for (int i = 1; i <= listOfMenuItems.size(); i++) {
			String xpathMenuItem = "(//ul[@id='box-apps-menu']/li)" + "[" + i + "]";
			WebElement menuItem = driver.findElement(By.xpath(xpathMenuItem));
			menuItem.click();
			WebElement titleElement = driver.findElement(By.xpath("//td[@id='content']/h1"));
			String titleValue = titleElement.getText();
			Assert.assertFalse("H1 title " + titleValue + " is not presented", titleValue.isEmpty());
			System.out.println("H1 title " + titleValue + " is presented on page " + driver.getCurrentUrl());
			handleInnerMenu(xpathMenuItem);
			driver.navigate().back();
		}
	}

	private void handleInnerMenu(String xpathMenuItem) {
		String xpathListSubMenuElements = xpathMenuItem + "//li";
		List<WebElement> listOfSubMenuItems = driver.findElements(By.xpath(xpathListSubMenuElements));
		for (int i = 2; i <= listOfSubMenuItems.size(); i++) {
			String xpathSubMenuItem = xpathListSubMenuElements + "[" + i + "]";
			WebElement subMenuItem = driver.findElement(By.xpath(xpathSubMenuItem));
			subMenuItem.click();
			WebElement titleElement = driver.findElement(By.xpath("//td[@id='content']/h1"));
			String titleValue = titleElement.getText();
			Assert.assertFalse("Inner menu H1 title " + titleValue + " is not presented", titleValue.isEmpty());
			System.out.println("Inner menu H1 title " + titleValue + " is presented on page " + driver.getCurrentUrl());
			driver.navigate().back();
		}
	}

}
