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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentTest;

import vtiger_POM.Home_page;
import vtiger_POM.Login_And_Logout_Vtiger;
import vtiger_POM.Logout_page;

public class BaseClass 
{
	// Inorderto access this class from outside the package we make the variables as "public"
	public DataBaseUtilities dbUtil=new DataBaseUtilities();
	public ExcelUtilities xlUtil=new ExcelUtilities();
	public javautils jUtil=new javautils();
	public PropFileUtils propUtil= new PropFileUtils();
	public WebdriverUtilities wbdUtil= new WebdriverUtilities();
	
	

	public WebDriver driver;
	//public static WebDriver sdriver;
	public static ThreadLocal<WebDriver> wdriver = new ThreadLocal<WebDriver>();

	// connect to Database
	@BeforeSuite(alwaysRun = true)
	public void connectToDB() throws SQLException
	{
		dbUtil.connectToDB();
		System.out.println("DataBase connected succesfully");
	}

	//Launching the Browser
	@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser(@Optional("chrome") String Browser) throws IOException
	{
		//Handling browser pop-ups
		ChromeOptions chromeOpt = new ChromeOptions();
		chromeOpt.addArguments("--diable-notification");
		EdgeOptions edgOpt = new EdgeOptions();
		edgOpt.addArguments("--diable-notification");
		FirefoxOptions fireOpt = new FirefoxOptions();
		fireOpt.addArguments("--diable-notification");

		//String Browser = propUtil.readDataFromPropertyFile("browser");
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
		
		wdriver.set(driver);

		wbdUtil.maximizeWindow(driver);
		
		//open application
		driver.get(Url);
		wbdUtil.implicitWait(driver, Duration.ofSeconds(10));
		System.out.println("browser launched sucessfully");

	}

	Login_And_Logout_Vtiger log;

	//login to Application
	
	
	@BeforeMethod(alwaysRun = true)
	public void loginToApp() throws IOException
	{
		String UN = propUtil.readDataFromPropertyFile("username");
		String PWD = propUtil.readDataFromPropertyFile("password");

		Login_And_Logout_Vtiger log = new Login_And_Logout_Vtiger(driver);
		log.login(UN, PWD);
		
		System.out.println("logged in successfully");

	}

	//logout from application

	@AfterMethod(alwaysRun = true)
	public void logoutFromApp() throws InterruptedException
	{
		
		Thread.sleep(2000);
		Logout_page lg = new Logout_page(driver);
		lg.logoutJSE(driver,wbdUtil);
		System.out.println("logged out successfully ");

	}
	// close the Browser 
	@AfterClass(alwaysRun = true)
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("browser closed ");
		wdriver.remove();
		
	}
	//Disconnect the Database
	@AfterSuite(alwaysRun = true)
	public void disConnectDB() throws SQLException
	{
		dbUtil.disconnectDB();
		System.out.println("DataBase Disconnected");
	}


}
