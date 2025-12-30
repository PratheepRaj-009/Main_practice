package practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genric_utilities.Flipkart_BaseClass;
@Listeners(genric_utilities.FlipkartListernersImplementationClass.class)
public class Ecommers_test extends Flipkart_BaseClass
{
	 SoftAssert sa = new SoftAssert();
		//public WebDriver driver;
		
		
		
		@Test
		public void flipkart()
		{
			String expTitle="Online Shopping India Mobile, Cameras, Lifestyle & more Online @ Flipkart.com";
			//driver=new ChromeDriver();
			
		//	driver.get("https://www.flipkart.com");
			String actTitle = driver.getTitle();
			System.out.println(actTitle);
		//	sa.assertEquals(expTitle, actTitle);
			System.out.println("flipkart test pass");
			//Assert.assertTrue(expTitle.startsWith("Online Shopping India"));
			//Assert.fail();
			
		}
}
