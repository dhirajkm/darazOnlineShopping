package shopping.daraz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestElectronicDevices extends DarazMain {
	
	@BeforeSuite
	public void callSetup () {
		super.resourceSetup();
	}
	
	@BeforeMethod
	public void launchBrowser() {
		initializeBrowser(darazConfig.getProperty("browser"), darazConfig.getProperty("url"));
	}
	
	@Test (priority = 1)
	public void verifyHomePage() {
		String actualTitle = driver.getTitle();
		String expectedTitle = darazConfig.getProperty("title");
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	
	@Test (priority = 2)
	public void electronicDevices() {
//		WebElement mouseHover = null;
//		Actions act = new Actions(driver);
//		act.moveToElement(mouseHover).perform();
		driver.findElement(By.cssSelector("ul[data-spm-anchor-id='a2a0e.11779170.8018372580.cate.395d2d2bUqovir']"));
		driver.findElement(By.id("li[id=Level_1_Category_No1]"));
		driver.findElement(By.xpath("//li[@class='lzd-site-menu-sub-item'][@data-cate='cate_1_1']"));
		driver.findElement(By.xpath("//ul[@class='lzd-site-menu-grand'][@data-spm='cate_1_1']"));
		driver.findElement(By.xpath("//li[@class='lzd-site-menu-grand-item']/a[@data-spm-anchor-id='a2a0e.11779170.cate_1_1.1']")).click();
		
	}
	
	@AfterMethod
	public void exitBrowser() {
		closeBrowser();
	}
	
	
}
