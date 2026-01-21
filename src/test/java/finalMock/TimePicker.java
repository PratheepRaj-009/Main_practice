package finalMock;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TimePicker 
{
	public static void main(String[] args) 
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/ui?scenario=1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//section[contains(.,'Date & Time Picker')]")).click();
		driver.findElement(By.xpath("//section[.='Time Picker']")).click();
		WebElement clock = driver.findElement(By.xpath("//*[name()='svg' and @data-testid='ClockIcon']"));
		if(clock.isEnabled())
		clock.click();
		List<WebElement> setTime = driver.findElements(By.xpath("//li[@aria-label='4 hours']|//li[@aria-label='15 minutes']|//button[text()='OK']|//li[@aria-label='PM']"));
		for(WebElement time:setTime)
		{
			time.click();
		}
		
		System.out.println(driver.findElement(By.xpath("//input[@placeholder='hh:mm aa']")).getAttribute("value"));
	}
}
