package practice;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genric_utilities.BaseClass;

@Listeners(genric_utilities.ListernersImplementationClass.class)
public class HardAssert_test extends BaseClass
{
	@Test
	public void test1()
	{
		System.out.println("*** Step 1 ***");
		System.out.println("*** Step 2 ***");
		Assert.assertEquals("A", "A");
		System.out.println("*** Step 3 ***");
		Assert.assertEquals("a", "A");
		System.out.println("*** Step 4 ***");
	}
	
	@Test
	public void test2()
	{
		int a=10;
		System.out.println("*** Step 5 ***");
		System.out.println("*** Step 6 ***");
		Assert.assertNull(a);
		System.out.println("*** Step 7 ***");
		System.out.println("*** Step 8 ***");

	}
	
	@Test
	public void flipkart()
	{
		String expTitle="Online Shopping India Mobile, Cameras, Lifestyle & more Online @ Flipkart.com";
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com");
		String actTitle = driver.getTitle();
		
		Assert.assertEquals(expTitle, actTitle);
		System.out.println("flipkart test pass");
		Assert.assertTrue(expTitle.startsWith("Online Shopping India"));
		System.out.println("Yess it is Starts with--->Online Shopping India ");
		
		
	}
}

