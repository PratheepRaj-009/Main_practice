package contact;

import java.io.IOException;
import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import genric_utilities.BaseClass;
import genric_utilities.ExcelUtilities;
import genric_utilities.PropFileUtils;
import genric_utilities.WebdriverUtilities;
import genric_utilities.javautils;
import vtiger_POM.CreateOrg_page;
import vtiger_POM.Home_page;
import vtiger_POM.Login_And_Logout_Vtiger;
import vtiger_POM.Logout_page;
import vtiger_POM.Organization_page;

public class ContactwithMadatoryAndInd_test extends BaseClass
{
	@Test
	public void contactwithMadatoryAndInd_test() throws IOException, InterruptedException 
	{
//		//utilities class object:
		WebdriverUtilities wdu = new WebdriverUtilities();
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
		String oldOrgName = xlUtil.readDataFromExcel("Organization", 0, 1);
		String orgName = xlUtil.readDataFromExcel("Organization", 0, 1)+jUtil.RandumNumber();
		String IndDD = xlUtil.readDataFromExcel("Organization", 1, 1);
		
		
//		//Handling browser pop-ups
//		ChromeOptions chromeOpt = new ChromeOptions();
//		chromeOpt.addArguments("--diable-notification");
//		EdgeOptions edgOpt = new EdgeOptions();
//		edgOpt.addArguments("--diable-notification");
//		FirefoxOptions fireOpt = new FirefoxOptions();
//		fireOpt.addArguments("--diable-notification");
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
		String parentId = driver.getWindowHandle();
//
//		//	Login to application 
//		Login_And_Logout_Vtiger login = new Login_And_Logout_Vtiger(driver);
//		login.login(UN, PWD);
		
		
		//	"Navigate to Homepage click on Organization link"
		Home_page hp = new Home_page(driver);
		hp.clickOrg();
		//	Click on create Organization lookup button
		Organization_page orgpg = new Organization_page(driver);
		orgpg.clickOrganizationLookupBtn();
		//	Enter all mandatory fields with valid data 	"Click on 'Industry' dropdown And selec 'Biotechnology'  dfrom dropdown"

		String expTitle="Accounts&action";
		CreateOrg_page ctOrgpg = new CreateOrg_page(driver);
		ctOrgpg.mandAndDDvalue(wdu, orgName, IndDD);

		//select organization
		ctOrgpg.selectOrganization(wdu, driver, expTitle, oldOrgName,parentId);

		wdu.switchToParentWindow(driver, parentId);

		//	click on 'save'button
		ctOrgpg.save(driver);
		//Thread.sleep(8000);
//		WebElement oldElement = driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.stalenessOf(oldElement));

		//logout
//		Logout_page logout = new Logout_page(driver);
//		logout.logout(driver);
		//driver.quit();
		//Assert.fail();
		
		
	}
}
