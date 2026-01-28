package practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Naukri_com 
{
	@Test
	public void updateResume() throws InterruptedException, AWTException {
		

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions act=new Actions(driver);
		driver.findElement(By.id("login_Layer")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']")).sendKeys("pratheep.sv4009@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys("Stalliin@1");
		driver.findElement(By.xpath("//button[text()='Login']")).submit();
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		try {
			driver.findElement(By.xpath("//a[@href='/mnjuser/profile']")).click();
		
		}
		catch(Exception e)
		{
			driver.findElement(By.xpath("//div[contains(@class,'crossIcon')]")).click();
			driver.findElement(By.xpath("//a[@href='/mnjuser/profile']")).click();
		}
		
		act.scrollToElement(driver.findElement(By.xpath("//div[@class='widgetHead']/span[text()='Resume headline']"))).perform();
		try {
		if(driver.findElement(By.xpath("//span[text()='Upload resume']")).getText().contains("Upload resume"))
		{
			driver.findElement(By.xpath("//span[text()='Upload resume']")).click();
			StringSelection ss=new StringSelection("C:\\Users\\PRATHEEP RAJ S\\Downloads\\Pratheepraj-S Automation (1).pdf");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			System.out.println("fghj");
			Robot rbt=new Robot();
			Thread.sleep(3000);
			//act.sendKeys(Keys.CONTROL+"v",Keys.ENTER).perform();
			rbt.keyPress(KeyEvent.VK_CONTROL);
			rbt.keyPress(KeyEvent.VK_V);
			rbt.keyRelease(KeyEvent.VK_V);
			rbt.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(2000);
			rbt.keyPress(KeyEvent.VK_ENTER);
			rbt.keyRelease(KeyEvent.VK_ENTER);
			System.out.println("end");
			
		}
		}
		catch(Exception e)
		{
		if(driver.findElement(By.xpath("//input[@value='Update resume']")).getAttribute("value").equals("Update resume"))
		{
//			System.out.println("sdfgh");
//			WebElement btn = driver.findElement(By.xpath("//input[@value='Update resume']"));
//			//jse.executeScript("arguments[0].click();",btn);
//			act.sendKeys(btn,"C:\\Users\\PRATHEEP RAJ S\\Downloads\\might-guy-n2xmbymd7tjjcav0.jpgss").perform();
		
			driver.findElement(By.xpath("//input[@value='Update resume']")).click();
			StringSelection ss=new StringSelection("C:\\Users\\PRATHEEP RAJ S\\Downloads\\Pratheepraj-S Automation (1).pdf"
					+ "");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			System.out.println("update starts");
			Robot rbt=new Robot();
			Thread.sleep(3000);
			//act.sendKeys(Keys.CONTROL+"v",Keys.ENTER).perform();
			rbt.keyPress(KeyEvent.VK_CONTROL);
			rbt.keyPress(KeyEvent.VK_V);
			rbt.keyRelease(KeyEvent.VK_V);
			rbt.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(2000);
			rbt.keyPress(KeyEvent.VK_ENTER);
			rbt.keyRelease(KeyEvent.VK_ENTER);
			System.out.println("update end");
		
		}
		else
		{
			System.out.println("iam else");
		}
		}
//		else
//		{
//			System.out.println("can't upload resume");
//		}
//		//driver.findElement(By.linkText("Yes, upload new")).click();
		//driver.switchTo().alert().accept();
		//driver.close();
	
		Thread.sleep(5000);
		//driver.quit();
	
	
	}
}
