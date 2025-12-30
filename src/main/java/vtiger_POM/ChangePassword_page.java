package vtiger_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genric_utilities.WebdriverUtilities;

public class ChangePassword_page 
{
	//declaration
	
	@FindBy(xpath = "//input[@value='Change Password']") private WebElement changePpaaword_btn;
	@FindBy(name="new_password") private WebElement newPwd_txtfield;
	@FindBy(name="confirm_new_password")private WebElement conPWD_txtfld;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")private WebElement save_btn;
	
	
	//initialization
	public  ChangePassword_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getChangePpaaword_btn() {
		return changePpaaword_btn;
	}
	public WebElement getNewPwd_txtfield() {
		return newPwd_txtfield;
	}
	public WebElement getConPWD_txtfld() {
		return conPWD_txtfld;
	}
	public WebElement getSave_btn() {
		return save_btn;
	}
	
	//business logic
	public void changeNewPassword(WebdriverUtilities wdu,WebDriver driver, String exptitle, String newPwd,String conPwd)
	{
		changePpaaword_btn.click();
		wdu.switchToChildWindow(driver, exptitle);
		newPwd_txtfield.sendKeys(newPwd);
		conPWD_txtfld.sendKeys(conPwd);
		save_btn.click();
	}
	
}
