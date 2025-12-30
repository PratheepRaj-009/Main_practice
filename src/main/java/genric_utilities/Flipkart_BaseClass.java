package genric_utilities;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import vtiger_POM.Login_And_Logout_Vtiger;
import vtiger_POM.Logout_page;

public class Flipkart_BaseClass 
{
	public DataBaseUtilities dbUtil=new DataBaseUtilities();
	public ExcelUtilities xlUtil=new ExcelUtilities();
	public javautils jUtil=new javautils();
	public PropFileUtils propUtil= new PropFileUtils();
	public WebdriverUtilities wbdUtil= new WebdriverUtilities();
	
	

	public WebDriver driver;
	public static WebDriver sdriver;

	@BeforeSuite
	public void Bsuite()
	{
		System.out.println("Before Suite");
	}
	
	@BeforeTest
	public void Btest()
	{
		System.out.println("Before test");
	}
	@BeforeClass
	public void Bclass()
	{
		System.out.println("Before Class");
	}
	
	//Launching the Browser
	//@Parameters("BROWSER")
	@BeforeMethod(alwaysRun = true)
	public void launchBrowser(/*@Optional("chrome") String Browser*/) throws IOException
	{
		//Handling browser pop-ups
		ChromeOptions chromeOpt = new ChromeOptions();
		chromeOpt.addArguments("--diable-notification");
		EdgeOptions edgOpt = new EdgeOptions();
		edgOpt.addArguments("--diable-notification");
		FirefoxOptions fireOpt = new FirefoxOptions();
		fireOpt.addArguments("--diable-notification");

		String Browser = propUtil.readDataFromPropertyFile("browser");
		String Url = propUtil.readDataFromPropertyFile("url");

		if(Browser.contains("chrome"))
		{
			driver=new ChromeDriver(chromeOpt);
		}
		if(Browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver(edgOpt);
		}
		if(Browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver(fireOpt);
		}
		sdriver=driver;

		wbdUtil.maximizeWindow(driver);
		
		//open application
		driver.get("https://www.flipkart.com/");
		wbdUtil.implicitWait(driver, Duration.ofSeconds(10));
		System.out.println("browser launched sucessfully");

	}

	// close the Browser 
	@AfterMethod(alwaysRun = true)
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("browser closed ");
		
	}
	@AfterClass(alwaysRun = true)
	public void aClass()
	{
		System.out.println("After class");
		
	}
	@AfterTest(alwaysRun = true)
	public void aTest()
	{
		System.out.println("After Test ");
		
	}
	@AfterSuite(alwaysRun = true)
	public void aSuite()
	{
		System.out.println("After Suite");
		
	}
	
}