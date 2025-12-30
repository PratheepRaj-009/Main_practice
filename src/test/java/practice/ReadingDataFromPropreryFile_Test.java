package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadingDataFromPropreryFile_Test 
{
	public static void main(String[] args) throws IOException 
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commenData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String Browser = pObj.getProperty("browser");
		String Url = pObj.getProperty("url");
		String UN = pObj.getProperty("username");
		String PWD = pObj.getProperty("password");
	
	System.out.println(Browser+" "+Url+" "+UN+" "+PWD);
	
	WebDriver driver=new ChromeDriver();
	driver.get(Url);
	driver.findElement(By.name("user_name")).sendKeys(UN);
	driver.findElement(By.name("user_password")).sendKeys(PWD);
	driver.findElement(By.id("submitButton")).click();
	
	
	}
}
