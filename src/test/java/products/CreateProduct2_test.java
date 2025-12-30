package products;

import java.io.IOException;
import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

import genric_utilities.BaseClass;
import genric_utilities.ExcelUtilities;
import genric_utilities.PropFileUtils;
import genric_utilities.WebdriverUtilities;
import genric_utilities.javautils;
import vtiger_POM.CreateNewProduct_page;
import vtiger_POM.CreateProduct_page;
import vtiger_POM.Home_page;
import vtiger_POM.Login_And_Logout_Vtiger;
import vtiger_POM.Logout_page;

public class CreateProduct2_test extends BaseClass
{
	@Test
	
		public  void createProduct2_test() throws IOException, InterruptedException 
		{
			//utilities class object:
//			WebdriverUtilities wdu = new WebdriverUtilities();
//			PropFileUtils propObj = new PropFileUtils();
//			ExcelUtilities xlu = new ExcelUtilities();
//			javautils javaU = new javautils();
//			
//			
//			String Browser = propObj.readDataFromPropertyFile("browser");
//			String Url = propObj.readDataFromPropertyFile("url");
//			String UN = propObj.readDataFromPropertyFile("username");
//			String PWD = propObj.readDataFromPropertyFile("password");
//		
			String productname = xlUtil.readDataFromExcel("Products", 0, 1)+jUtil.RandumNumber();
//			//String IndDD = xlu.readDataFromExcel("Organization", 1, 1);
//			int random = javaU.RandumNumber();
//			String productname = Name+random;
//			//Handling browser pop-ups
//					ChromeOptions chromeOpt = new ChromeOptions();
//					chromeOpt.addArguments("--diable-notification");
//					EdgeOptions edgOpt = new EdgeOptions();
//					edgOpt.addArguments("--diable-notification");
//					FirefoxOptions fireOpt = new FirefoxOptions();
//					fireOpt.addArguments("--diable-notification");
//			//open application 
//			
//			WebDriver driver=null;
//			
//			if(Browser.contains("chrome"))
//			{
//				driver=new ChromeDriver(chromeOpt);
//			}
//			if(Browser.equalsIgnoreCase("edge"))
//			{
//				driver=new EdgeDriver(edgOpt);
//			}
//			if(Browser.equalsIgnoreCase("firefox"))
//			{
//				driver=new FirefoxDriver(fireOpt);
//			}
//			wdu.maximizeWindow(driver);
//			//open application
//			driver.get(Url);
//			wdu.implicitWait(driver, Duration.ofSeconds(10));
//			@Nullable
			String parentId = driver.getWindowHandle();
//			
////		Login to application 
//			Login_And_Logout_Vtiger login = new Login_And_Logout_Vtiger(driver);
//			login.login(UN, PWD);
//		"Navigate to Homepage click on Organization link"
			Home_page hp = new Home_page(driver);
			hp.product_link();
		
//			click on Create Products Lookup image
			new CreateProduct_page(driver).createProdyctLookUp();
//			Enter the 'Product Name' text field and Click on 'Save' button
			new CreateNewProduct_page(driver).addProduct(driver,productname);
			
//			logout
		//	new Logout_page(driver).logout(driver);
			

	}
}
