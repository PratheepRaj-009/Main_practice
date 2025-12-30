package vtiger_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genric_utilities.WebdriverUtilities;

public class CreateNewProduct_page extends WebdriverUtilities
{
	@FindBy(name="productname") private WebElement  productName_txtfld;
	@FindBy(xpath="//input[@title='Save [Alt+S]']") private WebElement save_btn;
	
	public CreateNewProduct_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	public WebElement getProductName_txtfld()
	{
		return productName_txtfld;
	}
	public WebElement getSave_btn() {
		return save_btn;
	}
	
	//business logic 
	public void addProduct(WebDriver driver ,String product)
	{
		productName_txtfld.sendKeys(product);
		save_btn.click();
		//waitUntilTheElementIsDisappear(driver,save_btn );
		
	}
}
