package vtiger_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization_page 
{
	//declaration 
	@FindBy(xpath = "//img[@alt='Create Organization...']") private WebElement create_Org_lookup_btn;
	
	//initialization
	public Organization_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//step:3 creating public service methods
	public WebElement getCreate_Org_btn() {
		return create_Org_lookup_btn;
	}
	
	public void clickOrganizationLookupBtn()
	{
		create_Org_lookup_btn.click();
	}
	
	
	
	
	
	
	
	
}
