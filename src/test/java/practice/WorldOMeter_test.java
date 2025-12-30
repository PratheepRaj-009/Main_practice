package practice;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import genric_utilities.WebdriverUtilities;

public class WorldOMeter_test 
{
	public static void main(String[] args) 
	{
		WebdriverUtilities wdu = new WebdriverUtilities();
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.worldometers.info/geography/countries-of-the-world/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String expvalue="Food & Agriculture";
		driver.findElement(By.id("menu-button-5")).click();
		List<WebElement> menuItems = driver.findElements(By.xpath("//a[@role='menuitem']"));
		
		for(WebElement item:menuItems)
		{
			String text = item.getText();
			
			if(text.contains(expvalue))
			{
				item.click();
				break;
			}
			
	
		}
		driver.findElement(By.xpath("//div[@class='col-span-3']//li/a[contains(.,'India')]")).click();
		driver.findElement(By.xpath("//*[name()='svg']//*[text()='Number of Undernourished in India']/..")).click();
		List<WebElement> dots = driver.findElements(By.xpath("//*[name()='svg']//*[@class='highcharts-markers highcharts-series-0 highcharts-spline-series highcharts-tracker']//*[@class='highcharts-point' and @fill='#FF3300']"));
		for(WebElement dot:dots)
		{
			wdu.movetoelement(driver, dot);
		String text = driver.findElement(By.xpath("//*[name()='svg']//*[@class='highcharts-br']/..")).getText();
		System.out.println(text);
		}
	driver.quit();	
	}
}
