package worldOMeter_pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WorldPopulation 
{
	@FindBy(xpath = "//h2[@id='country']/following-sibling::div[@class='not-prose']//a") private List<WebElement> countryTbl;

	public WorldPopulation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void searchingCountry(WebDriver driver, String expValue)
	{
		for(; ;)
		{
			for(WebElement count:countryTbl)
			{
				String text = count.getText();
				//System.out.println(text);

				if(expValue.contains(text))
				{
				
					count.click();
					System.out.println(text+"  is opened");
					return;
					//driver.quit();
				}

			}
			driver.findElement(By.xpath("//button[text()='›']")).click();
		}
	}
}
