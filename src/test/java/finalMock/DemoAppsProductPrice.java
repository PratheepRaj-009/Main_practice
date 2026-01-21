package finalMock;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoAppsProductPrice 
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
			if(!parentTitle.equals(childtitle))
			{
				
			List<WebElement> product = driver.findElements(By.xpath("//h1|//p[3]"));
			for(WebElement pro:product)
			{

				System.out.println(pro.getText());
			}
			}
		}
		driver.quit();
	}
}
