package vtiger_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Settings_page 
{
	@FindBy(xpath = "//a[contains(.,'Currencies')]") private WebElement currencies_link;
	
	public Settings_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCurrencies_link() {
		return currencies_link;
	}
	
	//business logic 
		public void ckickOnCurrencies()
		{
			currencies_link.click();
		}
}
