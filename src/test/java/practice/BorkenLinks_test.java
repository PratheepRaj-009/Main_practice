package practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BorkenLinks_test 
{
	public static void main(String[] args) throws IOException 
	{
		String expexted_value = "Portable Charger";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//h2[text()='Form']"))).perform();
		List<WebElement> multi_link = driver.findElements(By.xpath("//a[contains(.,'Errorcode')]"));
		for(WebElement link:multi_link)
		{
			@Nullable
			String href = link.getDomAttribute("href");
			URL url = new URL(href);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			int res_code = conn.getResponseCode();
		if(res_code>=400)
		{
			System.out.println(href+"-->code is "+res_code);
		}
		else
		{
			System.out.println(href+"-->code is "+res_code);
		}
		}
	
		
	}

}
