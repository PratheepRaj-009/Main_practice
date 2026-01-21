package finalMock;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Kayak_in 
{
	public static void main(String[] args) 
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.kayak.co.in/flights");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions act =new Actions(driver);
		driver.findElement(By.xpath("//div[@class='Uqct-title']/span[contains(.,'Return')]")).click();
		driver.findElement(By.id("oneway")).click();
		driver.findElement(By.xpath("//*[name()='svg' and @class='c_neb-item-icon']")).click();
		driver.findElement(By.xpath("//input[@aria-label='Origin location']")).sendKeys("chennai");
		driver.findElement(By.xpath("//span[contains(.,'Chennai, Tamil Nadu, India')]")).click();
		driver.findElement(By.xpath("//input[@aria-label='Destination location']")).sendKeys("new delhi");
		driver.findElement(By.xpath("//span[contains(.,'New Delhi, National Capital Territory of India, India')]")).click();
		driver.findElement(By.xpath("//span[contains(.,'Departure') and @class='yx0f-placeholder']")).click();
		driver.findElement(By.xpath("//div[contains(@aria-label,'February 10 2026')]")).click();
		driver.findElement(By.xpath("//span[contains(.,'Search')]")).click();
		//List<WebElement> allprice = driver.findElements(By.xpath("//div[@class='e2GB-price-text']"));
		List<WebElement> alltiming = driver.findElements(By.xpath("//div[@class='vmXl vmXl-mod-variant-large']|//div[@class='e2GB-price-text']"));
		int count = alltiming.size();
		int i=1;
		for(WebElement timing:alltiming)
		{
			i++;
			for( ;i<=count; )
			{
			if(i%2==0)
			{
			System.out.println("timing : "+timing.getText());
			}
			if(i%2==1)
			{
				System.out.println("price : "+timing.getText());
			}
			break;
		}
		}
	}
}
