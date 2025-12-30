package vtiger_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewDoc_page 
{	
	//declaration
	@FindBy(name="notes_title") private WebElement title_txtfld;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]") private WebElement save_btn;
	
	//initialization
	
	public CreateNewDoc_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//creating public service methods-getters
	public WebElement getTitle_txtfld() {
		return title_txtfld;
	}

	public WebElement getSave_btn() {
		return save_btn;
	}
	
	//business logic 
	public void creatNewDocument(String DocName)
	{
		title_txtfld.sendKeys(DocName);
		save_btn.click();
		
	}
	
}
