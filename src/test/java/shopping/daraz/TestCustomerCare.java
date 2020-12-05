package shopping.daraz;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCustomerCare extends DarazMain {

	@BeforeMethod
	public void launchBrowser() {
		initializeBrowser(darazConfig.getProperty("browser"), darazConfig.getProperty("url"));
	}
	
	@Test
	public void customerCare() {
		
		driver.findElement(By.cssSelector("div[class='lzd-customcare-popup top-popup-wrap']"));
		driver.findElement(By.id("div[id=topActionCustomCare]")).click();;
		driver.findElement(By.xpath("//a[@data-spm-anchor-id='a2a0e.11779170.header.5']")).click();
		driver.findElement(By.xpath("//input[@data-spm-anchor-id='0.0.0.i0.d07f4300RhqCG8']")).clear();
		driver.findElement(By.xpath("//input[@data-spm-anchor-id='0.0.0.i0.d07f4300RhqCG8']")).sendKeys("How to find a product?", Keys.ENTER);
		
	}
	
	@AfterMethod
	public void exitBrowser() {
		closeBrowser();
	}
}
