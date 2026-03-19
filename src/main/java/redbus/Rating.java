package redbus;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Rating 
{
	@FindBy(xpath = "//li[@class='tupleWrapper___16efd2 undefined     ']//div[@class='rating___2f8ca2' and text()>4]") private List<WebElement> ratings;
	public Rating(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> getRate()
	{
		return ratings;
	}
	
	public void getHighestRating() throws InterruptedException
	{
		WebElement rate1 = null;
		double larg=1;
		int size = ratings.size();
		for(int i=0; i<size; i++)
		{
			WebElement rate = ratings.get(i);
			Thread.sleep(3000);
			Thread.sleep(10000);
			String text = rate.getDomAttribute("aria-label");
			String sub = text.substring(0,4);
			double no=Double.parseDouble(sub);
			
			if(larg>no)
			{
				larg=no;
				rate1=rate;
				System.out.println(text);
			}
			
		}
		rate1.click();
	}
}
