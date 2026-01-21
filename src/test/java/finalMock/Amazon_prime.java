package finalMock;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Amazon_prime 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		Actions act=new Actions(driver);
		driver.get("https://www.amazon.in/chrome://history/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		try {
			List<WebElement> elements = driver.findElements(By.xpath("https://www.amazon.in/"));
			for(WebElement ele:elements)
			{
				System.out.println(ele.getAttribute("href"));
			}
		
		}
		catch (Exception e) 
		{
			driver.findElement(By.xpath("//a[@href='/ref=cs_404_link']")).click();
			List<WebElement> elements = driver.findElements(By.xpath("//span[text()='Prime']/../../../following-sibling::li"));
			for(WebElement ele:elements)
			{
				System.out.println(ele.getAttribute("class"));
			}
		}
		
		
	}
	
}
