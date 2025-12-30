package vtiger_POM;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genric_utilities.WebdriverUtilities;

public class CreateNewOpportunity_page extends WebdriverUtilities
{

	@FindBy(name = "input[name='potentialname']") private WebElement opportunityName_txtfld;
	@FindBy(id ="related_to_type") private WebElement relatedTo_txtfld;
	@FindBy(name = "search_text") private WebElement search_txtfld;
	@FindBy(name = "search") private WebElement search_btn;
	
	
	public CreateNewOpportunity_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createOpportunity(WebDriver driver, String OpportunityName , String exptitle, String orgName )
	{
		String parentId = driver.getWindowHandle();
		
		opportunityName_txtfld.sendKeys(OpportunityName);
		relatedTo_txtfld.click();
		switchToChildWindow(driver,exptitle);
		search_txtfld.sendKeys(orgName);
		search_btn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		try
		{
		driver.switchTo().alert().accept();
		switchToParentWindow(driver, parentId);
		}
		catch (Exception e) 
		{	
			
			switchToParentWindow(driver, parentId);
		}
		
	}
}
