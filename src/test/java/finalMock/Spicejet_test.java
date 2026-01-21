package finalMock;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Spicejet_test 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		Actions act=new Actions(driver);
		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement from = driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']//input[@autocapitalize='sentences']"));
		from.clear();
		Thread.sleep(2000);
		from.sendKeys("bang");
		driver.findElement(By.xpath("//div[.='Kempegowda International Airport']")).click();
		WebElement to = driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']//input[@autocapitalize='sentences']"));
		to.clear();
		to.sendKeys("delhi");
		
		for(;;)
		{
		try {
		driver.findElement(By.xpath("//div[@data-testid='undefined-month-June-2026']"));
		driver.findElement(By.xpath("//div[@data-testid='undefined-month-June-2026']//div[.='10' and @dir='auto']")).click();
		break;
		}
		catch (Exception e) 
		{
			driver.findElement(By.xpath("//*[name()='svg' ]//*[name()='g'  and @transform='translate(1 1)']")).click();
		}
	}
		
		driver.findElement(By.xpath("//div[text()='Passengers']/..//*[name()='svg']")).click();
		driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']//*[name()='svg']")).click();
		WebElement done_btn = driver.findElement(By.xpath("//div[text()='Done']"));
		act.scrollToElement(done_btn).click().build().perform();
		WebElement searchFlight = driver.findElement(By.xpath("//div[text()='Search Flight']"));
		act.moveToElement(searchFlight).click().build().perform();
		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click()",searchFlight );
		//searchFlight.click();
		
		List<WebElement> downarrow = driver.findElements(By.xpath("//div[.='Flight Details' and @id='expand-details' ]/../.."));
		for(WebElement arrow:downarrow)
		{
			System.out.println("for1");
			Thread.sleep(5000);
		js.executeScript("arguments[0].click()", arrow);	
			List<WebElement> flightName = driver.findElements(By.xpath("//div[@class='css-1dbjc4n']/div[@class='css-76zvg2 r-1862ga2']/following-sibling::div[@class='css-76zvg2 r-homxoj r-ubezar']"));
		
		for(WebElement name:flightName)
		{
			System.out.println("for2");
			System.out.println("flight name:"+name.getText());
			List<WebElement> flightNo = driver.findElements(By.xpath("//div[@class='css-1dbjc4n']/div[@class='css-76zvg2 r-1862ga2']/following-sibling::div[@class='css-76zvg2 r-homxoj r-ubezar']"));
			for(WebElement no:flightNo)
			{
				System.out.println("for3");
				System.out.println("flight no"+no.getText());
				break;
			}
		}
		
		}
		
		
		//Thread.sleep(6000);
		//driver.quit();
	}
}

/*Scenario: Go to spicejet website.
Enter from and To
Click on departure date
Select june 10 th
Click on passengers and increase the adult count
Click on search flight button 
And print all the listed flight names and flight number*/
