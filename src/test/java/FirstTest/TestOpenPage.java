package FirstTest;

import org.junit.Assert;
import org.junit.Test;
import java.util.concurrent.TimeUnit;

public class TestOpenPage extends TestBase {

	@Test
	public void myFirstTest() {

		driver.get(configFileReader.getApplicationUrl());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "PESOTO");
	}
}
