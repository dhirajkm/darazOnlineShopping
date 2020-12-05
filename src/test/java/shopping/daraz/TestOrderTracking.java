package shopping.daraz;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestOrderTracking extends DarazMain {
	
	@BeforeMethod
	public void launchBrowser() {
		initializeBrowser(darazConfig.getProperty("browser"), darazConfig.getProperty("url"));
	}
	
	@Test
	public void trackMyOrder() {
		
		driver.findElement(By.cssSelector("span[data-spm-anchor-id='a2a0e.11779170.header.i0.395d2d2bUqovir']")).click();
		driver.findElement(By.cssSelector("div[class='top-popup-content lzd-track-content']"));
		driver.findElement(By.cssSelector("input[id='topActionTrackEmail']")).clear();
		driver.findElement(By.cssSelector("input[id='topActionTrackEmail']")).sendKeys("m.dhiraj2296@gmail.com", Keys.ENTER);
	
	}
	
	@AfterMethod
	public void exitBrowser() {
		closeBrowser();
	}
	

}
