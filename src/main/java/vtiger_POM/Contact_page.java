package vtiger_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Contact_page 
{

	@FindBy(xpath = "//img[@alt='Create Contact...']") private WebElement createContactLoockUp_btn;
	
	public Contact_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateContactLoockUp_btn() {
		return createContactLoockUp_btn;
	}
	
	
	//business logic
	
	public void ClickCreateContactLoockUpButton()
	{
		createContactLoockUp_btn.click();
	}
}
