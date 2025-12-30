package document;

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
import org.testng.Assert;
import org.testng.annotations.Test;

import genric_utilities.BaseClass;
import genric_utilities.ExcelUtilities;
import genric_utilities.PropFileUtils;
import genric_utilities.WebdriverUtilities;
import genric_utilities.javautils;
import vtiger_POM.CreateDoc_page;
import vtiger_POM.CreateNewDoc_page;
import vtiger_POM.Home_page;
import vtiger_POM.Login_And_Logout_Vtiger;

public class CreateNewDoc_Test extends BaseClass
{
	@Test(groups = "smoke")
	public  void createNewDoc_Test() throws IOException 
	{
		

//		//utilities class object:
//		WebdriverUtilities wdu = new WebdriverUtilities();
//		PropFileUtils propObj = new PropFileUtils();
//		ExcelUtilities xlu = new ExcelUtilities();
//		javautils javaU = new javautils();
//		
//		
//		String Browser = propObj.readDataFromPropertyFile("browser");
//		String Url = propObj.readDataFromPropertyFile("url");
//		String UN = propObj.readDataFromPropertyFile("username");
//		String PWD = propObj.readDataFromPropertyFile("password");
//	
//		String Name = xlu.readDataFromExcel("Organization", 0, 1);
//		String IndDD = xlu.readDataFromExcel("Organization", 1, 1);
//		int random = javaU.RandumNumber();
//		String OrgName = Name+random;
//		//Handling browser pop-ups
//				ChromeOptions chromeOpt = new ChromeOptions();
//				chromeOpt.addArguments("--diable-notification");
//				EdgeOptions edgOpt = new EdgeOptions();
//				edgOpt.addArguments("--diable-notification");
//				FirefoxOptions fireOpt = new FirefoxOptions();
//				fireOpt.addArguments("--diable-notification");
//		//open application 
//		
//		WebDriver driver=null;
//		
//		if(Browser.contains("chrome"))
//		{
//			driver=new ChromeDriver(chromeOpt);
//		}
//		if(Browser.equalsIgnoreCase("edge"))
//		{
//			driver=new EdgeDriver(edgOpt);
//		}
//		if(Browser.equalsIgnoreCase("firefox"))
//		{
//			driver=new FirefoxDriver(fireOpt);
//		}
//		wdu.maximizeWindow(driver);
//		//open application
//		driver.get(Url);
//		wdu.implicitWait(driver, Duration.ofSeconds(10));
//		@Nullable
//		String parentId = driver.getWindowHandle();
//		
////	Login to application 
//		Login_And_Logout_Vtiger login = new Login_And_Logout_Vtiger(driver);
//		login.login(UN, PWD);
//	"Navigate to Homepage click on Organization link"
		String docName="Customer"+jUtil.RandumNumber();
		Home_page hp = new Home_page(driver);
		hp.clickOnDocLink();
		CreateDoc_page docPg = new CreateDoc_page(driver);
		docPg.clikOnLookupbtn();
		CreateNewDoc_page newDocPg = new CreateNewDoc_page(driver);
		newDocPg.creatNewDocument(docName);
		//Assert.fail();
	}
}
