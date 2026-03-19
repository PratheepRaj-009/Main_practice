package practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import genric_utilities.PropFileUtils;
import genric_utilities.WebdriverUtilities;

public class LinkedIn_Resume_Upload
{
	static PropFileUtils pUtils=new PropFileUtils();
	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.linkedin.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//a[contains(.,'Sign in with email')]")).click();
		driver.findElement(By.id("username")).sendKeys(pUtils.readDataFromResPropertyFile("linkusername"));
		driver.findElement(By.id("password")).sendKeys(pUtils.readDataFromResPropertyFile("password"));
		driver.findElement(By.xpath("//button[@data-litms-control-urn='login-submit']")).click();
		try {
			driver.findElement(By.id("ember17")).click();
			
		}
		catch(Exception e)
		{
			driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border'and @role='presentation']")).click();
			driver.findElement(By.id("ember17")).click();
		}
		
		driver.findElement(By.xpath("//a[contains(.,'Settings & Privacy')]")).click();
		driver.findElement(By.xpath("//p[text()='Data privacy']")).click();
		WebElement job = driver.findElement(By.xpath("//h2[contains(.,'Job seeking')]"));
		Actions ac = new Actions(driver);
		ac.scrollToElement(job).perform();
		driver.findElement(By.xpath("//p[contains(.,'Resumes and job applications data')]")).click();
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("gud morning");
		String path = System.getProperty("user.dir")+"/src/test/resources/files/Pratheepraj-S Automation (2).pdf";
		WebElement ele = driver.findElement(By.xpath("//input[@type='file']"));
		ele.sendKeys(path);
		driver.findElement(By.xpath("(//*[name()='svg' and @class='jobs-resume-card__ellipsis-icon'])[2]")).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		/*WebElement del = */driver.findElement(By.xpath("//*[name()='svg']//*[name()='use' and @href='#trash-medium']")).click();
		//js.executeScript("arguments[0].click()", del);
		
		String text = driver.findElement(By.xpath("//div[@class='jobs-application-settings__back']/following-sibling::h1")).getText();
		System.out.println(text);
		Thread.sleep(5000);
		driver.quit();
	
	}
}
