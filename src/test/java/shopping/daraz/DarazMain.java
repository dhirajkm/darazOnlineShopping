package shopping.daraz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DarazMain {
	
	public static Properties darazConfig = new Properties();
	public static Properties darazOR = new Properties();
	public static FileInputStream fis;
	public static WebDriver driver = null;
	
	public void resourceSetup() {
		try {
			fis = new FileInputStream("./src/test/resources/proptertyFiles/darazProperties/darazConfig.properties");
			darazConfig.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fis = new FileInputStream("./src/test/resources/proptertyFiles/darazProperties/darazOR.properties");
			darazConfig.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void initializeBrowser(String browser, String url) {
		if(browser.equalsIgnoreCase("opera")){
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else {
			System.out.println("driver not found");
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		String wait = darazConfig.getProperty("wait");
		long l = Long.parseLong(wait);
		driver.manage().timeouts().implicitlyWait(l, TimeUnit.SECONDS);
	}

	
//	@DataProvider
//	public Object [][] getData(Method m) throws IOException{
//		
//		File f = new File("./src/test/resources/ExcelFiles/darazData.xlsx");
//		FileInputStream fis = new FileInputStream(f);
//		Workbook wb = new XSSFWorkbook(fis);
//		Sheet sh = wb.getSheet(m.getName());
//		int totalRows = sh.getPhysicalNumberOfRows();
//		int totalCells = sh.getRow(0).getLastCellNum();
//		System.out.println("total number of rows"+totalRows);
//		System.out.println("total number of columns"+totalCells);
//		
//		Object data [][] = new Object [totalRows-1] [totalCells];
//		
//		for(int i=1; i<totalRows; i++ ) {
//			for(int j=0; j<totalCells; j++ ) {
//				data [i-1][j]=sh.getRow(i).getCell(j).getStringCellValue();
//			}
//		}
//			
//		wb.close();		
//		return data;
//	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	
}