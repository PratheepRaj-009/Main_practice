package vtiger_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProduct_page 
{
	@FindBy(xpath="//img[@alt='Create Product...']") private WebElement cteateProductLookup_btn;
	
	public CreateProduct_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//getter method
	public WebElement getCteateProductLookup_btn() 
	{
		return cteateProductLookup_btn;
	}
	
	//business logic 
	public void createProdyctLookUp()
	{
		cteateProductLookup_btn.click();
	}
	
	
}
