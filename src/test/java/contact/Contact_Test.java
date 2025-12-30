package contact;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genric_utilities.BaseClass;
import genric_utilities.ExcelUtilities;
import genric_utilities.PropFileUtils;
import genric_utilities.WebdriverUtilities;
import genric_utilities.javautils;
import vtiger_POM.Contact_page;
import vtiger_POM.CreateContact_page;
import vtiger_POM.CreateOrg_page;
import vtiger_POM.Home_page;
import vtiger_POM.Login_And_Logout_Vtiger;
import vtiger_POM.Logout_page;
import vtiger_POM.Organization_page;

@Listeners(genric_utilities.ListernersImplementationClass.class)
public class Contact_Test extends BaseClass
{
	
	@Test(invocationCount = 1)
	public void orgtwithMadatoryAndInd_test() throws IOException, InterruptedException 
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

		//wdu.switchToParentWindow(driver, parentTitle);

		//	click on 'save'button
		ctOrgpg.save(driver);
		System.out.println("1st method executed");
		//Thread.sleep(8000);
//		WebElement oldElement = driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.stalenessOf(oldElement));

		//logout
//		Logout_page logout = new Logout_page(driver);
//		logout.logout(driver);
		//driver.quit();
//		Assert.fail();
		
		
	}


	@Test( priority = -1)
	public  void contactwithMadatoryFields_test() throws IOException, InterruptedException 
	{
		String parentId = driver.getWindowHandle();
		String exptitle="Accounts&action";
		String orgName = xlUtil.readDataFromExcel("Organization", 0, 1);
		String lastName = xlUtil.readDataFromExcel("Organization", 2, 1)+jUtil.RandumNumber();
		Home_page hp = new Home_page(driver);
		hp.clickContat();
		Contact_page conPg = new Contact_page(driver);
		conPg.ClickCreateContactLoockUpButton();
		CreateContact_page createontactPg = new CreateContact_page(driver);
		createontactPg.enterValueIntoTextfield(lastName, driver);
		createontactPg.selectOrganization(wbdUtil, driver, exptitle, orgName, parentId);
		createontactPg.save(driver);
		System.out.println("2nd method executed");

	}

}



//driver.findElement(By.xpath("//a[text()='Contacts']")).click();
//driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
//driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lase_name);
//driver.findElement(By.xpath("//img[@alt='Select']")).click();
////switching child window
//
//Set<String> allIDs = driver.getWindowHandles();
//for(String ID:allIDs)
//	if (!ID.equals(HostID)) {
//		driver.switchTo().window(ID);   // switch to child
//	}
//driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys("Testyantra");
//driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
//driver.switchTo().window(HostID);
////			WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
//			w.until(ExpectedConditions.elementToBeSelected(By.xpath("//input[@title='Save [Alt+S]']")));
//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//vpom.signOut(driver);
//driver.quit();
