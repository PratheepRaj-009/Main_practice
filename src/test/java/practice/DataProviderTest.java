package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vtiger_POM.Login_And_Logout_Vtiger;

public class DataProviderTest 
{
	@Test(dataProvider = "storedata")
	public void getData(String UN,String PWD)
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
	Login_And_Logout_Vtiger login = new Login_And_Logout_Vtiger(driver);
	login.login(UN, PWD);
	driver.quit();
		
	}
	
	@Test(dataProvider = "Tools")
	public void softwareTesting(String Tname,String AppName)
	{
		
		System.out.println(Tname+"  " + AppName);
		
	}
	
	
	@DataProvider
	public Object[][] storedata()
	{
		Object[][] obj = new Object[2][2];
		
		obj[0][0]="admin";
		obj[0][1]="admin";
		
		obj[1][0]="admin";
		obj[1][1]="password";
		
		return obj;
	}
	
	@DataProvider(name = "Tools")
	public Object[][] testing()
	{
		Object[][] obj = new Object[2][2];
		
		obj[0][0]="Selenium";
		obj[0][1]="Web Application";
		
		obj[1][0]="Appium";
		obj[1][1]="Mobile Application";
		return obj;
		
	}
	@DataProvider(name="Softwares")
	public Object[][] software() throws EncryptedDocumentException, IOException
	{
		 FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\files\\Testdata.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Softwares");
		int rowCount = sheet.getLastRowNum()+1;
		int cellCount = sheet.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[rowCount][cellCount];
		
		for(int i=0; i<rowCount; i++)
		{
			for(int j=0; j<cellCount; j++)
			{
				obj[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
		
	}
	
}
