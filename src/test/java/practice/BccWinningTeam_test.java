package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BccWinningTeam_test 
{
	public static void main(String[] args)
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(" https://www.bbc.com/sport/olympics/paris-2024/medals ");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[text()='Medal results']")).click();
		WebElement gameDD = driver.findElement(By.id("discipline-selector"));
		String expSport="Beach Volleyball";
		Select s=new Select(gameDD);
		List<WebElement> opts = s.getOptions();
		for(WebElement opt:opts)
		{
			
			List<WebElement> countries;
			String text = opt.getText();
			if(expSport.equals(text))
			{
			opt.click();
			
			try
			{
				driver.findElement(By.xpath("//div[@class='ssrcss-7dafha-DesktopNames e1dg50ic3']/div[@class='ssrcss-1n8wi18-SecondaryName e1dg50ic0']"));
				countries = driver.findElements(By.xpath("//div[@class='ssrcss-7dafha-DesktopNames e1dg50ic3']/div[@class='ssrcss-1n8wi18-SecondaryName e1dg50ic0']"));
				for(WebElement country:countries)
				{
					System.out.println(country.getText());
				}
			}
			catch (Exception e) 
			{
			
				countries=driver.findElements(By.xpath("//div[contains(@class,'ssrcss-7da')]/div"));
				for(WebElement country:countries)
				{
					System.err.println(country.getText());
				}
			
			}

			}

		}
	}


}

/*WebElement gameDD = driver.findElement(By.id("discipline-selector"));
		Select s=new Select(gameDD);
		List<WebElement> opts = s.getOptions();
		for(WebElement opt:opts)
		{
		//System.out.println( opt.getText());
		opt.click();

		 List<WebElement> countries = driver.findElements(By.xpath("//div[@class='ssrcss-7dafha-DesktopNames e1dg50ic3']/div[@class='ssrcss-1n8wi18-SecondaryName e1dg50ic0']"));

		for(WebElement country:countries)
		{
			String countryName = country.getText();
			if(countryName!=null)
			{
			System.out.println(countryName);
			}
			else if(countryName==null)
			{
				System.err.println("im else");
			}

		}
		System.out.println("******");
		}

		driver.quit();
 */