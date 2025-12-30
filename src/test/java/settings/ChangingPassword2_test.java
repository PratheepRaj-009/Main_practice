package settings;

import java.io.IOException;
import java.time.Duration;

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
import vtiger_POM.ChangePassword_page;
import vtiger_POM.Home_page;
import vtiger_POM.Login_And_Logout_Vtiger;
import vtiger_POM.Logout_page;

public class ChangingPassword2_test extends BaseClass
{
	@Test
	public  void changingPassword2_test() throws IOException 
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
		String NewPWD = propUtil.readDataFromPropertyFile("newpassword");
		String ConNewPWD = propUtil.readDataFromPropertyFile("confirmnewpassword");
//		
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
//				
//		//open browser
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
//		
//		wdu.implicitWait(driver, Duration.ofSeconds(10));
//		
		String parentId = driver.getWindowHandle();
		String expTitle="ChangePassword&form";
////		Login to application 
//		Login_And_Logout_Vtiger login = new Login_And_Logout_Vtiger(driver);
//		login.login(UN, PWD);
//		Mouse hover to 'Administrator' icon and Click on 'My preferance'
		Home_page hp = new Home_page(driver);
		hp.mypreferance();
//		Click on 'Change Password' Enter data into 'New Password' and 'Confirm password' text field and click on 'Save' button
		ChangePassword_page cpwd = new ChangePassword_page(driver);
		cpwd.changeNewPassword(wbdUtil, driver, expTitle,NewPWD,ConNewPWD);
		wbdUtil.switchToParentWindow(driver, parentId);
		//logout
//		Logout_page logout = new Logout_page(driver);
//		logout.logout(driver);

	}
}
