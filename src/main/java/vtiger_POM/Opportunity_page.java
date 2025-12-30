package vtiger_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Opportunity_page 
{
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']") private WebElement createOpportunityLookup_btn;
	
	
	public Opportunity_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getCreateOpportunityLookup_btn() {
		return createOpportunityLookup_btn;
	}
	
	public void CreateOpportunityLookupButton()
	{
		createOpportunityLookup_btn.click();
	}
}
