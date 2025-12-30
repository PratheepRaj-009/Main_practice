package vtiger_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Currencies_page 
{
	//declaration
	
	@FindBy(xpath = "//input[@value='New Currency']") private WebElement newCurrency_btn;
	@FindBy(xpath = "//a[text()='Settings']") private WebElement SettingsBack_link;
	
	//initialization
	public Currencies_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//creating public service methods
	public WebElement getNewCurrency_btn() {
		return newCurrency_btn;
	}
	public WebElement getSettingsBack_link() {
		return SettingsBack_link;
	}
	
	//business logic
	public void clickOnNewCurrency()
	{
		newCurrency_btn.click();	
	}
	
}
