package vtiger_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyPreferance_page 
{
	//declaration
	@FindBy(xpath = "//input[@value='Change Password']") private WebElement ChangePWD_btn;
	@FindBy(name = "new_password") private WebElement NewPWD_txtfld;
	@FindBy(name = "confirm_new_password") private WebElement CnfmNewPWD_txtfld;
	
	//initialization
	
	public MyPreferance_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getChangePWD_btn() {
		return ChangePWD_btn;
	}

	public WebElement getNewPWD_txtfld() {
		return NewPWD_txtfld;
	}

	public WebElement getCnfmNewPWD_txtfld() {
		return CnfmNewPWD_txtfld;
	}
	
	
}
