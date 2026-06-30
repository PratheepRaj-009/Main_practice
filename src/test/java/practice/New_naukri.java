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
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//@Listeners(genric_utilities.ListernersImplementationClass.class)

import genric_utilities.WebdriverUtilities;
public class New_naukri 
{
	WebdriverUtilities wUtils=new WebdriverUtilities();
	@Test
	public void updateResume() throws InterruptedException, AWTException {
		
		String expected="Resume has been successfully uploaded.";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Actions act=new Actions(driver);
		driver.findElement(By.id("login_Layer")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']")).sendKeys("pratheep.te09@gmail.com");
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
			String path = System.getProperty("user.dir")+".src/test/resources/files/Pratheep_Raj_te09.pdf";
			WebElement update = driver.findElement(By.xpath("(//input[@type='file'])[1]"));
			update.sendKeys(path);
			Thread.sleep(6000);
			
//			StringSelection ss=new StringSelection("\"C:\\Users\\PRATHEEP RAJ S\\OneDrive\\Desktop\\Tek Resume\\fresh\\pratheepkumar561.docx\"");
//			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//			System.out.println("fghj");
//			Robot rbt=new Robot();
//			Thread.sleep(3000);
//			//act.sendKeys(Keys.CONTROL+"v",Keys.ENTER).perform();
//			rbt.keyPress(KeyEvent.VK_CONTROL);
//			rbt.keyPress(KeyEvent.VK_V);
//			rbt.keyRelease(KeyEvent.VK_V);
//			rbt.keyRelease(KeyEvent.VK_CONTROL);
//			Thread.sleep(2000);
//			rbt.keyPress(KeyEvent.VK_ENTER);
//			rbt.keyRelease(KeyEvent.VK_ENTER);
			
			String actual = driver.findElement(By.xpath("//p[@class='msg']")).getText();
			
			System.err.println(actual);
			Assert.assertEquals(actual, expected);
			
			System.out.println("end");
			
		}
		}
		catch(Exception e)
		{
		if(driver.findElement(By.xpath("//input[@value='Update resume']")).getAttribute("value").equals("Update resume"))
		{
			String path = System.getProperty("user.dir")+".src/test/resources/files/Pratheep_Raj_te09.pdf";
			WebElement update = driver.findElement(By.xpath("(//input[@type='file'])[1]"));
			update.sendKeys(path);
//			StringSelection ss=new StringSelection("\"C:\\Users\\PRATHEEP RAJ S\\OneDrive\\Desktop\\Tek Resume\\fresh\\pratheepkumar561.docx\"");
//			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//			System.out.println("update starts");
//			Robot rbt=new Robot();
//			Thread.sleep(3000);
//			rbt.keyPress(KeyEvent.VK_CONTROL);
//			rbt.keyPress(KeyEvent.VK_V);
//			rbt.keyRelease(KeyEvent.VK_V);
//			rbt.keyRelease(KeyEvent.VK_CONTROL);
//			Thread.sleep(2000);
//			rbt.keyPress(KeyEvent.VK_ENTER);
//			rbt.keyRelease(KeyEvent.VK_ENTER);
			String actual = driver.findElement(By.xpath("//p[@class='msg']")).getText();
			System.err.println(actual);
			Assert.assertEquals(actual, expected);
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
		driver.quit();
	
	
	}
}
