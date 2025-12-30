package contact;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Base64;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import genric_utilities.BaseClass;
import genric_utilities.ExcelUtilities;
import genric_utilities.PropFileUtils;
import genric_utilities.javautils;
import vtiger_POM.Contact_page;
import vtiger_POM.CreateContact_page;
import vtiger_POM.Home_page;
import vtiger_POM.Login_And_Logout_Vtiger;

public class ContactwithMadatoryFields_test extends BaseClass
{
	@Test(groups = "smoke")
	public  void contactwithMadatoryFields_test() throws IOException, InterruptedException 
	{
		//		//object creation
		//		WebDriver driver=null;
		//		PropFileUtils propsObj = new PropFileUtils();
		//		ExcelUtilities xl_util = new ExcelUtilities();
		//		javautils j_utils = new javautils();
		//		
		//		
		//		//Handling browser pop-ups
		//		ChromeOptions chromeOpt = new ChromeOptions();
		//		chromeOpt.addArguments("--diable-notification");
		//		EdgeOptions edgOpt = new EdgeOptions();
		//		edgOpt.addArguments("--diable-notification");
		//		FirefoxOptions fireOpt = new FirefoxOptions();
		//		fireOpt.addArguments("--diable-notification");
		//		
		//		//fetching data from property file
		////		FileInputStream fis = new FileInputStream("./src/test/resources/files/commonfile.properties");
		////		Properties prop = new Properties();
		////		prop.load(fis);
		//		String Browser =propsObj.readDataFromPropertyFile("browser");
		//		String Url =propsObj.readDataFromPropertyFile("url");
		//		String UN =propsObj.readDataFromPropertyFile("username");
		//		String PWD =propsObj.readDataFromPropertyFile("password");
		//		
		//		int random = j_utils.RandumNumber();
		String lase_name = xlUtil.readDataFromExcel("Organization", 2, 1)+jUtil.RandumNumber();
		//		
		//		//		Login to application 
		//		if(Browser.equalsIgnoreCase("chrome"))
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
		//		
		//		driver.manage().window().maximize();// maximize the window.
		//		driver.get(Url);//launching the application.
		//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//Synchronization
		//		Login_And_Logout_Vtiger vpom = new Login_And_Logout_Vtiger(driver);
		//		vpom.login(UN, PWD);


		//click on contact link

		Home_page hp = new Home_page(driver);
		hp.clickContat();

		//click on Create Contact LoockUp Button
		new Contact_page(driver).ClickCreateContactLoockUpButton();

		//Enter valid data 
		new CreateContact_page(driver).enterValueIntoTextfield(lase_name, driver);
		Assert.fail();
		//			

	}
}