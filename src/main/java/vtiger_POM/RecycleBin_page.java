package vtiger_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecycleBin_page 
{
	@FindBy(xpath = "//input[@name='selectall']") private WebElement all_chbox;
	@FindBy(xpath = "(//input[@value='Restore'])[1]") private WebElement restore_btn;
	@FindBy(xpath = "//input[@id='search_url']/following-sibling::input[@value='Empty Recycle Bin']") private WebElement emtRecycle_btn;
	
	//initialization 
	public RecycleBin_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	 // creating public service methods

	public WebElement getAll_chbox() {
		return all_chbox;
	}

	public WebElement getRestore_btn() {
		return restore_btn;
	}

	public WebElement getEmtRecycle_btn() {
		return emtRecycle_btn;
	}
	



}
