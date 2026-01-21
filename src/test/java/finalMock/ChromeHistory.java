package finalMock;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ChromeHistory
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		Actions act=new Actions(driver);
		driver.get("chrome://history/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		SearchContext host1 = driver.findElement(By.id("history-app")).getShadowRoot();
		SearchContext host2 = host1.findElement(By.cssSelector("history-toolbar[id='toolbar']")).getShadowRoot();
		SearchContext host3 = host2.findElement(By.cssSelector("cr-toolbar[id='mainToolbar']")).getShadowRoot();
		SearchContext host4 = host3.findElement(By.cssSelector("cr-toolbar-search-field[id='search']")).getShadowRoot();
		//SearchContext host5 = host4.findElement(By.cssSelector("cr-icon-button[id='icon']")).getShadowRoot();
		host4.findElement(By.cssSelector("input[id='searchInput']")).sendKeys("hello");
		
	}
	
}
