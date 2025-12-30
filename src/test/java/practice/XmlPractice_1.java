package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class XmlPractice_1 
{
	@Test
	public void readXMLtest(XmlTest test)
	{
		System.out.println(test.getParameter("browser"));
		System.out.println(test.getParameter("url"));
		System.out.println(test.getParameter("username"));
		System.out.println(test.getParameter("password"));
	}
	@Test
	public void launchBrowser(XmlTest br)
	{
		WebDriver driver =new ChromeDriver();
		driver.get(br.getParameter("url"));
		driver.quit();
		
	}
}
