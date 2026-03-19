package practice;

import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import genric_utilities.WebdriverUtilities;
import redbus.Rating;

public class RedBus_pooja 
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
		
	/**	driver.findElement(By.xpath("//div[@class='travelsName___023aae' and text()='VSR Tours and Travels']")).click();
		
		int available=0;
		int sold=0;
		List<WebElement> seats = driver.findElements(By.xpath("//div[contains(@class,'canvaswrapper')]//span[contains(@aria-label,'Seat number')]/span[contains(@class,'sleeper')]"));
		
		for(WebElement seat:seats)
		{
			
			//boolean value = seat.isEnabled();
			String value = seat.getText();
			if(value.equals("Sold"))
			{
				
				sold++;
			}
			else
			{
				available++;
			}
		}
		
		System.out.println("Available seats: "+available);
		System.out.println("Sold seats: "+sold);*/
		
		
		
		
		//System.out.println(driver.findElement(By.xpath("//div[contains(@class,'chip___')]")).getAttribute("aria-label"));
//		
		//driver.findElement(By.xpath("//div[contains(@class,'chip___')]")).click();
		//WebElement rate1 = null;
//		double larg=1;
//		for(WebElement rate:ratings)
//		{
//			String text = rate.getText();
//			double no=Double.parseDouble(text);
//			
//			if(larg>no)
//			{
//				larg=no;
//				rate1=rate;
//				System.out.println(text);
//			}
//			
//		}
		
//		rate1.click();
		
		Rating ra = new Rating(driver);
		
		ra.getHighestRating();
		
		
		Thread.sleep(5000);
		driver.quit();
	}
}
