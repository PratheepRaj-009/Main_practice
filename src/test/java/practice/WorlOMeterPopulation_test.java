package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import genric_utilities.WebdriverUtilities;
import worldOMeter_pom.WorldPopulation;

public class WorlOMeterPopulation_test 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		
		try {
		WebdriverUtilities wdu = new WebdriverUtilities();
		String expValue = "  Kazakhstan  ";
		
		wdu.maximizeWindow(driver);
		driver.navigate().to("https://www.worldometers.info/world-population/");
		wdu.implicitWait(driver, Duration.ofSeconds(10));
		WebElement country = driver.findElement(By.id("country"));
		wdu.scrollToElementUsingXandYcoOrdinats(driver, country);
		//driver.findElement(By.cssSelector("input[title='Search within table']")).sendKeys(expValue);
		WorldPopulation wp = new WorldPopulation(driver);
		wp.searchingCountry(driver, expValue);
		}
		finally
		{
			driver.quit();
		}
		
		
	}
	
}

/*List<WebElement> countries = driver.findElements(By.xpath("//h2[@id='country']/following-sibling::div[@class='not-prose']//a"));
		for(; ;)
		{
		for(WebElement count:countries)
		{
			String text = count.getText();
			
			
			if(text.equals(expValue))
			{
				System.out.println(expValue+" -->is present");
//				System.out.println(text);
//				count.click();
				break;
				//driver.quit();
			}
			
		}
		driver.findElement(By.xpath("//button[text()='›']")).click();
	}*/