package contact;

import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import vtiger_POM.Login_And_Logout_Vtiger;

public class CreatContact_test 
{
	@Test
	public  void creatContact_test()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notification");
		//Launching browser
		Random ran = new Random();
		int random = ran.nextInt(500);// to avoid duplicate value.
		String ecpectedvalue="Keera Bonda";
//		Launch the Application 
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		Login to the Application 
		Login_And_Logout_Vtiger log_vtiger = new Login_And_Logout_Vtiger(driver);
		log_vtiger.login("admin", "admin");
//		"Navigate to Homepage click on 'Contacts' link"
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
//		Click on create Contact lookup button 
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
//		Enter 'Last Name' text field
		driver.findElement(By.name("lastname")).sendKeys("hello");
//		Click on 'Organization Name' Lookup image
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@align='absmiddle']")).click();
//		Enter 'Organization Name' in search field
		@Nullable
		String parentTitle = driver.getTitle();
		String parentwindow = driver.getWindowHandle();
		Set<String> childwind = driver.getWindowHandles();
		
		@Nullable
		String childtitle = null;
		for(String window:childwind)
			childtitle=driver.switchTo().window(window).getTitle();
		if(!childtitle.equals(parentTitle))
		{
			driver.findElement(By.name("search_text")).sendKeys("testyantra");
			driver.findElement(By.name("search")).click();
//			Click on 'Organization Name'
			driver.findElement(By.xpath("//tr[@bgcolor='white']/td/a[text()='Testyantra']")).click();
		}
		//switch back to parent window
		driver.switchTo().window(parentwindow);
//		click on 'save'button
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
	
//		Click on 'Administrator
		log_vtiger.signOut(driver);
		driver.quit();
	}
}
