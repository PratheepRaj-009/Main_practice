package vtiger_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genric_utilities.WebdriverUtilities;

public class NewCurrency_page extends WebdriverUtilities
{
	//declaration
	@FindBy(id="currency_name") private WebElement currencyName_DD;
	@FindBy(name="conversion_rate") private WebElement conveRate_txtfld;
	@FindBy(xpath = "//input[@title='Save']") private WebElement save_btn;
	@FindBy(xpath="//b//a[contains(.,'Currencies')]") private WebElement backToCurrency_link;
	@FindBy(xpath="//b//a[contains(.,'Settings')]") private WebElement backToSettings_link;
	
	//initialization 
	public NewCurrency_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//  creating public service methods

	public WebElement getCurrencyName_DD() {
		return currencyName_DD;
	}

	public WebElement getConveRate_txtfld() {
		return conveRate_txtfld;
	}

	public WebElement getSave_btn() {
		return save_btn;
	}

	public WebElement getBackToCurrency_link() {
		return backToCurrency_link;
	}

	public WebElement getBackToSettings_link() {
		return backToSettings_link;
	}

	//business logic
	
	public void addNewCurrency(String country,String value)
	{
		selectByVisibleText(currencyName_DD, country);
		conveRate_txtfld.sendKeys(value);
		save_btn.click();
		
		
	}
	
	
}

