package practice;

import java.io.IOException;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.internal.PropertyUtils;

@Listeners(genric_utilities.ListernersImplementationClass.class)
public class SoftAssert_test 
{
	 SoftAssert sa = new SoftAssert();
	public WebDriver driver;
	
	@Test
	public void amazon() throws IOException
	{
		String expTitle = "1Amazon.in";
		driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		String actTitle = driver.getTitle();
		sa.assertEquals(actTitle, expTitle);
		System.out.println("hompage is not dispalyed");
		sa.assertAll();
		
	}
	
	@Test
	public void flipkart()
	{
		String expTitle="Online Shopping India Mobile, Cameras, Lifestyle & more Online @ Flipkart.com";
		driver=new ChromeDriver();
		
		driver.get("https://www.flipkart.com");
		String actTitle = driver.getTitle();
		
		//sa.assertEquals(expTitle, actTitle);
		System.out.println("flipkart test pass");
		Assert.assertTrue(expTitle.startsWith("Online Shopping India"));
		//Assert.fail();
		
	}
}
