package settings;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import genric_utilities.BaseClass;
import genric_utilities.PropFileUtils;
import vtiger_POM.Currencies_page;
import vtiger_POM.Home_page;
import vtiger_POM.Login_And_Logout_Vtiger;
import vtiger_POM.NewCurrency_page;
import vtiger_POM.Settings_page;

public class AddingNewCurrency_test extends BaseClass
{
	@Test
	public void addingNewCurrency_test() throws IOException
	{
		
		
//		Login to application 
//		Login_And_Logout_Vtiger Vpom = new Login_And_Logout_Vtiger(driver);
//		Vpom.login(UN,PWD);
//		Mouse hover to 'Settings ' icon and Click on 'CRM Settings'
//		Actions act=new Actions(driver);
//		WebElement settings = driver.findElement(By.xpath("//img[@src='themes/softed/images/mainSettings.PNG']"));
//		act.moveToElement(settings).click().perform();
//		driver.findElement(By.xpath("//a[text()='CRM Settings']")).click();
		Home_page hp = new Home_page(driver);
		hp.clickOnCrmSetting();
		
		//Click on 'Currencies' on 'Other settings' division
		//driver.findElement(By.xpath("//a[contains(.,'Currencies')]")).click();
		new Settings_page(driver).ckickOnCurrencies();
		//click on New Currency
		new Currencies_page(driver).clickOnNewCurrency();
		//driver.findElement(By.xpath("//input[@value='New Currency']")).click();
		
     //Click on 'Currency Name' Dropdown and select curency name
			String country="Australia, Dollars($)";
			String value="20";
		new NewCurrency_page(driver).addNewCurrency(country,value);
		
//		WebElement curency_dd = driver.findElement(By.name("currency_name"));
//		Select currency_S = new Select(curency_dd);
//		String country="India, Rupees(₨)";
//		currency_S.selectByVisibleText(country);
//		Enter the data into all the fields and click on 'Save' button
//		driver.findElement(By.xpath("//input[@name='conversion_rate']")).sendKeys("64");
//		driver.findElement(By.xpath("//td[@align='right']/input[@value='Save']")).click();
		List<WebElement> eles = driver.findElements(By.xpath("//td[text()='Currency Name']/ancestor::table[@class='listTable']//td/b"));
		for(WebElement ele:eles)
		{
			String text = ele.getText();
			System.out.println(text);
			if(country.contains(text))
			{
				System.out.println("Currency Added Successfully");
				break;
			}
		}
		//Sign out
//		Vpom.signOut(driver);
//		driver.quit();

	}
}
