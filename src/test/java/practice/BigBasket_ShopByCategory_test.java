package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

import genric_utilities.PropFileUtils;
import genric_utilities.WebdriverUtilities;

public class BigBasket_ShopByCategory_test 
{
	public static void main(String[] args) throws IOException 
	{
		Actions act =null;
		WebDriver driver=null;
		ChromeOptions ch_options = new ChromeOptions();
		ch_options.addArguments("--disable-notification");
		EdgeOptions ed_options = new EdgeOptions();
		ed_options.addArguments("--disable-notification");
		FirefoxOptions ff_options = new FirefoxOptions();
		ff_options.addArguments("--disable-notification");
		WebdriverUtilities wbdutil = new WebdriverUtilities();
		
		
		PropFileUtils prop = new PropFileUtils();
		String Browser = prop.readDataFromPropertyFile("browser");
		if(Browser.contains("chrome"))
		{
			 driver = new ChromeDriver(ch_options);
		}
		if(Browser.contains("edge"))
		{
			 driver = new EdgeDriver(ed_options);
		}
		if(Browser.contains("firefox"))
		{
			 driver = new FirefoxDriver(ff_options);
		}
		driver.get("https://www.bigbasket.com/");
		wbdutil.implicitWait(driver, Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//button[@id='headlessui-menu-button-:Ramkj6:']")).click();
		List<WebElement> allcategory = driver.findElements(By.xpath("//button[@id='headlessui-menu-button-:Ramkj6:']/following-sibling::div//li[@role='none']"));
		for(WebElement category:allcategory)
		{
			act= new Actions(driver);
			act.moveToElement(category).perform();
			List<WebElement> subcategories = category.findElements(By.xpath("//button[@aria-controls='headlessui-menu-items-:Rimkj6:']/..//a[@class='sc-eqUAAy fGzcBP']"));
			for(WebElement subcategory:subcategories)
			{
				//subcategory.findElement(By.xpath("//button[@aria-controls='headlessui-menu-items-:Rimkj6:']/..//ul[contains(@class,'jsx-1259984711 w-56 px-2.5 bg-w')]/li"));
				wbdutil.ew_VisibilityOfElement(driver, subcategory, Duration.ofSeconds(10));
				act.moveToElement(subcategory).perform();
				List<WebElement> products = subcategory.findElements(By.xpath("//button[@aria-controls='headlessui-menu-items-:Rimkj6:']/..//ul[contains(@class,'jsx-1259984711 w-56 px-2.5 bg-w')]/li"));
				for(WebElement product:products)
				{
					System.out.println(product.getText());
					
				}
				
			
			}
		
			
		}
	
	}
	
	
	
}