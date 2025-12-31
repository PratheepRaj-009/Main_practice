package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Cmdlyn_Practice_1 
{
	@Test
	public void cmdLine()
	{
		String Browser=System.getProperty  ("browser");
		String Url=System.getProperty("url");
		String UN=System.getProperty("username");
		String PWD=System.getProperty("password");
		System.out.println(Browser);
		System.out.println(Url);
		System.out.println(UN);
		System.out.println(PWD);
		if(Browser.equals("chrome"))
		{
		WebDriver driver = new ChromeDriver();
		driver.get(Url);
		System.out.println(driver.getTitle());
		}
		
	}
}
