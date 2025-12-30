package products;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import genric_utilities.BaseClass;
import genric_utilities.ExcelUtilities;
import vtiger_POM.Home_page;

public class CreateProductsTest extends BaseClass
{
	@Test
	public  void createProductsTest() throws IOException {
		//WebDriver driver=null;

//		//random class for dont make the values as duplicate
//		Random ran=new Random();
//		int random = ran.nextInt(100);
//
//		//read the data from properties
//		FileInputStream fis=new FileInputStream("./src/test/resources/files/commonfile.properties");
//		Properties p=new Properties();
//		p.load(fis);
//
//		String BROWSER=p.getProperty("browser");
//		String URL=p.getProperty("url");
//		String USERNAME=p.getProperty("username");
//		String PASSWORD=p.getProperty("password");
//
//		//read the date from excel
//		FileInputStream fi=new FileInputStream("./src/test/resources/files/Testdata.xlsx");
//		Workbook wb = WorkbookFactory.create(fi);
//		Sheet sh=wb.getSheet("Products");
//		String ProductName = sh.getRow(0).getCell(1).getStringCellValue()+random;
		String	ProductName=xlUtil.readDataFromExcel("Products", 0, 1)+jUtil.RandumNumber();
//		
//		//launch the browser
//		if(BROWSER.contains("chrome")) {
//			driver=new ChromeDriver();
//		}
//		else if(BROWSER.contains("firefox")) {
//			driver=new FirefoxDriver();
//		}
//		else {
//			driver=new EdgeDriver();
//		}
//		//maximize the browser window
//		driver.manage().window().maximize();
//		//enter the url
//		driver.get(URL);
//		//wait for to load the page
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//		//step 1: Login to application
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
//
//		//step 2: Navigate to Home Page Click on 'Products' link
//		driver.findElement(By.linkText("Products")).click();
		Home_page hp = new Home_page(driver);
		hp.product_link();
		//step 3: click on Create Products Lookup image
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		//step 4: Enter the 'Product Name' text field
		driver.findElement(By.name("productname")).sendKeys(ProductName);

		//step 5: Click on 'Save' button
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//validating the actual result
		String actual1 = driver.findElement(By.className("lvtHeaderText")).getText();
		if(actual1.contains(ProductName)) {
			System.out.println("Product information page is successfully displayed!");
		}
		else {
			System.out.println("does not exist!");
		}

//		//	Click on 'Administrator
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		//	step 6: Click on 'SignOut'
//		//mousehover on 'signout' link and click on that
//		WebElement signout = driver.findElement(By.linkText("Sign Out"));
//
//		//use actions class to move the element to signout and Click on 'SignOut'
//		Actions act=new Actions(driver);
//		act.moveToElement(signout).click().perform();

	}
}