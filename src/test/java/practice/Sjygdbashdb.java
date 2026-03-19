package practice;

import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genric_utilities.WebdriverUtilities;

public class Sjygdbashdb 
{
	WebdriverUtilities wdUtils=new WebdriverUtilities();
	
	@Test
	public void test1() throws InterruptedException
	{
		int a=6;
		int b=a+8;
		WebDriver driver = new ChromeDriver();
		wdUtils.maximizeWindow(driver);
		driver.get("https://www.redbus.in/");
		wdUtils.implicitWait(driver, 15);
		driver.findElement(By.id("srcinput")).sendKeys("Banga");
		driver.findElement(By.xpath("//div[@aria-label='Bangalore']")).click();
		driver.findElement(By.id("destinput")).sendKeys("Hyderabad");
		driver.findElement(By.xpath("//div[@aria-label='Hyderabad']")).click();
		WebElement cal = driver.findElement(By.xpath("//div[contains(@class,'dojWrapper')]"));
		wdUtils.movetoelementAndClick(driver, cal);
//		Date date = new Date();
//		date.
		driver.findElement(By.xpath("//span[@aria-hidden='true' and text()='"+b+"']")).click();
		driver.findElement(By.xpath("//button[@aria-label='Search buses']")).click();
		List<WebElement> ratings = driver.findElements(By.xpath("//div[contains(@class,'rating__')]"));
		
		int larg=1;
		for(WebElement rate:ratings)
		{
			String text = rate.getText();
			int no=Integer.parseInt(text);
			
			if(larg>no)
			{
				larg=no;
			}
			
		}
		
		System.out.println(larg);
		
		
		
		
		Thread.sleep(5000);
		driver.quit();
	}
}
