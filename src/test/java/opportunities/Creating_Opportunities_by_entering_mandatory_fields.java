package opportunities;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import genric_utilities.BaseClass;
import vtiger_POM.CreateNewOpportunity_page;
import vtiger_POM.Login_And_Logout_Vtiger;
import vtiger_POM.Opportunity_page;

public class Creating_Opportunities_by_entering_mandatory_fields extends BaseClass
{
	@Test
	public void creating_Opportunities_by_entering_mandatory_fields() 
	{
		String opportunities="Qspiders";
		String organization = "Testyantra";
//		//step 1:launching browser
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("http://localhost:8888/");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		//step 2: login to application 
//		Login_And_Logout_Vtiger vpom = new Login_And_Logout_Vtiger(driver);
//		vpom.login("admin", "admin");
		//"Navigate to Homepage click on 'OPPORTUNITIES'link"
		driver.findElement(By.xpath("//td[@align='center']/a[text()='Opportunities']")).click();
		//Click on create Opportunities lookup button 
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		String expTitle="Accounts&action";
		Opportunity_page opPg = new Opportunity_page(driver);
		opPg.CreateOpportunityLookupButton();
		CreateNewOpportunity_page createOpPg = new CreateNewOpportunity_page(driver);
		createOpPg.createOpportunity(driver, opportunities, expTitle, "orgname");
		
		
		//Enter valid data into Opportunity Name fields
		driver.findElement(By.cssSelector("input[name='potentialname']")).sendKeys(opportunities);
		//"Click on 'Related to' dropdown and select 'Organization'"
		Select slt = new Select(driver.findElement(By.id("related_to_type")));
		slt.selectByContainsVisibleText("Organizations");
		//getting parent window
		String parent_id = driver.getWindowHandle();
		String parent_title = driver.getTitle();
		//Click on 'Related to' field's 'Select' lookup button
		driver.findElement(By.xpath("//input[@name='related_to_display']/following-sibling::img[@src=\"themes/softed/images/select.gif\"]")).click();
		//getting child window id
		Set<String> children = driver.getWindowHandles();
		for (String child:children)
		{
			String childtitle = driver.switchTo().window(child).getTitle();
			if(!childtitle.equals(parent_title))
			{
				System.out.println("child");
				driver.findElement(By.xpath("//a[contains(.,'Testyantra')]")).click();
				
			}
			else
			{
				System.out.println("parent");
			}
			
		}
		//switch back to parent window
		
		driver.switchTo().window(parent_id);
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/Home.PNG']")).click();
		//click on 'save'button
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//.signOut(driver);
		
	}
}




