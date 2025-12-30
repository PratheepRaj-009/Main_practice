package vtiger_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateDoc_page 
{
	@FindBy(xpath = "//img[@alt='Create Document...']") private WebElement createDocLookup_btn;
	
	public CreateDoc_page(WebDriver driver )
	{
		PageFactory.initElements(driver, this);
	}
	
	//getter method

	public WebElement getCreateDocLookup_btn() {
		return createDocLookup_btn;
	}
	
	//business logic
	public void clikOnLookupbtn()
	{
		createDocLookup_btn.click();
	}
}
