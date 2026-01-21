package finalMock;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoAppProductAddToCart 
{
	public static void main(String[] args) 
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/ui?scenario=1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//section[.='Popups']")).click();
		driver.findElement(By.xpath("//section[.='Browser Windows']")).click();
		driver.findElement(By.xpath("//a[.='Multiple Windows']")).click();
		driver.findElement(By.xpath("//button[.='Shop Now']")).click();

		String parentTitle = driver.getTitle();
		Set<String> allWindow = driver.getWindowHandles();
		for(String window:allWindow)
		{

			String childtitle = driver.switchTo().window(window).getTitle();
			if(childtitle.contains("Luxury Watch"))
			{
				String productName = driver.findElement(By.xpath("//h1")).getText();
				driver.findElement(By.xpath("//button[.='Add to Cart']")).click();
				
				driver.findElement(By.xpath("//*[name()='svg']")).click();
				String cartProduct = driver.findElement(By.xpath("//h3")).getText();
				if(productName.equals(cartProduct))
				{
					System.out.println("product is added to cart");
				}
				
				break;
				
			}
				
		}
	}
}
//